package generatos

import pieces.Piece
import pieces.PieceColor
import pieces.PieceName
import squares.PositionSquare
import squares.Square
import java.util.*

class BoardGenerator {
    fun createBoard(rows: Int,cols: Int,pieces: List<Piece>){
        var whitePieceQueue: MutableList<Piece> = pieces.filter { it.getColor() === PieceColor.WHITE }.toMutableList()
        var blackPieceQueue: MutableList<Piece> = pieces.filter { it.getColor() === PieceColor.BLACK }.toMutableList()


        // I assume that both players play with the same set of pieces
        whitePieceQueue = addCommonPieces(cols,0,whitePieceQueue)
        whitePieceQueue = addPawns(cols,1,whitePieceQueue)

        blackPieceQueue = addPawns(cols,6,blackPieceQueue)
        blackPieceQueue = addCommonPieces(cols,7,blackPieceQueue)

        if (whitePieceQueue.size + blackPieceQueue.size > 0){
            println("Piece error!")
        }

    }

    private fun addCommonPieces(cols: Int,row: Int,pieceSet: MutableList<Piece>):  MutableList<Piece>{
        for (i in 0 until cols ){
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
                    4 -> {
                        pieceName === PieceName.KING
                    }
                    3 -> {
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

    private fun addPawns(cols: Int,row: Int,pieceSet: MutableList<Piece>): MutableList<Piece> {
        for (i in 0 until cols ){
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