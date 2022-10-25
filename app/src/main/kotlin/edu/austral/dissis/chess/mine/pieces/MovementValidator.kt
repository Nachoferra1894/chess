package pieces

import rules.ExtraRule
import rules.MaxBoardRule
import rules.NoPieceCrashRule
import rules.moves.MoveRule
import squares.Square

class MovementValidator {
    private val maxBoardRule = MaxBoardRule()
    private val noPieceCrashRule = NoPieceCrashRule()
    fun isMovePossible(pieces: List<Piece>,sqFrom: Square,sqTo: Square,moveRules: List<MoveRule>,extraRules: List<ExtraRule>,noPieceCrash: Boolean): Boolean{
        if (sqTo === sqFrom){
            return false
        }
        for (rule in moveRules){
            if(rule.isMovePossible(sqFrom, sqTo)){
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