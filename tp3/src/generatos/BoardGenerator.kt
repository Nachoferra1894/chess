package generatos

import pieces.Piece
import pieces.PieceName
import players.PieceSet
import squares.Board
import squares.PositionSquare
import squares.Square
import squares.SquareBoard

class BoardGenerator {
    private lateinit var board: Board;
    fun createBoard(columns: Int,rows: Int,pieces: List<Piece>): Board{
        board = SquareBoard(columns,rows)
        val squares = board.getSquares();

        // I assume that both players play with the same set of pieces
        addCommonPieces(squares[0],pieces)
        addPawns(squares[1],pieces)

        addPawns(squares[6],pieces)
        addCommonPieces(squares[7],pieces)

        return board;
    }

    private fun addCommonPieces(row: List<Square>,pieceSet: List<Piece>){
        for (i in 0..row.size){
            val movePiece = pieceSet.find {
                val pieceName = it.getName()
                when(i) {
                    0,7 -> {
                        pieceName === PieceName.ROOK
                    }
                    1,6 -> {
                        pieceName === PieceName.HORSE
                    }
                    2,5-> {
                        pieceName === PieceName.BISHOP
                    }
                    3 -> {
                        pieceName === PieceName.KING
                    }
                    4 -> {
                        pieceName === PieceName.QUEEN
                    }
                    else -> {
                        pieceName === PieceName.PAWN
                    }
                }
            }
            if (movePiece != null) {
                row[i].movePieceTo(movePiece)
            }
        }
    }

    private fun addPawns(row: List<Square>,pieceSet: List<Piece>) {
        for (i in 0..row.size) {
            pieceSet.find { it.getName() === PieceName.PAWN }?.let { row[i].movePieceTo(it) }
        }
    }
}