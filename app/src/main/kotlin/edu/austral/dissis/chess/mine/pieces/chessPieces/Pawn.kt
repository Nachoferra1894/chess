package pieces.chessPieces

import pieces.*
import rules.*
import rules.moves.DiagonalEatRule
import rules.moves.MoveRule
import rules.moves.MoveType
import rules.moves.VerticalMoveRule
import squares.Square

class Pawn(color: PieceColor,id: String,moveType: MoveType): Piece, CommonPiece(color,id) {
    private val verticalMoveRule = VerticalMoveRule(2,moveType)
    private val diagonalEatRule = DiagonalEatRule(1,moveType)
    private val passantCaptureRule = PassantCaptureRule()

    private val rules: List<MoveRule> = listOf(verticalMoveRule,diagonalEatRule)

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

}