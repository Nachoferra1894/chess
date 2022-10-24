package pieces.chessPieces

import pieces.*
import rules.CastleRule
import rules.ExtraRule
import rules.NoPieceCrashRule
import rules.moves.DiagonalMoveRule
import rules.moves.MoveRule
import rules.moves.VerticalMoveRule
import squares.Square

class King(color: PieceColor): Piece, CommonPiece(color) {
    private val noPieceCrash = NoPieceCrashRule()
    private val verticalMoveRule = VerticalMoveRule(1)
    private val diagonalMoveRule = DiagonalMoveRule(1)
    private val castleRule = CastleRule()
    private val rules: List<MoveRule> = listOf(verticalMoveRule,diagonalMoveRule)
    private val extraRules: List<ExtraRule> = listOf(castleRule)

    override fun getName(): PieceName {
        return PieceName.KING
    }
    override fun getMovementRules(): List<MoveRule> {
        return rules
    }
    override fun getExtraRules(): List<ExtraRule> {
        return extraRules
    }
}