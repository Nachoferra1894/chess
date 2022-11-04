package generatos

import edu.austral.dissis.chess.mine.pieces.extraPieces.Chancellor
import pieces.*
import pieces.chessPieces.*
import rules.moves.MoveType

class PieceGenerator {
    fun createPiece(pieceName: PieceName,pieceColor: PieceColor,pieceId: String): Piece{
        val moveType = if (pieceColor === PieceColor.WHITE) MoveType.BACKWARDS else MoveType.FORWARD
        val contraryMoveType = if (pieceColor === PieceColor.WHITE) MoveType.FORWARD else MoveType.BACKWARDS
        return if (pieceName === PieceName.PAWN){
            Pawn(pieceColor,pieceId,moveType)
        } else when(pieceName) {
            PieceName.ROOK -> Rook(pieceColor,pieceId)
            PieceName.KNIGHT -> Knight(pieceColor,pieceId)
            PieceName.BISHOP -> Bishop(pieceColor,pieceId)
            PieceName.QUEEN -> Queen(pieceColor,pieceId)
            PieceName.KING -> King(pieceColor,pieceId)
            PieceName.CHANCELLOR -> Chancellor(pieceColor,pieceId,contraryMoveType,moveType)
            PieceName.ARCHBISHOP -> Archbishop(pieceColor,pieceId)

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
