package rules

import pieces.Piece
import squares.Board
import squares.Square

interface Rule {
    fun isMovePossible(
        sqFrom: Square,
        sqTo: Square
    ): Boolean
    fun getRowMoveType(): Int
    fun getColMoveType(): Int
}