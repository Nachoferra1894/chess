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
    val rules: List<Rule> = listOf(noPieceCrash,verticalMoveRule,castleRule)

    override fun getName(): PieceName {
        return PieceName.ROOK
    }

    override fun getCanMoveTo(sq: Square): Boolean {
        TODO()
    }
}