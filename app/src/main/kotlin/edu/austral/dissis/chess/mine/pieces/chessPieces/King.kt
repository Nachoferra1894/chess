package pieces.chessPieces

import pieces.*
import rules.CastleRule
import rules.NoPieceCrashRule
import rules.moves.DiagonalMoveRule
import rules.moves.HorizontalMoveRule
import rules.moves.MoveRule
import rules.moves.VerticalMoveRule

class King(color: PieceColor,id: String): Piece, CommonPiece(color,id) {
    private val noPieceCrash = NoPieceCrashRule()
    private val verticalMoveRule = VerticalMoveRule(1)
    private val diagonalMoveRule = DiagonalMoveRule(1)
    private  val horizontalMoveRule = HorizontalMoveRule(1)
    private val rules: List<MoveRule> = listOf(verticalMoveRule,diagonalMoveRule,horizontalMoveRule)

    override fun getName(): PieceName {
        return PieceName.KING
    }
    override fun getMovementRules(): List<MoveRule> {
        return rules
    }
}