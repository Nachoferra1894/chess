package pieces.chessPieces

import pieces.*
import rules.CastleRule
import rules.NoPieceCrashRule
import rules.Rule
import rules.moves.DiagonalMoveRule
import rules.moves.VerticalMoveRule
import squares.Square

class Rook(color: PieceColor): Piece, CommonPiece(color) {
    private val noPieceCrash = NoPieceCrashRule()
    private val verticalMoveRule = VerticalMoveRule()
    private val castleRule = CastleRule()
    private val rules: List<Rule> = listOf(verticalMoveRule,castleRule)

    override fun getName(): PieceName {
        return PieceName.ROOK
    }

    override fun getRules(): List<Rule> {
        return rules
    }
}