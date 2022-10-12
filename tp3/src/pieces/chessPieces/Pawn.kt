package pieces.chessPieces

import pieces.*
import rules.NoPieceCrashRule
import rules.Rule
import rules.moves.DiagonalEatRule
import rules.moves.DiagonalMoveRule
import rules.moves.MoveRule
import rules.moves.VerticalMoveRule
import squares.Square

class Pawn(color: PieceColor): Piece, CommonPiece(color) {
    private val verticalMoveRule = VerticalMoveRule(2)
    private val diagonalEatRule = DiagonalEatRule(1)
    private val rules: List<MoveRule> = listOf(verticalMoveRule,diagonalEatRule)

    override fun getName(): PieceName {
        return PieceName.PAWN
    }

    override fun getRules(): List<MoveRule> {
        return rules
    }

    override fun addMove() {
        movesCount++
        if (movesCount == 1) verticalMoveRule.changeLimit(1)
    }

}