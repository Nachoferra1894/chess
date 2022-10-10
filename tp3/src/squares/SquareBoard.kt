package squares

import pieces.Piece
import pieces.PieceColor
import pieces.PieceName

class SquareBoard(columns: Int, rows: Int) : Board {
    private val squares: List<List<Square>> = initSquares(columns, rows)
    private lateinit var whiteKingPosition: Square
    private lateinit var blackKingPosition: Square

    override fun getSquareOccupation(sq: Square): Piece? {
        return sq.getPiece()
    }

    override fun getSquares(): List<List<Square>> {
        return squares
    }

    override fun getKingPosition(color: PieceColor): Square {
        return if (color == PieceColor.WHITE) whiteKingPosition else blackKingPosition
    }

    override fun movePieceToSquare(sq: Square, pz: Piece) {
        squares[sq.getRow()][sq.getColumn()].movePieceToThisSquare(pz)
        if(pz.getName() == PieceName.KING){
            setKingPosition(pz.getColor(),sq)
        }
    }

    override fun movePieceFromSquare(sq: Square) {
        squares[sq.getRow()][sq.getColumn()].movePieceFromThisSquare()
    }

    private fun initSquares(columns: Int, rows: Int): List<List<Square>> {
        val rowArray: MutableList<Square> = mutableListOf();
        val columnArray: MutableList<List<Square>> = mutableListOf();
        var sq: Square;

        for (c in 0..columns) {
            for (r in 0..rows) {
                sq = PositionSquare(r, c)
                rowArray.add(sq)
            }
            columnArray.add(rowArray.toList())
            rowArray.clear()
        }
        return columnArray.toList();
    }

    private fun setKingPosition(color: PieceColor, sq: Square) {
        if (color == PieceColor.WHITE) whiteKingPosition = sq else blackKingPosition = sq
    }
}