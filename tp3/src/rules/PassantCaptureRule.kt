package rules

import pieces.Piece
import rules.moves.MoveRule
import squares.Board
import squares.Square

class PassantCaptureRule: Rule {
    override fun isMovePossible(board: Board, sqFrom: Square, sqTo: Square): Boolean {
        TODO("Not yet implemented")
    }
}