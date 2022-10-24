package rules

import edu.austral.dissis.chess.gui.PlayerColor
import generatos.BoardGenerator
import pieces.MovementValidator
import pieces.Piece
import pieces.PieceColor
import pieces.chessPieces.King
import squares.Square

class IsOnCheckRule {
    private val movementValidator = MovementValidator()

    fun isMovePossible(king: King, otherColorPieces: List<Piece>, playerColor: PieceColor): Boolean {
        val kingPos: Square? = king.getPosition()
        if (kingPos === null) return false
        val otherColor = if (playerColor == PieceColor.WHITE){
            PieceColor.BLACK
        } else PieceColor.WHITE
        for (piece in otherColorPieces){
            // Can't check with the extra rules
            val piecePos = piece.getPosition()
            if (piecePos !== null){
                if (movementValidator.isMovePossible(otherColorPieces,piecePos, kingPos, piece.getMovementRules(),
                        emptyList(),piece.useNoPieceCrashRule())) {
                    return false
                }
            }

        }
        return true
    }
}