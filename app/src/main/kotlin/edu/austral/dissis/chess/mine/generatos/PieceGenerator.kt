package generatos

import pieces.*
import pieces.chessPieces.*

class PieceGenerator {
    fun createPiece(pieceName: PieceName,pieceColor: PieceColor): Piece{
        return when(pieceName) {
            PieceName.PAWN -> Pawn(pieceColor)
            PieceName.ROOK -> Rook(pieceColor)
            PieceName.KNIGHT -> Knight(pieceColor)
            PieceName.BISHOP -> Bishop(pieceColor)
            PieceName.QUEEN -> Queen(pieceColor)
            PieceName.KING -> King(pieceColor)
        }
    }
}