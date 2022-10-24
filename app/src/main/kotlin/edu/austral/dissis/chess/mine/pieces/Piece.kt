package pieces

import edu.austral.dissis.chess.gui.ChessPiece
import rules.ExtraRule
import rules.moves.MoveRule
import squares.Square

interface Piece {
    fun getId(): String
    fun isActive(): Boolean
    fun hasBeenEaten()
    fun getName(): PieceName
    fun getColor(): PieceColor
    fun getMovementRules(): List<MoveRule>
    fun getExtraRules(): List<ExtraRule>
    fun useNoPieceCrashRule(): Boolean
    fun getMoveCount(): Int
    fun makeMove(sq: Square)
    fun resetMoves()
    fun getPosition(): Square?
}