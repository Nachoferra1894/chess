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

class Rook: Piece, MoveCountPiece() {
    private val noPieceCrash = NoPieceCrashRule()
    private val verticalMoveRule = VerticalMoveRule()
    private val castleRule = CastleRule()
    val rules: List<Rule> = listOf(noPieceCrash,verticalMoveRule,castleRule)

    override fun isActive(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getName(): PieceName {
        return PieceName.ROOK
    }

    override fun getColor(): PieceColor {
        TODO("Not yet implemented")
    }

    override fun getCanMoveTo(sq: Square) {
    }
}