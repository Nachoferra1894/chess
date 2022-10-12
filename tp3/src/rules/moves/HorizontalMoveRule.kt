package rules.moves

import squares.Square
import java.lang.Math.abs

class HorizontalMoveRule(override val limit: Int = 0) : MoveRule {
    override fun isMovePossible(sqFrom: Square, sqTo: Square): Boolean {
        val difference = sqFrom.getColumn() - sqTo.getColumn()
        val limitValidation = if (limit == 0) true else (kotlin.math.abs(difference) >= limit)
        return (sqFrom.getRow() == sqTo.getRow() && limitValidation)
    }
}