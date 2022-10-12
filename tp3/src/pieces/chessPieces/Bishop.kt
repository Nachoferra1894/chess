package pieces.chessPieces

import pieces.*
import rules.CastleRule
import rules.NoPieceCrashRule
import rules.Rule
import rules.moves.DiagonalMoveRule
import rules.moves.HorizontalMoveRule
import rules.moves.MoveRule
import rules.moves.VerticalMoveRule
import squares.Square

class Bishop(color: PieceColor): Piece, CommonPiece(color) {
    private val diagonalMoveRule = DiagonalMoveRule()

    private val rules: List<Rule> = listOf(diagonalMoveRule)


    override fun getName(): PieceName {
        return PieceName.BISHOP
    }


    override fun getRules(): List<Rule> {
        return rules
    }
}