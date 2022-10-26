package rules

import squares.Square

class MaxBoardRule {
    fun isMovePossible(rows: Int, cols: Int, sq: Square): Boolean {

        val col = sq.getColumn()
        val row = sq.getRow()
        return !(col >= cols ||  row >= rows || row < 0 || col < 0)
    }
}