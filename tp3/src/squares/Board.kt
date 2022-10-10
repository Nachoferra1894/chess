package squares

import pieces.Piece
import pieces.PieceColor
import players.Player

interface Board {
    fun getSquareOccupation(sq: Square): Piece?
    fun getSquares(): List<List<Square>>
    fun getKingPosition(color: PieceColor): Square

    fun movePieceToSquare(sq: Square, pz: Piece)
    fun movePieceFromSquare(sq: Square)
}