package rules.moves

import pieces.Piece
import squares.Board
import squares.Square

class DiagonalMoveRule(override val limit: Int = 0) : MoveRule {
    override fun isMovePossible(sqFrom: Square, sqTo: Square): Boolean {
        var fromRow = sqFrom.getRow()
        var fromCol = sqFrom.getColumn()
        val toRow = sqTo.getRow()
        val toCol = sqTo.getColumn()

        val rowIterator = if (fromRow > toRow) -1 else 1
        val colIterator = if (fromCol > toCol) -1 else 1

        while (fromRow != toRow && fromCol != toCol) {
            fromRow+=rowIterator
            fromCol+=colIterator
        }
        return (fromRow == toRow && fromCol == toCol)
    }
}