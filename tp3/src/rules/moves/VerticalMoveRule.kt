package rules.moves

import pieces.Piece
import squares.Board
import squares.Square

class VerticalMoveRule(override var limit: Int = 0) : MoveRule {
    override fun isMovePossible(sqFrom: Square, sqTo: Square): Boolean {
        TODO()
    }

    fun changeLimit(newLimit: Int){
        limit = newLimit
    }
}