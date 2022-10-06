package squares

import pieces.Piece

class SquareBoard(columns: Int, rows: Int): Board {
    private val squares: List<List<Square>> = initSquares(columns,rows)
    override fun getSquareOccupation(sq: Square): Piece? {
        return sq.getPiece()
    }

    override fun getSquares(): List<List<Square>> {
        return squares
    }

    private fun initSquares(columns: Int, rows: Int): List<List<Square>> {
        val rowArray: MutableList<Square> = mutableListOf();
        val columnArray: MutableList<List<Square>> = mutableListOf();
        var sq: Square;

        for (c in 0..columns){
            for (r in 0..rows){
                sq = PositionSquare(r,c)
                rowArray.add(sq)
            }
            columnArray.add(rowArray.toList())
            rowArray.clear()
        }
        return columnArray.toList();
    }
}