package pieces

import pieces.chessPieces.Rook
import rules.MaxBoardRule
import rules.NoPieceCrashRule
import rules.moves.HorizontalMoveRule
import rules.moves.VerticalMoveRule
import squares.PositionSquare
import squares.Square
import kotlin.math.abs

class MovementValidator {
    private val maxBoardRule = MaxBoardRule()
    private val noPieceCrashRule = NoPieceCrashRule()
    fun isMovePossible(pieces: List<Piece>,sqFrom: Square,sqTo: Square,pieceToMove: Piece,eatenPiece: Piece? = null): Boolean{
        val moveRules = pieceToMove.getMovementRules()
        val noPieceCrash = pieceToMove.useNoPieceCrashRule()
        val noPieceCollide = pieceToMove.useNoPieceCollide()

        if (noPieceCollide){
            if (eatenPiece !== null && eatenPiece.getColor() === pieceToMove.getColor()){
                return false
            }
        }
        for (rule in moveRules){
            if(rule.isMovePossible(sqFrom, sqTo,eatenPiece)){
                if (!noPieceCrash || noPieceCrashRule.isMovePossible(sqFrom,sqTo,rule,pieces) ){
                    return true
                }
            }
        }

        return false
    }
    fun isMoveOutOfBoard(rows: Int,cols: Int, sqTo: Square): Boolean{
        return !maxBoardRule.isMovePossible(rows,cols,sqTo)
    }

    fun checkForCastle(allPieces: List<Piece>, sqFrom: Square, sqTo: Square, pieceToMove: Piece, rookForCastle: Rook): Square? {
        if (pieceToMove.getMoveCount() > 1 || rookForCastle.getMoveCount() > 1){
            return null
        }
        if (abs(sqFrom.getColumn() - sqTo.getColumn()) <2){
            return null
        }
        val horizontalMoveRule = HorizontalMoveRule(2)
        if (noPieceCrashRule.isMovePossible(sqFrom,sqTo,horizontalMoveRule,allPieces)){
            val sqCol = sqTo.getColumn()
            val col = if (pieceToMove.getPosition()?.getColumn()!! > sqCol) sqCol + 1 else sqCol - 1
            return PositionSquare(sqTo.getRow(),col)
        }
        return null
    }
}