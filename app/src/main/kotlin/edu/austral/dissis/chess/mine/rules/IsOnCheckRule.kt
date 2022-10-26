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

    fun isOnCheck(kingPos: Square, otherColorPieces: List<Piece>, allPieces: List<Piece>,eatenPiece: Piece? = null): Piece? {
        for (piece in otherColorPieces){
            // Can't check with the extra rules
            val piecePos = piece.getPosition()
            if (piecePos !== null && piece !== eatenPiece){
                if (movementValidator.isMovePossible(allPieces,piecePos, kingPos, piece)) {
                    return piece
                }
            }

        }
        return null
    }
}