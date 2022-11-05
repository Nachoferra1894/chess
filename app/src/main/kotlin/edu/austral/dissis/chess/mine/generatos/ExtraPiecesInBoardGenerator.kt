package edu.austral.dissis.chess.mine.generatos

import pieces.Piece
import pieces.PieceColor
import pieces.PieceName
import squares.PositionSquare
import kotlin.Int

class ExtraPiecesInBoardGenerator: PiecesInBoardGenerator {
    private val chessPiecesInBoardGenerator = ChessPiecesInBoardGenerator()
    override fun getPiecesInBoard(): HashMap<PieceName, Int> {
        return hashMapOf(
            PieceName.KING to 1,
            PieceName.QUEEN to 1,
            PieceName.PAWN to 8,
            PieceName.ROOK to 2,
            PieceName.BISHOP to 1,
            PieceName.ARCHBISHOP to 1,
            PieceName.CHANCELLOR to 1,
            PieceName.KNIGHT to 2
        )
    }
    fun createBoard(rows: Int,cols: Int,pieces: List<Piece>){
        var whitePieceQueue: MutableList<Piece> = pieces.filter { it.getColor() === PieceColor.WHITE }.toMutableList()
        var blackPieceQueue: MutableList<Piece> = pieces.filter { it.getColor() === PieceColor.BLACK }.toMutableList()


        // I assume that both players play with the same set of pieces
        whitePieceQueue = addCommonPieces(cols,0,whitePieceQueue)
        whitePieceQueue = chessPiecesInBoardGenerator.addPawns(cols,1,whitePieceQueue)

        blackPieceQueue = chessPiecesInBoardGenerator.addPawns(cols,6,blackPieceQueue)
        blackPieceQueue = addCommonPieces(cols,7,blackPieceQueue)

        whitePieceQueue = addChancellor(4,4,whitePieceQueue)
        blackPieceQueue = addChancellor(4,3,blackPieceQueue)

        if (whitePieceQueue.size + blackPieceQueue.size > 0){
            println("More pieces in queue than in board!")
        }

    }

    private fun addChancellor(col: Int, row: Int, pieceSet: MutableList<Piece>): MutableList<Piece> {
        val movePiece = pieceSet.find {
            it.getName() === PieceName.CHANCELLOR
        }
        pieceSet.remove(movePiece);
        movePiece?.makeMove(PositionSquare(row,col));
        return pieceSet
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
                    2-> {
                        pieceName === PieceName.BISHOP
                    }
                    5-> {
                        pieceName === PieceName.ARCHBISHOP
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

}