package rules

import pieces.Piece
import squares.Board
import squares.Square

class PromoteRule: ExtraRule {
    override fun isMovePossible(sqFrom: Square, sqTo: Square, board: Board): Boolean {
        TODO("Not yet implemented")
    }

    override fun getRowMoveType(): Int {
        return 1
    }

    override fun getColMoveType(): Int {
        return 0
    }
}