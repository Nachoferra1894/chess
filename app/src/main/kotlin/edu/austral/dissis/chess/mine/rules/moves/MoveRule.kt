package rules.moves

import rules.RuleMoveType
import squares.Square

interface MoveRule: RuleMoveType {
    val limit: Int?
    fun isMovePossible(sqFrom: Square, sqTo: Square): Boolean
}