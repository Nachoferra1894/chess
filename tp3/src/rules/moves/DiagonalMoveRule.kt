package rules.moves

import pieces.Piece
import squares.Board
import squares.Square

class DiagonalMoveRule(
        pieces: Array<Piece>,
        board: Board,
        sq: Square,
) : MoveRule {
    override val limit = 5;
    override fun isMovePossible(pieces: Array<Piece>, board: Board, sq: Square): Boolean {
        TODO("Not yet implemented")
    }
}