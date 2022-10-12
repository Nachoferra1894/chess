package rules.moves

import pieces.Piece
import squares.Board
import squares.Square

class DiagonalEatRule(override val limit: Int = 0) : MoveRule {
    private val diagonalMoveRule = DiagonalMoveRule(limit)
    override fun isMovePossible(sqFrom: Square, sqTo: Square): Boolean {
        return if (sqTo.getPiece() == null){
            false
        } else diagonalMoveRule.isMovePossible(sqFrom,sqTo)
    }
}