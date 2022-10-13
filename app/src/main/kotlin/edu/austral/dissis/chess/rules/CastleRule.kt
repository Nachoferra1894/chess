package rules

import pieces.Piece
import pieces.PieceName
import pieces.chessPieces.Rook
import squares.Board
import squares.Square

class CastleRule: ExtraRule {
    override fun isMovePossible(sqFrom: Square, sqTo: Square, board: Board): Boolean {
        val fromPiece = sqFrom.getPiece() ?: return false
        if (fromPiece.getName() != PieceName.KING || fromPiece.getMoveCount() != 0) {
            return false
        }
        val rook: Rook? = board.getCastleNearestRook(sqTo,fromPiece.getColor())
        if(rook == null || rook.getMoveCount() > 0) return false
        return true
    }

    override fun getRowMoveType(): Int {
        return 2
    }

    override fun getColMoveType(): Int {
        return 0
    }
}