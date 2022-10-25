package rules.moves

import squares.Square

class HorizontalMoveRule(override val limit: Int = 0) : MoveRule {
    override fun isMovePossible(sqFrom: Square, sqTo: Square): Boolean {
        val difference = sqFrom.getRow() - sqTo.getRow()
        val limitValidation = if (limit == 0) true else (kotlin.math.abs(difference) >= limit)
        return (sqFrom.getColumn() == sqTo.getColumn() && limitValidation)
    }
    override fun getRowMoveType(): Int {
        return 1
    }

    override fun getColMoveType(): Int {
        return 0
    }
}