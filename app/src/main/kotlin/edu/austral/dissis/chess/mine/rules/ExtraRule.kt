package rules

import pieces.Piece
import squares.Square
interface ExtraRule: RuleMoveType {
    fun isMovePossible(sqFrom: Square, sqTo: Square,pieces: List<Piece>): Boolean
}