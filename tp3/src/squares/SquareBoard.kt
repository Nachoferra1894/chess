package squares

import pieces.Piece
import pieces.PieceColor
import pieces.PieceName
import pieces.chessPieces.Rook

class SquareBoard : Board {
    private var squares: List<List<Square>> = emptyList()
    private lateinit var whiteKingPosition: Square
    private lateinit var blackKingPosition: Square
    private var maxRows: Int = 0
    private var maxCols: Int = 0

    constructor(columns: Int, rows: Int){
        squares = initSquares(columns, rows)
    }

    constructor(squares: List<List<Square>>){
        this.squares = squares
    }

    override fun getSquareOccupation(sq: Square): Piece? {
        return sq.getPiece()
    }

    override fun getSquares(): List<List<Square>> {
        return squares
    }

    override fun getKingPosition(color: PieceColor): Square {
        return if (color == PieceColor.WHITE) whiteKingPosition else blackKingPosition
    }

    override fun getMaxRows(): Int {
        return maxRows
    }

    override fun getMaxCols(): Int {
        return maxCols
    }

    override fun movePieceToSquare(sq: Square, pz: Piece) {
        squares[sq.getRow()][sq.getColumn()].movePieceToThisSquare(pz)
        pz.makeMove()
        if(pz.getName() == PieceName.KING){
            setKingPosition(pz.getColor(),sq)
        }
    }

    override fun movePieceFromSquare(sq: Square) {
        val newPiece = squares[sq.getRow()][sq.getColumn()].movePieceFromThisSquare()
        if (newPiece != null) {
            if (newPiece.getName() == PieceName.PAWN){
                val color = if(newPiece.getColor() == PieceColor.WHITE) PieceColor.BLACK else PieceColor.BLACK
                val king = getKingPosition(color).getPiece()
                if (king != null && king.getMoveCount() > 0){
                    king.resetMoves()
                }
            }
        }
    }

    override fun getCastleNearestRook(pos: Square,color: PieceColor): Rook? {
        // For the castle, the nearest rook will be the one trying to castle
        for(i in 0..maxCols){
            val nextCol = squares[pos.getRow()][pos.getColumn() + 1]
            if ((nextCol.getPiece()?.getName() ?: false) == PieceName.ROOK) {
                return nextCol.getPiece() as Rook
            }
            val lastCol = squares[pos.getRow()][pos.getColumn() - 1]
            if ((lastCol.getPiece()?.getName() ?: false) == PieceName.ROOK) {
                return nextCol.getPiece() as Rook
            }
        }
        return null;
    }

    override fun getColorSquares(pieceColor: PieceColor): List<Square> {
        return squares.flatten().filter {
            val piece = it.getPiece()
            piece != null && piece.getColor() == pieceColor
        }
    }

    private fun initSquares(columns: Int, rows: Int): List<List<Square>> {
        val rowArray: MutableList<Square> = mutableListOf();
        val columnArray: MutableList<List<Square>> = mutableListOf();
        var sq: Square;
        maxCols = columns
        maxRows = rows

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

    override fun setKingPosition(color: PieceColor, square: Square) {
        if (color == PieceColor.WHITE) whiteKingPosition = square else blackKingPosition = square
    }
}