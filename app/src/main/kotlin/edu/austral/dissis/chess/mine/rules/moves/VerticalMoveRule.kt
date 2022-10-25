package rules.moves

import pieces.Piece
import squares.Square

class VerticalMoveRule(override var limit: Int = 0, override var moveType: MoveType = MoveType.ANY) : MoveRule, CommonMoveRule(limit,moveType){
    override fun isMovePossible(sqFrom: Square, sqTo: Square, pieceInSqTo: Piece?): Boolean {
        val difference = sqFrom.getRow() - sqTo.getRow()
        return (sqFrom.getColumn() == sqTo.getColumn() && super.isMovePossible(difference))
    }

    override fun getRowMoveType(): Int {
        return 1
    }

    override fun getColMoveType(): Int {
        return 0
    }

    fun changeLimit(newLimit: Int){
        limit = newLimit
    }
}