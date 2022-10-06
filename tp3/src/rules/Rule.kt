package rules

import pieces.Piece
import squares.Board
import squares.Square

interface Rule {
    fun isMovePossible(
        pieces: Array<Piece>,
        board: Board,
        sq: Square
    ): Boolean
}