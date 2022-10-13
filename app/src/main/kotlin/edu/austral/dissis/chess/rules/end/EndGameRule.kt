package rules.end

import pieces.PieceColor
import squares.Board

interface EndGameRule {
    fun hasGameFinished(board: Board,turnColor: PieceColor): Boolean
}