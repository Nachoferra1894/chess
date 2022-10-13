package rules

import pieces.Piece
import squares.Board
import squares.Square

class MaxBoardRule {
    fun isMovePossible(board: Board, sq: Square): Boolean {
        val maxRows = board.getMaxRows()
        val maxCols = board.getMaxCols()

        val col = sq.getColumn()
        val row = sq.getRow()
        return !(col > maxCols ||  row > maxRows || row < 0 || col < 0 )
    }
}