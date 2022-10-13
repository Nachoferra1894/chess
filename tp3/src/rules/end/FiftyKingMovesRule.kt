package rules.end

import pieces.PieceColor
import squares.Board

class FiftyKingMovesRule: EndGameRule {
    override fun hasGameFinished(board: Board, turnColor: PieceColor): Boolean {
        val king = board.getKingPosition(turnColor).getPiece()
        if (king != null) {
            return king.getMoveCount() == 51
        }
        return false
    }
}