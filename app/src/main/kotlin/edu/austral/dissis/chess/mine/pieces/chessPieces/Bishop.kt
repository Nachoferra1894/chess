package pieces.chessPieces

import pieces.*
import rules.moves.DiagonalMoveRule
import rules.moves.MoveRule

class Bishop(color: PieceColor,id: String) : Piece, CommonPiece(color,id) {
    private val diagonalMoveRule = DiagonalMoveRule()

    private val rules: List<MoveRule> = listOf(diagonalMoveRule)


    override fun getName(): PieceName {
        return PieceName.BISHOP
    }


    override fun getMovementRules(): List<MoveRule> {
        return rules
    }
}