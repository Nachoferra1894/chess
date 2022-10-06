package rules

import pieces.Piece
import squares.Board
import squares.Square

class IsOnCheckRule(
        pieces: Array<Piece>,
        board: Board,
        sq: Square
) : Rule {
    override fun isMovePossible(pieces: Array<Piece>, board: Board, sq: Square): Boolean {
        TODO("Not yet implemented")
    }
}