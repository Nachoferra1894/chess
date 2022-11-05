package rules.moves

import pieces.Piece
import squares.Square

class DiagonalMoveRule(override var limit: Int = 0, override var moveType: MoveType = MoveType.ANY) : MoveRule, CommonMoveRule(limit, moveType) {
    override fun isMovePossible(sqFrom: Square, sqTo: Square, pieceInSqTo: Piece?): Boolean {
        var fromRow = sqFrom.getRow()
        var fromCol = sqFrom.getColumn()
        val toRow = sqTo.getRow()
        val toCol = sqTo.getColumn()

        val rowIterator = if (fromRow > toRow) -1 else 1
        val colIterator = if (fromCol > toCol) -1 else 1
        val counterEscalator = if(moveType === MoveType.BACKWARDS) -1 else 1
        var counter = 0;

        while (fromRow != toRow && fromCol != toCol && (super.isMovePossible(counter + counterEscalator))) {
            fromRow+=rowIterator
            fromCol+=colIterator
            counter+=counterEscalator
        }
        return (fromRow == toRow && fromCol == toCol)

    }
    override fun getRowMoveType(): Int {
        return 1
    }

    override fun getColMoveType(): Int {
        return 1
    }
}