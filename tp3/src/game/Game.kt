package game

import generatos.BoardGenerator
import generatos.PieceGenerator
import generatos.PlayerGenerator
import pieces.MovementValidator
import pieces.Piece
import pieces.PieceColor
import pieces.PieceName
import players.Player
import rules.RuleController
import squares.Board
import squares.Square

class Game(private val cols: Int, private val rows: Int) {
    private val boardGenerator: BoardGenerator = BoardGenerator()
    private val playerGenerator: PlayerGenerator = PlayerGenerator()
    private val pieceGenerator: PieceGenerator = PieceGenerator()
    private val gameFinisher: GameFinisher = GameFinisher()
    private val movementValidator: MovementValidator = MovementValidator()
    private val turnController: TurnController = TurnController()

    private val pieceNames: MutableList<PieceName> = mutableListOf(PieceName.PAWN, PieceName.QUEEN, PieceName.BISHOP, PieceName.HORSE, PieceName.ROOK, PieceName.KING)
    private lateinit var pieces: List<Piece>
    private lateinit var board: Board
    private lateinit var players: List<Player>
    private lateinit var player2: Player
    private val ruleController = RuleController()


    fun startGame(player1Name: String, player2Name: String, player1Color: PieceColor, player2Color: PieceColor) {
        if (player1Color == player2Color) {
            throw UnsupportedOperationException()
        }
        players = listOf(playerGenerator.createPlayer(player1Name, player1Color), playerGenerator.createPlayer(player2Name, player2Color))

        pieces = generatePieces(player1Color, player2Color)

        board = boardGenerator.createBoard(cols, rows, pieces)
        turnController.initTurns(player1Color)

    }

    private fun generatePieces(player1Color: PieceColor, player2Color: PieceColor): List<Piece> {
        val thisPieces: MutableList<Piece> = mutableListOf();
        var currentPiece: PieceName

        for (i in 0..pieceNames.size) {
            currentPiece = pieceNames[i]
            thisPieces.add(pieceGenerator.createPiece(currentPiece, player1Color))
            thisPieces.add(pieceGenerator.createPiece(currentPiece, player2Color))
        }
        return thisPieces
    }

    fun movePiece(sqFrom: Square, sqTo: Square): Boolean {
        val playerToMove = players[turnController.getPlayerTurn()]
        if (ruleController.checkForCheck(board, sqFrom, sqTo, playerToMove.getColor())) {
            return false
        } else {
            val pieceToMove = sqFrom.getPiece() ?: return false
            if (!movementValidator.isMovePossible(board,sqFrom, sqTo, pieceToMove.getMovementRules(), pieceToMove.getExtraRules(),pieceToMove.useNoPieceCrashRule())) {
                return false
            }
            val eatenPiece = sqTo.getPiece()
            if (eatenPiece !== null) {
                eatenPiece.hasBeenEaten()
            }
            board.movePieceFromSquare(sqFrom)
            board.movePieceToSquare(sqTo, pieceToMove)
        }
        val nextPlayerToMove: Player = players[turnController.changePlayerTurn()]
        if (ruleController.checkForTie(board, nextPlayerToMove.getColor())) {
            gameFinisher.finishGameInTie()
        } else if (ruleController.checkForCheckMate(board, nextPlayerToMove.getColor())) {
            gameFinisher.finishGame(playerToMove)
        }

        return true
    }

    fun offerStaleMate(){
        val nextPlayerToMove: Player = players[turnController.changePlayerTurn()]
        if (nextPlayerToMove.respondStaleMate()){
            gameFinisher.finishGameInTie()
        }
    }

    fun resign(){
        val nextPlayerToMove: Player = players[turnController.changePlayerTurn()]
        gameFinisher.finishGame(nextPlayerToMove)
    }
}