package pieces.chessPieces

import pieces.*
import rules.CastleRule
import rules.NoPieceCrashRule
import rules.Rule
import rules.moves.DiagonalMoveRule
import rules.moves.HorizontalMoveRule
import rules.moves.HorseMoveRule
import rules.moves.VerticalMoveRule
import squares.Square

class Horse(color: PieceColor): Piece, CommonPiece(color) {
    private val horseMoveRule = HorseMoveRule()

    val rules: List<Rule> = listOf(horseMoveRule)

    override fun getName(): PieceName {
        return PieceName.HORSE
    }

    override fun getCanMoveTo(sq: Square): Boolean {
        TODO()
    }
}