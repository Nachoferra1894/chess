package rules.end

import pieces.Piece
import pieces.PieceColor


class CheckMateRule: EndGameRule {
    override fun hasGameFinished(pieces: List<Piece>, turnColor: PieceColor): Boolean {
        return false
    }
}