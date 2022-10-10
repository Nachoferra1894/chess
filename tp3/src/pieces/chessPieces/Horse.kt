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
import rules.moves.HorseMoveRule
import rules.moves.VerticalMoveRule
import squares.Square

class Horse: Piece {
    private val horseMoveRule = HorseMoveRule()

    val rules: List<Rule> = listOf(horseMoveRule)

    override fun isActive(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getName(): PieceName {
        return PieceName.HORSE
    }

    override fun getColor(): PieceColor {
        TODO("Not yet implemented")
    }

    override fun getCanMoveTo(sq: Square) {
    }
}