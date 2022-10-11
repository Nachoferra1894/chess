package pieces.chessPieces

import pieces.*
import rules.CastleRule
import rules.NoPieceCrashRule
import rules.Rule
import rules.moves.DiagonalMoveRule
import rules.moves.VerticalMoveRule
import squares.Square

class King(color: PieceColor): Piece, CommonPiece(color) {
    private val noPieceCrash = NoPieceCrashRule()
    private val verticalMoveRule = VerticalMoveRule(1)
    private val diagonalMoveRule = DiagonalMoveRule(1)
    private val casteRule = CastleRule()
    private val rules: List<Rule> = listOf(noPieceCrash,verticalMoveRule,diagonalMoveRule,casteRule)

    override fun getName(): PieceName {
        return PieceName.KING
    }
    override fun getRules(): List<Rule> {
        return rules
    }
}