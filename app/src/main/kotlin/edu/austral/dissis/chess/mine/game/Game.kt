package game

import edu.austral.dissis.chess.mine.game.InitialGameState
import edu.austral.dissis.chess.mine.game.PieceController
import generatos.BoardGenerator
import generatos.PlayerGenerator
import pieces.MovementValidator
import pieces.Piece
import pieces.PieceColor
import pieces.PieceName
import pieces.chessPieces.King
import players.Player
import rules.RuleController
import squares.Square

class Game() {
    private val playerGenerator: PlayerGenerator = PlayerGenerator()
    private val gameFinisher: GameFinisher = GameFinisher()
    private val movementValidator: MovementValidator = MovementValidator()
    private val turnController: TurnController = TurnController()
    private val pieceController: PieceController = PieceController()
    private val boardGenerator: BoardGenerator = BoardGenerator()

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

    fun movePiece(sqFrom: Square, sqTo: Square): Boolean {
        if (sqFrom === sqTo) {
            throw IllegalArgumentException("Can't move to the same square")
        }

        val playerToMove = getPlayerToMove()

        val pieceToMove =
            pieceController.getPieceInSquare(sqFrom) ?: throw IllegalArgumentException("Square doesn't have a piece")
        val allPieces = pieceController.getPieces();
        val otherColorPieces = pieceController.getPiecesNotFromColor(playerToMove.getColor());

        val king: King = pieceController.getKingPosition(playerToMove.getColor());

        if (pieceToMove.getColor() !== playerToMove.getColor()) {
            throw IllegalArgumentException("Piece not from that color")
        }

        if (movementValidator.isMoveOutOfBoard(rows, cols, sqTo)) {
            throw IllegalArgumentException("Move out of board!")
        }
        if (!movementValidator.isMovePossible(
                allPieces,
                sqFrom,
                sqTo,
                pieceToMove.getMovementRules(),
                pieceToMove.getExtraRules(),
                pieceToMove.useNoPieceCrashRule()
            )
        ) {
            throw IllegalArgumentException("${pieceToMove.getName()} can't move to ${sqTo.getColumn()}${sqTo.getRow()}")
        }
        val eatenPiece = pieceController.getPieceInSquare(sqTo)

        // to check if the move avoids the check
        pieceController.movePieceToSquare(sqTo, pieceToMove)
        if (ruleController.checkForCheck(king,otherColorPieces, playerToMove.getColor())) {
            // If it does not, go back to that square
            pieceController.movePieceToSquare(sqFrom, pieceToMove)
            throw IllegalArgumentException("${playerToMove.getColor()} is on Check")
        }
        if (eatenPiece !== null){
            if(eatenPiece.getColor() === pieceToMove.getColor()){
                pieceController.movePieceToSquare(sqFrom, pieceToMove)
                throw IllegalArgumentException("The piece in the square is from the same color")
            } else {
                eatenPiece.hasBeenEaten()
            }
        }
        if(ruleController.checkForPromotion(pieceToMove,sqTo,rows)){
            pieceController.promotePiece(pieceToMove,PieceName.QUEEN) // TODO maybe add a selector
        }
        val nextPlayerToMove = players[turnController.changePlayerTurn()]
        val nextKing: King = pieceController.getKingPosition(nextPlayerToMove.getColor());
        if (pieceToMove.getName() === PieceName.PAWN){
            nextKing.resetMoves()
        }

        if (ruleController.checkForTie(nextKing,allPieces, nextPlayerToMove.getColor())) {
            gameFinisher.finishGameInTie()
        } else if (ruleController.checkForCheckMate(allPieces, nextPlayerToMove.getColor())) {
            gameFinisher.finishGame(playerToMove)
        }
        return true
    }

    fun offerStaleMate() {
        val nextPlayerToMove: Player = players[turnController.changePlayerTurn()]
        if (nextPlayerToMove.respondStaleMate()) {
            gameFinisher.finishGameInTie()
        }
    }

    fun resign() {
        val nextPlayerToMove: Player = players[turnController.changePlayerTurn()]
        gameFinisher.finishGame(nextPlayerToMove)
    }

    fun getPieces(): List<Piece> {
        return pieceController.getPieces();
    }
}