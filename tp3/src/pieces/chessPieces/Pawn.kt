package pieces.chessPieces

import pieces.*
import rules.NoPieceCrashRule
import rules.PassantCaptureRule
import rules.PromoteRule
import rules.Rule
import rules.moves.DiagonalEatRule
import rules.moves.DiagonalMoveRule
import rules.moves.MoveRule
import rules.moves.VerticalMoveRule
import squares.Square

class Pawn(color: PieceColor): Piece, CommonPiece(color) {
    private val verticalMoveRule = VerticalMoveRule(2)
    private val diagonalEatRule = DiagonalEatRule(1)
    private val promoteRule = PromoteRule()
    private val passantCaptureRule = PassantCaptureRule()

    private val rules: List<MoveRule> = listOf(verticalMoveRule,diagonalEatRule)
    private val extraRules: List<Rule> = listOf(passantCaptureRule,promoteRule)

    override fun getName(): PieceName {
        return PieceName.PAWN
    }

    override fun getMovementRules(): List<MoveRule> {
        return rules
    }

    override fun addMove() {
        movesCount++
        if (movesCount == 1) verticalMoveRule.changeLimit(1)
    }

    override fun getExtraRules(): List<Rule> {
        return extraRules
    }

}