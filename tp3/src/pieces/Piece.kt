package pieces

import rules.Rule
import squares.Square

interface Piece {
    fun isActive(): Boolean
    fun hasBeenEaten()
    fun getName(): PieceName
    fun getColor(): PieceColor
    fun getRules(): List<Rule>
}