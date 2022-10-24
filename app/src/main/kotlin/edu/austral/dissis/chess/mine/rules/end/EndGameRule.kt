package rules.end

import pieces.Piece
import pieces.PieceColor

interface EndGameRule {
    fun hasGameFinished(pieces: List<Piece>,turnColor: PieceColor): Boolean
}