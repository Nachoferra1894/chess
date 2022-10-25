package generatos

import pieces.*
import pieces.chessPieces.*
import rules.moves.MoveType

class PieceGenerator {
    fun createPiece(pieceName: PieceName,pieceColor: PieceColor): Piece{
        return if (pieceName === PieceName.PAWN){
            val moveType = if (pieceColor === PieceColor.WHITE) MoveType.BACKWARDS else MoveType.FORWARD
            Pawn(pieceColor,moveType)
        } else when(pieceName) {
            PieceName.ROOK -> Rook(pieceColor)
            PieceName.KNIGHT -> Knight(pieceColor)
            PieceName.BISHOP -> Bishop(pieceColor)
            PieceName.QUEEN -> Queen(pieceColor)
            PieceName.KING -> King(pieceColor)
            else -> {
                throw IllegalArgumentException("Piece not in chess pieces!")
            }
        }
    }
    fun promotePiece(piece: Piece,newPiece: PieceName): Piece{
        TODO()
        //  add second constructor to pieces
    }
}
