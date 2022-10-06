package squares

import pieces.Piece

interface Board {
    fun getSquareOccupation(sq: Square): Piece?
    fun getSquares(): List<List<Square>>
}