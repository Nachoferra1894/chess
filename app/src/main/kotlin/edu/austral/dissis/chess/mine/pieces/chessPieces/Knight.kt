package pieces.chessPieces

import pieces.*
import rules.moves.*

class Knight(color: PieceColor): Piece, CommonPiece(color) {
    private val knightMoveRule = KnightMoveRule()

    private val rules: List<MoveRule> = listOf(knightMoveRule)

    override fun getName(): PieceName {
        return PieceName.KNIGHT
    }

    override fun getMovementRules(): List<MoveRule> {
        return rules
    }
    override fun useNoPieceCrashRule(): Boolean {
        return false
    }
}