package rules

import pieces.Piece
import squares.Square

class CastleRule {
    fun isMovePossible(sqFrom: Square, sqTo: Square,pieces: List<Piece>): Boolean {

//        val fromPiece = sqFrom.getPiece() ?: return false
//        if (fromPiece.getName() != PieceName.KING || fromPiece.getMoveCount() != 0) {
//            return false
//        }
//        val rook: Rook? = board.getCastleNearestRook(sqTo,fromPiece.getColor())
//        if(rook == null || rook.getMoveCount() > 0) return false
        return false
    }
}