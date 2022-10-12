package rules.moves

import pieces.Piece
import squares.Board
import squares.Square

class VerticalMoveRule(override var limit: Int = 0) : MoveRule {
    override fun isMovePossible(sqFrom: Square, sqTo: Square): Boolean {
        val difference = sqFrom.getRow() - sqTo.getRow()
        val limitValidation = if (limit == 0) true else (kotlin.math.abs(difference) >= limit)
        return (sqFrom.getColumn() == sqTo.getColumn() && limitValidation)
    }

    fun changeLimit(newLimit: Int){
        limit = newLimit
    }
}