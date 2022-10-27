package pieces.chessPieces

import pieces.*
import rules.CastleRule
import rules.NoPieceCrashRule
import rules.moves.DiagonalMoveRule
import rules.moves.HorizontalMoveRule
import rules.moves.MoveRule
import rules.moves.VerticalMoveRule
import squares.Square

class Rook(color: PieceColor,id: String): Piece, CommonPiece(color,id) {
    private val verticalMoveRule = VerticalMoveRule()
    private val horizontalMoveRule = HorizontalMoveRule()
    private val rules: List<MoveRule> = listOf(verticalMoveRule,horizontalMoveRule)
    
    override fun getName(): PieceName {
        return PieceName.ROOK
    }

    override fun getMovementRules(): List<MoveRule> {
        return rules
    }
}