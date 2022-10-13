package rules

import squares.Board
import squares.Square
interface ExtraRule: RuleMoveType {
    fun isMovePossible(sqFrom: Square, sqTo: Square,board: Board): Boolean
}