package pieces.chessPieces

import pieces.*
import rules.moves.DiagonalMoveRule
import rules.moves.HorizontalMoveRule
import rules.moves.MoveRule
import rules.moves.VerticalMoveRule
import squares.Square

class Queen(color: PieceColor,id: String): Piece, CommonPiece(color,id) {
    private val verticalMoveRule = VerticalMoveRule()
    private val horizontalMoveRule = HorizontalMoveRule()
    private val diagonalMoveRule = DiagonalMoveRule()

    private val rules: List<MoveRule> = listOf(verticalMoveRule,horizontalMoveRule,diagonalMoveRule)

    override fun getName(): PieceName {
        return PieceName.QUEEN
    }

    override fun getMovementRules(): List<MoveRule> {
        return rules
    }
}