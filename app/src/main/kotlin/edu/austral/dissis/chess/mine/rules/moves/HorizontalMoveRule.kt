package rules.moves

import pieces.Piece
import squares.Square

class HorizontalMoveRule(override var limit: Int = 0, override var moveType: MoveType = MoveType.ANY) : MoveRule, CommonMoveRule(limit, moveType) {

    override fun isMovePossible(sqFrom: Square, sqTo: Square, pieceInSqTo: Piece?): Boolean {
        val difference = sqFrom.getColumn() - sqTo.getColumn()
        return (sqFrom.getRow() == sqTo.getRow() && super.isMovePossible(difference))
    }
    override fun getRowMoveType(): Int {
        return 0
    }

    override fun getColMoveType(): Int {
        return 1
    }
}