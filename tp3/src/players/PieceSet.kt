package players

import pieces.Piece
import pieces.PieceColor

class PieceSet(color: PieceColor,pieces: List<Piece>) {
    private val color: PieceColor = color
        get() = field

    private val pieces: List<Piece> = pieces
        get() = field

}