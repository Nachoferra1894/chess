package pieces.chessPieces

import pieces.*
import rules.*
import rules.moves.DiagonalEatRule
import rules.moves.MoveRule
import rules.moves.VerticalMoveRule
import squares.Square

class Pawn(color: PieceColor): Piece, CommonPiece(color) {
    private val verticalMoveRule = VerticalMoveRule(2)
    private val diagonalEatRule = DiagonalEatRule(1)
    private val passantCaptureRule = PassantCaptureRule()

    private val rules: List<MoveRule> = listOf(verticalMoveRule,diagonalEatRule)
    private val extraRules: List<ExtraRule> = listOf(passantCaptureRule)

    override fun getName(): PieceName {
        return PieceName.PAWN
    }

    override fun getMovementRules(): List<MoveRule> {
        return rules
    }

    override fun makeMove(sq: Square) {
        if (movesCount == 1) {
            verticalMoveRule.changeLimit(1)
        }
        super.makeMove(sq)
    }

    override fun getExtraRules(): List<ExtraRule> {
        return extraRules
    }

}