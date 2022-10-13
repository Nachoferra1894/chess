package pieces

import rules.ExtraRule
import rules.moves.MoveRule

interface Piece {
    fun isActive(): Boolean
    fun hasBeenEaten()
    fun getName(): PieceName
    fun getColor(): PieceColor
    fun getMovementRules(): List<MoveRule>
    fun getExtraRules(): List<ExtraRule>
    fun useNoPieceCrashRule(): Boolean
    fun getMoveCount(): Int
    fun makeMove()
    fun resetMoves()
}