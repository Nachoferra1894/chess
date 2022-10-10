package pieces.chessPieces

import pieces.MoveCountPiece
import pieces.Piece
import pieces.PieceColor
import pieces.PieceName
import rules.CastleRule
import rules.NoPieceCrashRule
import rules.Rule
import rules.moves.DiagonalMoveRule
import rules.moves.VerticalMoveRule
import squares.Square

class King: Piece, MoveCountPiece() {
    private val noPieceCrash = NoPieceCrashRule()
    private val verticalMoveRule = VerticalMoveRule(1)
    private val diagonalMoveRule = DiagonalMoveRule(1)
    private val casteRule = CastleRule()
    val rules: List<Rule> = listOf(noPieceCrash,verticalMoveRule,diagonalMoveRule,casteRule)

    override fun isActive(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getName(): PieceName {
        return PieceName.KING
    }

    override fun getColor(): PieceColor {
        TODO("Not yet implemented")
    }

    override fun getCanMoveTo(sq: Square) {

    }
}