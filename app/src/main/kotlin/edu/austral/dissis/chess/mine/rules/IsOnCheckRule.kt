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

    fun isOnCheck(king: King, otherColorPieces: List<Piece>, allPieces: List<Piece>,sqTo: Square): Boolean {
        val kingPos: Square? = king.getPosition()
        if (kingPos === null) return false
        for (piece in otherColorPieces){
            // Can't check with the extra rules
            val piecePos = piece.getPosition()
            if (piecePos !== null && (piecePos.getColumn() != sqTo.getColumn() || piecePos.getRow() != sqTo.getRow())){
                if (movementValidator.isMovePossible(allPieces,piecePos, kingPos, piece.getMovementRules(),
                        emptyList(),piece.useNoPieceCrashRule())) {
                    return true
                }
            }

        }
        return false
    }
}