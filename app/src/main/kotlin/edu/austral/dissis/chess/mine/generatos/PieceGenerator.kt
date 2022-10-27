package generatos

import pieces.*
import pieces.chessPieces.*
import rules.moves.MoveType

class PieceGenerator {
    fun createPiece(pieceName: PieceName,pieceColor: PieceColor,pieceId: String): Piece{
        return if (pieceName === PieceName.PAWN){
            val moveType = if (pieceColor === PieceColor.WHITE) MoveType.BACKWARDS else MoveType.FORWARD
            Pawn(pieceColor,pieceId,moveType)
        } else when(pieceName) {
            PieceName.ROOK -> Rook(pieceColor,pieceId)
            PieceName.KNIGHT -> Knight(pieceColor,pieceId)
            PieceName.BISHOP -> Bishop(pieceColor,pieceId)
            PieceName.QUEEN -> Queen(pieceColor,pieceId)
            PieceName.KING -> King(pieceColor,pieceId)
            else -> {
                throw IllegalArgumentException("Piece not in chess pieces!")
            }
        }
    }
    fun promotePiece(piece: Piece,newPiece: PieceName): Piece{
        val pieceId = piece.getId()
        val pieceColor = piece.getColor()
        val piecePosition = piece.getPosition() ?: throw IllegalArgumentException("Piece not in board!")

        val promotedPiece: Piece  = when(newPiece) {
            PieceName.ROOK -> Rook(pieceColor, pieceId)
            PieceName.KNIGHT -> Knight(pieceColor, pieceId)
            PieceName.BISHOP -> Bishop(pieceColor, pieceId)
            PieceName.QUEEN -> Queen(pieceColor, pieceId)
            PieceName.KING -> King(pieceColor, pieceId)
            else -> {
                throw IllegalArgumentException("Piece not in chess pieces!")
            }
        }
        promotedPiece.makeMove(piecePosition)
        return promotedPiece
    }
}
