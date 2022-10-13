package rules.moves

import squares.Board
import squares.Square

class DiagonalMoveRule(override val limit: Int = 0) : MoveRule {
    override fun isMovePossible(sqFrom: Square, sqTo: Square, board: Board): Boolean {
        var fromRow = sqFrom.getRow()
        var fromCol = sqFrom.getColumn()
        val toRow = sqTo.getRow()
        val toCol = sqTo.getColumn()

        val rowIterator = if (fromRow > toRow) -1 else 1
        val colIterator = if (fromCol > toCol) -1 else 1
        var counter = 0;

        while (fromRow != toRow && fromCol != toCol && (limit == 0 || counter < limit)) {
            fromRow+=rowIterator
            fromCol+=colIterator
            counter++
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