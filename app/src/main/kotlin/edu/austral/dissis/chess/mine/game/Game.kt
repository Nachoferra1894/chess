package game

import edu.austral.dissis.chess.mine.game.CommonEndGameController
import edu.austral.dissis.chess.mine.game.InitialGameState
import edu.austral.dissis.chess.mine.game.PieceController
import generatos.BoardGenerator
import generatos.PlayerGenerator
import pieces.MovementValidator
import pieces.Piece
import pieces.PieceColor
import pieces.PieceName
import pieces.chessPieces.King
import pieces.chessPieces.Rook
import players.Player
import rules.RuleController
import squares.Square

class Game() {
    private val playerGenerator: PlayerGenerator = PlayerGenerator()
    private val movementValidator: MovementValidator = MovementValidator()
    private val turnController: TurnController = TurnController()
    private val pieceController: PieceController = PieceController()
    private val boardGenerator: BoardGenerator = BoardGenerator()
    private val commonEndGameController: CommonEndGameController = CommonEndGameController()


    private lateinit var players: List<Player>
    private lateinit var player2: Player
    private val ruleController = RuleController()
    private var cols = 0;
    private var rows = 0;


    fun startGame(
        cols: Int,
        rows: Int,
        player1Color: PieceColor,
        player2Color: PieceColor,
        player1Name: String,
        player2Name: String
    ): InitialGameState {
        if (player1Color == player2Color) {
            throw IllegalArgumentException("Both players can't use the same color")
        }
        this.rows = rows;
        this.cols = cols
        players = listOf(
            playerGenerator.createPlayer(player1Name, player1Color),
            playerGenerator.createPlayer(player2Name, player2Color)
        )

        val pieces = pieceController.generatePieces(player1Color, player2Color)
        boardGenerator.createBoard(cols, rows, pieces)
        turnController.initTurns(PieceColor.WHITE)
        return InitialGameState(rows, cols, pieces, PieceColor.WHITE)
    }

    fun getPlayerToMove(): Player {
        return players[turnController.getPlayerTurn()]
    }

    fun movePiece(sqFrom: Square, sqTo: Square): GameFinisher {
        if (sqFrom.getColumn() == sqTo.getColumn() && sqFrom.getRow() == sqTo.getRow()) {
            throw IllegalArgumentException("Can't move to the same square")
        }

        val playerToMove = getPlayerToMove()

        val pieceToMove =
            pieceController.getPieceInSquare(sqFrom) ?: throw IllegalArgumentException("Square doesn't have a piece")

        if (pieceToMove.getColor() !== playerToMove.getColor()) {
            throw IllegalArgumentException("Piece not from that color")
        }
        if (movementValidator.isMoveOutOfBoard(rows, cols, sqTo)) {
            throw IllegalArgumentException("Move out of board!")
        }

        val allPieces = pieceController.getPieces();
        val otherColorPieces = pieceController.getPiecesNotFromColor(playerToMove.getColor());

        val king: King = pieceController.getKingPosition(playerToMove.getColor());

        val eatenPiece = pieceController.getPieceInSquare(sqTo)
        var castlePosition: Square? = null
        val rookForCastle: Rook? = pieceController.getCastleNearestRook(pieceToMove, sqTo, rows, cols)
        if (rookForCastle != null){
            castlePosition = movementValidator.checkForCastle(
                allPieces,
                sqFrom,
                sqTo,
                pieceToMove,
                rookForCastle
            )
        }
        if (castlePosition === null && !movementValidator.isMovePossible(
                allPieces,
                sqFrom,
                sqTo,
                pieceToMove,
                eatenPiece
            )
        ) {
            throw IllegalArgumentException("${pieceToMove.getName()} can't move to ${sqTo.getColumn()}:${sqTo.getRow()}")
        }

        // to check if the move avoids the check
        if(castlePosition === null) pieceController.movePieceToSquare(sqTo, pieceToMove)
        // Because the castling can't avoid the check
        if (ruleController.checkForCheck(king, otherColorPieces, allPieces, eatenPiece)) {
            // If it does not, go back to that square
            pieceController.movePieceToSquare(sqFrom, pieceToMove)
            throw IllegalArgumentException("${playerToMove.getColor()} is on Check")
        }
        if (castlePosition !== null && rookForCastle !== null){
            pieceController.movePieceToSquare(sqTo, pieceToMove)
            pieceController.movePieceToSquare(castlePosition, rookForCastle)
        }
        if (eatenPiece !== null) {
            if (eatenPiece.getName() === PieceName.KING) {
                pieceController.movePieceToSquare(sqFrom, pieceToMove)
                throw IllegalArgumentException("Can't eat the king!")
            } else eatenPiece.hasBeenEaten()
        }

        if (ruleController.checkForPromotion(pieceToMove, sqTo, rows)) {
            pieceController.promotePiece(pieceToMove, PieceName.QUEEN) // TODO maybe add a selector
        }
        val nextPlayerToMove = players[turnController.changePlayerTurn()]
        val nextKing: King = pieceController.getKingPosition(nextPlayerToMove.getColor());
        if (pieceToMove.getName() === PieceName.PAWN) {
            nextKing.resetMoves()
        }

        val thisColorPieces: List<Piece> = pieceController.getPiecesFromColor(playerToMove.getColor());
        // Agregar un end game validator que adentro haga las validaciones de chack mate y todo eso
        if (ruleController.checkForTie(nextKing, allPieces, nextPlayerToMove.getColor())) {
            return GameFinisher(true, null)
        }
        if (commonEndGameController.hasPlayerWon(nextKing,otherColorPieces,allPieces,pieceController,movementValidator,rows,cols)) {
            return GameFinisher(true, playerToMove.getColor())
        }
        if (commonEndGameController.isATie(nextKing, allPieces, nextPlayerToMove.getColor())) {
            return GameFinisher(true, null)
        }
        return GameFinisher(false)
    }

    fun offerStaleMate(): GameFinisher {
        val nextPlayerToMove: Player = players[turnController.changePlayerTurn()]
        return GameFinisher(nextPlayerToMove.respondStaleMate())
    }

    fun resign(): GameFinisher {
        val nextPlayerToMove: Player = players[turnController.changePlayerTurn()]
        return GameFinisher(true, nextPlayerToMove.getColor())
    }

    fun getPieces(): List<Piece> {
        return pieceController.getPieces();
    }
}