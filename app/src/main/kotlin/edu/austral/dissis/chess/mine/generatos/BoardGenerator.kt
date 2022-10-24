package generatos

import pieces.Piece
import pieces.PieceColor
import pieces.PieceName
import squares.PositionSquare
import squares.Square
import java.util.*

class BoardGenerator {
    fun createBoard(columns: Int,rows: Int,pieces: List<Piece>){
        var whitePieceQueue: MutableList<Piece> = pieces.filter { it.getColor() === PieceColor.WHITE }.toMutableList()
        var blackPieceQueue: MutableList<Piece> = pieces.filter { it.getColor() === PieceColor.BLACK }.toMutableList()


        // I assume that both players play with the same set of pieces
        whitePieceQueue = addCommonPieces(0,whitePieceQueue)
        whitePieceQueue = addPawns(1,whitePieceQueue)

        blackPieceQueue = addPawns(6,blackPieceQueue)
        blackPieceQueue = addCommonPieces(7,blackPieceQueue)

        if (whitePieceQueue.size + blackPieceQueue.size > 0){
            println("Piece error!")
        }

    }

    private fun addCommonPieces(row: Int,pieceSet: MutableList<Piece>):  MutableList<Piece>{
        for (i in 0 until row ){
            val movePiece = pieceSet.find {
                val pieceName = it.getName()
                when(i) {
                    0,7 -> {
                        pieceName === PieceName.ROOK
                    }
                    1,6 -> {
                        pieceName === PieceName.KNIGHT
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
                pieceSet.remove(movePiece);
                movePiece.makeMove(PositionSquare(row,i));
            }
        }
        return pieceSet
    }

    private fun addPawns(row: Int,pieceSet: MutableList<Piece>): MutableList<Piece> {
        for (i in 0 until row ){
            val movePiece = pieceSet.find {
                it.getName() === PieceName.PAWN
            }
            if (movePiece != null) {
                pieceSet.remove(movePiece)
                movePiece.makeMove(PositionSquare(row,i));
            }
        }
        return pieceSet
    }
}