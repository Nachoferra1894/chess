package game

import generatos.BoardGenerator
import generatos.PieceGenerator
import generatos.PlayerGenerator
import pieces.Piece
import pieces.PieceColor
import pieces.PieceName
import players.Player
import squares.Board

class Game(private val cols: Int, private val rows: Int) {
    private val boardGenerator: BoardGenerator = BoardGenerator()
    private val playerGenerator: PlayerGenerator = PlayerGenerator()
    private val pieceGenerator: PieceGenerator = PieceGenerator()

    private lateinit var pieces: List<Piece>
    private lateinit var board: Board
    private lateinit var player1: Player
    private lateinit var player2: Player
    private var playerTurn = 1;


    fun startGame(player1Name: String, player2Name: String, player1Color: PieceColor, player2Color: PieceColor) {
        if (player1Color == player2Color) {
            throw UnsupportedOperationException()
        }
        player1 = playerGenerator.createPlayer(player1Name, player1Color)
        player2 = playerGenerator.createPlayer(player2Name, player2Color)
        pieces = generatePieces(player1Color, player2Color)

        board = boardGenerator.createBoard(cols, rows,pieces)
        playerTurn = if(player1Color == PieceColor.WHITE) 1 else 2
    }

    private fun generatePieces(player1Color: PieceColor, player2Color: PieceColor): List<Piece> {
        val thisPieces: MutableList<Piece> = mutableListOf();

        thisPieces.add(pieceGenerator.createPiece(PieceName.PAWN, player1Color))
        thisPieces.add(pieceGenerator.createPiece(PieceName.PAWN, player2Color))

        thisPieces.add(pieceGenerator.createPiece(PieceName.QUEEN, player1Color))
        thisPieces.add(pieceGenerator.createPiece(PieceName.QUEEN, player2Color))

        thisPieces.add(pieceGenerator.createPiece(PieceName.BISHOP, player1Color))
        thisPieces.add(pieceGenerator.createPiece(PieceName.BISHOP, player2Color))

        thisPieces.add(pieceGenerator.createPiece(PieceName.HORSE, player1Color))
        thisPieces.add(pieceGenerator.createPiece(PieceName.HORSE, player2Color))

        thisPieces.add(pieceGenerator.createPiece(PieceName.ROOK, player1Color))
        thisPieces.add(pieceGenerator.createPiece(PieceName.ROOK, player2Color))

        thisPieces.add(pieceGenerator.createPiece(PieceName.KING, player1Color))
        thisPieces.add(pieceGenerator.createPiece(PieceName.KING, player2Color))

        return thisPieces
    }
}