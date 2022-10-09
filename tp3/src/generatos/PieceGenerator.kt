package generatos

import pieces.*

class PieceGenerator {
    fun createPiece(pieceName: PieceName,pieceColor: PieceColor): Piece{
        return if (pieceName == PieceName.PAWN){
            PromotablePiece(pieceName,pieceColor)
        } else {
            CommonPiece(pieceName,pieceColor)
        }
    }
}