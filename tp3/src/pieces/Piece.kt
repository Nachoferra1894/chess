package pieces

import squares.Square

interface Piece {
    fun isActive(): Boolean
    fun getPosition(): Square
    fun getName(): PieceName
    fun getColor(): PieceColor
}