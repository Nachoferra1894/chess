package rules

import edu.austral.dissis.chess.mine.game.PieceController
import pieces.Piece
import rules.moves.MoveRule
import squares.PositionSquare
import squares.Square

class NoPieceCrashRule {

    fun isMovePossible(sqFrom: Square, sqTo: Square,moveRule: RuleMoveType,pieces: List<Piece>): Boolean {
        val pieceController = PieceController(pieces)
        var fromRow = sqFrom.getRow()
        var fromCol = sqFrom.getColumn()
        val toRow = sqTo.getRow()
        val toCol = sqTo.getColumn()

        val rowIterator = (if (fromRow > toRow) -1 else 1) * moveRule.getRowMoveType()
        val colIterator = (if (fromCol > toCol) -1 else 1) * moveRule.getColMoveType()

        fromRow+=rowIterator
        fromCol+=colIterator

        while ((fromRow != toRow || moveRule.getRowMoveType() == 0) && (fromCol != toCol  || moveRule.getColMoveType() == 0)) {
            val currentSquare: Square = PositionSquare(fromRow, fromCol)
            if (pieceController.getPieceInSquare(currentSquare) != null){
                return false
            }
            fromRow+=rowIterator
            fromCol+=colIterator
        }
        return true
    }
}