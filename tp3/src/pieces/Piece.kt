package pieces

import squares.Square

interface Piece {
    fun isActive(): Boolean
    fun getName(): PieceName
    fun getColor(): PieceColor
}