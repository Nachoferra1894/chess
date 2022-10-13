package rules.moves

import squares.Board
import squares.Square

class DiagonalEatRule(override val limit: Int = 0) : MoveRule {
    private val diagonalMoveRule = DiagonalMoveRule(limit)
    override fun isMovePossible(sqFrom: Square, sqTo: Square): Boolean {
        return if (sqTo.getPiece() == null){
            false
        } else diagonalMoveRule.isMovePossible(sqFrom, sqTo)
    }

    override fun getRowMoveType(): Int {
        return 1
    }

    override fun getColMoveType(): Int {
        return 1
    }
}