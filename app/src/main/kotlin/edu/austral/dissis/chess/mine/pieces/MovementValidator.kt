package pieces

import rules.ExtraRule
import rules.MaxBoardRule
import rules.NoPieceCrashRule
import rules.moves.MoveRule
import squares.Square

class MovementValidator {
    private val maxBoardRule = MaxBoardRule()
    private val noPieceCrashRule = NoPieceCrashRule()
    fun isMovePossible(pieces: List<Piece>,sqFrom: Square,sqTo: Square,pieceToMove: Piece,eatenPiece: Piece? = null): Boolean{
        val moveRules = pieceToMove.getMovementRules()
        val extraRules = pieceToMove.getExtraRules()
        val noPieceCrash = pieceToMove.useNoPieceCrashRule()
        val noPieceCollide = pieceToMove.useNoPieceCollide()
        if (noPieceCollide){
            if (eatenPiece !== null && eatenPiece.getColor() === pieceToMove.getColor()){
                return false
            }
        }
        for (rule in moveRules){
            if(rule.isMovePossible(sqFrom, sqTo,eatenPiece)){
                return if (noPieceCrash){
                    noPieceCrashRule.isMovePossible(sqFrom,sqTo,rule,pieces)
                } else true
            }
        }
        for (rule in extraRules){
            if(rule.isMovePossible(sqFrom,sqTo,pieces)){
                return if (noPieceCrash){
                    noPieceCrashRule.isMovePossible(sqFrom,sqTo,rule,pieces)
                } else true
            }
        }
        return false
    }
    fun isMoveOutOfBoard(rows: Int,cols: Int, sqTo: Square): Boolean{
        return !maxBoardRule.isMovePossible(rows,cols,sqTo)
    }
}