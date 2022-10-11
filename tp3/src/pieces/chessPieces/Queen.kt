package pieces.chessPieces

import pieces.*
import rules.CastleRule
import rules.NoPieceCrashRule
import rules.Rule
import rules.moves.DiagonalMoveRule
import rules.moves.HorizontalMoveRule
import rules.moves.VerticalMoveRule
import squares.Square

class Queen(color: PieceColor): Piece, CommonPiece(color) {
    private val noPieceCrash = NoPieceCrashRule()
    private val verticalMoveRule = VerticalMoveRule()
    private val horizontalMoveRule = HorizontalMoveRule()
    private val diagonalMoveRule = DiagonalMoveRule()

    private val rules: List<Rule> = listOf(noPieceCrash,verticalMoveRule,horizontalMoveRule,diagonalMoveRule)

    override fun getName(): PieceName {
        return PieceName.QUEEN
    }

    override fun getRules(): List<Rule> {
        return rules
    }
}