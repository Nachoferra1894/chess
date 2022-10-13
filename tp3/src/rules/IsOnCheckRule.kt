package rules

import generatos.BoardGenerator
import pieces.MovementValidator
import pieces.PieceColor
import squares.Board
import squares.Square

class IsOnCheckRule {
    private val movementValidator = MovementValidator()

    fun isMovePossible(board: Board,sqFrom: Square, sqTo: Square,playerColor: PieceColor): Boolean {
        val kingPos: Square = board.getKingPosition(playerColor)

        board.movePieceFromSquare(sqFrom)
        sqFrom.getPiece()?.let { board.movePieceToSquare(sqTo, it) }
        val thisColorSquares = board.getColorSquares(playerColor)
        for (sq in thisColorSquares){
            val pieceToMove = sq.getPiece() ?: break
            // Can't check with the extra rules
            if (movementValidator.isMovePossible(board,sq, kingPos, pieceToMove.getMovementRules(),
                    emptyList(),pieceToMove.useNoPieceCrashRule())) {
                return false
            }
        }
        return true
    }
}