package pieces

import edu.austral.dissis.chess.gui.ChessPiece
import rules.moves.MoveRule
import squares.Square

interface Piece {
    fun getId(): String
    fun hasBeenEaten()
    fun getName(): PieceName
    fun getColor(): PieceColor
    fun getMovementRules(): List<MoveRule>
    fun useNoPieceCrashRule(): Boolean
    fun useNoPieceCollide(): Boolean
    fun getMoveCount(): Int
    fun makeMove(sq: Square)
    fun resetMoves()
    fun getPosition(): Square?
}