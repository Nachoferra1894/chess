package rules.end

import pieces.PieceColor
import squares.Board

class StalemateRule: EndGameRule {
    override fun hasGameFinished(board: Board, turnColor: PieceColor): Boolean {
        TODO("Not yet implemented")
    }
}