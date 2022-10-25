package squares

import pieces.Piece

class PositionSquare(private val row: Int,private val column: Int): Square {

    override fun getRow(): Int {
        return row
    }

    override fun getColumn(): Int {
        return column
    }
}