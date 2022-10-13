package squares

import pieces.Piece
import pieces.PieceColor
import pieces.chessPieces.Rook
import players.Player

interface Board {
    fun getSquareOccupation(sq: Square): Piece?
    fun getSquares(): List<List<Square>>
    fun getKingPosition(color: PieceColor): Square
    fun getMaxRows(): Int
    fun getMaxCols(): Int

    fun movePieceToSquare(sq: Square, pz: Piece)
    fun movePieceFromSquare(sq: Square)
    fun setKingPosition(color: PieceColor, square: Square)
    fun getCastleNearestRook(pos: Square,color: PieceColor): Rook?
    fun getColorSquares(pieceColor: PieceColor): List<Square>
}