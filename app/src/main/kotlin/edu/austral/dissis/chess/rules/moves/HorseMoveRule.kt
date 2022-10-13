package rules.moves

import squares.Square

class HorseMoveRule(override val limit: Int? = 0) : MoveRule {
     override fun isMovePossible(sqFrom: Square, sqTo: Square): Boolean {
         val fromRow = sqFrom.getRow()
         val fromCol = sqFrom.getColumn()
         val toRow = sqTo.getRow()
         val toCol = sqTo.getColumn()

         val xMoves = intArrayOf(2, 1, -1, -2, -2, -1, 1, 2)
         val yMoves = intArrayOf(1, 2, 2, 1, -1, -2, -2, -1)

         for(i in 0..xMoves.size){
             if (fromRow + xMoves[i] == toRow && fromCol + yMoves[i] == toCol) {
                 return true
             }
         }
         return false
    }

    override fun getRowMoveType(): Int {
        return 2
    }

    override fun getColMoveType(): Int {
        return 1
    }
}