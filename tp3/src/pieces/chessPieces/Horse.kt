package pieces.chessPieces

import pieces.*
import rules.CastleRule
import rules.NoPieceCrashRule
import rules.Rule
import rules.moves.*
import squares.Square

class Horse(color: PieceColor): Piece, CommonPiece(color) {
    private val horseMoveRule = HorseMoveRule()

    private val rules: List<Rule> = listOf(horseMoveRule)

    override fun getName(): PieceName {
        return PieceName.HORSE
    }

    override fun getMovementRules(): List<Rule> {
        return rules
    }
    override fun useNoPieceCrashRule(): Boolean {
        return false
    }
}