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

class Bishop: Piece {
    private val noPieceCrash = NoPieceCrashRule()
    private val diagonalMoveRule = DiagonalMoveRule()

    val rules: List<Rule> = listOf(noPieceCrash,diagonalMoveRule)

    override fun isActive(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getName(): PieceName {
        return PieceName.BISHOP
    }

    override fun getColor(): PieceColor {
        TODO("Not yet implemented")
    }

    override fun getCanMoveTo(sq: Square) {
    }
}