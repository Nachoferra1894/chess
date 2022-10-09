package squares

import pieces.Piece

interface Square {
    fun getPiece(): Piece?
    fun movePieceTo(pz: Piece)
    fun movePieceFrom(): Piece?
}