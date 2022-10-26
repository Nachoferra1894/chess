package rules

import pieces.MovementValidator
import pieces.Piece
import squares.Square

class PiecePointer {
    private val movementValidator = MovementValidator()

    fun isPiecePointedBy(kingPos: Square, otherColorPieces: List<Piece>, allPieces: List<Piece>, eatenPiece: Piece? = null): Piece? {
        for (piece in otherColorPieces){
            // Can't check with the extra rules
            val piecePos = piece.getPosition()
            if (piecePos !== null && piece.getId() !== eatenPiece?.getId()){
                if (movementValidator.isMovePossible(allPieces,piecePos, kingPos, piece)) {
                    return piece
                }
            }

        }
        return null
    }
}