package pieces.chessPieces

import pieces.MoveCountPiece
import pieces.Piece
import pieces.PieceColor
import pieces.PieceName
import rules.CastleRule
import rules.NoPieceCrashRule
import rules.Rule
import rules.moves.DiagonalMoveRule
import rules.moves.HorizontalMoveRule
import rules.moves.VerticalMoveRule
import squares.Square

class Queen: Piece {
    private val noPieceCrash = NoPieceCrashRule()
    private val verticalMoveRule = VerticalMoveRule()
    private val horizontalMoveRule = HorizontalMoveRule()
    private val diagonalMoveRule = DiagonalMoveRule()

    val rules: List<Rule> = listOf(noPieceCrash,verticalMoveRule,horizontalMoveRule,diagonalMoveRule)

    override fun isActive(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getName(): PieceName {
        return PieceName.QUEEN
    }

    override fun getColor(): PieceColor {
        TODO("Not yet implemented")
    }

    override fun getCanMoveTo(sq: Square) {
    }
}