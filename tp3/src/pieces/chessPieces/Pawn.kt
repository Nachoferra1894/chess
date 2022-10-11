package pieces.chessPieces

import pieces.*
import rules.NoPieceCrashRule
import rules.Rule
import rules.moves.DiagonalMoveRule
import rules.moves.VerticalMoveRule
import squares.Square

class Pawn(color: PieceColor): Piece, CommonPiece(color) {
    private val noPieceCrash = NoPieceCrashRule()
    private val verticalMoveRule = VerticalMoveRule(2)
    private val diagonalMoveRule = DiagonalMoveRule(1)
    private val rules: List<Rule> = listOf(noPieceCrash,verticalMoveRule,diagonalMoveRule)

    override fun getName(): PieceName {
        return PieceName.PAWN
    }

    override fun getRules(): List<Rule> {
        return rules
    }

    override fun addMove() {
        movesCount++
        verticalMoveRule.changeLimit(1)
    }

}