package pieces

import squares.Square

interface Piece {
    fun isActive(): Boolean
    fun hasBeenEaten()
    fun getName(): PieceName
    fun getColor(): PieceColor
    fun getCanMoveTo(sq: Square): Boolean
}