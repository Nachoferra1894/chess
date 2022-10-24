package pieces.chessPieces

import pieces.*
import rules.CastleRule
import rules.ExtraRule
import rules.NoPieceCrashRule
import rules.moves.DiagonalMoveRule
import rules.moves.HorizontalMoveRule
import rules.moves.MoveRule
import rules.moves.VerticalMoveRule
import squares.Square

class Rook(color: PieceColor): Piece, CommonPiece(color) {
    private val noPieceCrash = NoPieceCrashRule()
    private val verticalMoveRule = VerticalMoveRule()
    private val horizontalMoveRule = HorizontalMoveRule()
    private val castleRule = CastleRule()
    private val rules: List<MoveRule> = listOf(verticalMoveRule,horizontalMoveRule)
    private val extraRules: List<ExtraRule> = listOf(castleRule)

    override fun getName(): PieceName {
        return PieceName.ROOK
    }

    override fun getMovementRules(): List<MoveRule> {
        return rules
    }
    override fun getExtraRules(): List<ExtraRule> {
        return extraRules
    }
}