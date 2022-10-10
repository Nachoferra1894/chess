package rules

import pieces.Piece
import squares.Board
import squares.Square

interface Rule {
    fun isMovePossible(
        board: Board,
        sqFrom: Square,
        sqTo: Square
    ): Boolean
}