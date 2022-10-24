package rules

import pieces.Piece
import squares.Square

class PassantCaptureRule: ExtraRule {
    override fun isMovePossible(sqFrom: Square, sqTo: Square,pieces: List<Piece>): Boolean {
        TODO("Not yet implemented")
    }

    override fun getRowMoveType(): Int {
        return 1
    }

    override fun getColMoveType(): Int {
        return 1
    }
}