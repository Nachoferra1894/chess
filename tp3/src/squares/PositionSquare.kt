package squares

import pieces.Piece

class PositionSquare(row: Int,column: Int): Square {
    private var piece: Piece? = null
    private val row: Int = row
        get() = field

    private val column: Int = column
        get() = field

    override fun getPiece(): Piece? {
        return piece
    }

    override fun movePieceTo(pz: Piece) {
        this.piece = pz
    }

    override fun movePieceFrom(): Piece? {
        this.piece = null
        return piece
    }
}