package generatos

import pieces.*
import pieces.chessPieces.*

class PieceGenerator {
    private var pieceCount = 0
    fun createPiece(pieceName: PieceName,pieceColor: PieceColor): Piece{
        pieceCount++;
        return when(pieceName) {
            PieceName.PAWN -> Pawn(pieceColor,"PW $pieceCount")
            PieceName.ROOK -> Rook(pieceColor,"RK $pieceCount")
            PieceName.HORSE -> Horse(pieceColor,"HS $pieceCount")
            PieceName.BISHOP -> Bishop(pieceColor,"BS $pieceCount")
            PieceName.QUEEN -> Queen(pieceColor,"QN $pieceCount")
            PieceName.KING -> King(pieceColor,"KG $pieceCount")
        }
    }
}