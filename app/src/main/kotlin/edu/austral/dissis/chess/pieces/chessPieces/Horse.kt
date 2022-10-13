package pieces.chessPieces

import pieces.*
import rules.moves.*

class Horse(color: PieceColor,id: String): Piece, CommonPiece(color,id) {
    private val horseMoveRule = HorseMoveRule()

    private val rules: List<MoveRule> = listOf(horseMoveRule)

    override fun getName(): PieceName {
        return PieceName.HORSE
    }

    override fun getMovementRules(): List<MoveRule> {
        return rules
    }
    override fun useNoPieceCrashRule(): Boolean {
        return false
    }
}