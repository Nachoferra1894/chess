package rules

import rules.moves.MoveRule
import squares.PositionSquare
import squares.Square

class NoPieceCrashRule {
    fun isMovePossible(sqFrom: Square, sqTo: Square,moveRule: RuleMoveType): Boolean {
        var fromRow = sqFrom.getRow()
        var fromCol = sqFrom.getColumn()
        val toRow = sqTo.getRow()
        val toCol = sqTo.getColumn()

        val rowIterator = (if (fromRow > toRow) -1 else 1) * moveRule.getRowMoveType()
        val colIterator = (if (fromCol > toCol) -1 else 1) * moveRule.getColMoveType()

        fromRow+=rowIterator
        fromCol+=colIterator

        while (fromRow != toRow && fromCol != toCol) {
            val currentSquare: Square = PositionSquare(fromRow, fromCol)
            if (currentSquare.getPiece() != null){
                return false
            }
            fromRow+=rowIterator
            fromCol+=colIterator
        }
        return true
    }
}