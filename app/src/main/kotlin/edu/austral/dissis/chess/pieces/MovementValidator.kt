package pieces

import rules.ExtraRule
import rules.MaxBoardRule
import rules.NoPieceCrashRule
import rules.moves.MoveRule
import squares.Board
import squares.Square

class MovementValidator {
    private val maxBoardRule = MaxBoardRule()
    private val noPieceCrashRule = NoPieceCrashRule()
    fun isMovePossible(board: Board,sqFrom: Square,sqTo: Square,moveRules: List<MoveRule>,extraRules: List<ExtraRule>,noPieceCrash: Boolean): Boolean{
        if (isMoveOutOfBoard(board,sqTo)) return false
        for (rule in moveRules){
            if(rule.isMovePossible(sqFrom, sqTo)){
                return if (noPieceCrash){
                    noPieceCrashRule.isMovePossible(sqFrom,sqTo,rule)
                } else true
            }
        }
        for (rule in extraRules){
            if(rule.isMovePossible(sqFrom,sqTo,board)){
                return if (noPieceCrash){
                    noPieceCrashRule.isMovePossible(sqFrom,sqTo,rule)
                } else true
            }
        }
        return false
    }
    private fun isMoveOutOfBoard(board: Board, sqTo: Square): Boolean{
        return maxBoardRule.isMovePossible(board,sqTo)
    }
}