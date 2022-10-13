package squares

import pieces.Piece

interface Square {
    fun getPiece(): Piece?
    fun movePieceToThisSquare(pz: Piece)
    fun movePieceFromThisSquare(): Piece?
    fun getRow(): Int
    fun getColumn(): Int
}