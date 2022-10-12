package pieces

import rules.MaxBoardRule
import rules.NoPieceCrashRule
import rules.Rule
import rules.moves.MoveRule
import squares.Board
import squares.Square

class MovementValidator {
    private val maxBoardRule = MaxBoardRule()
    private val noPieceCrashRule = NoPieceCrashRule()
    fun isMovePossible(sqFrom: Square,sqTo: Square,moveRules: List<Rule>,noPieceCrash: Boolean): Boolean{
        for (rule in moveRules){
            if(rule.isMovePossible(sqFrom,sqTo)){
                return if (noPieceCrash){
                    noPieceCrashRule.isMovePossible(sqFrom,sqTo,rule)
                } else true
            }
        }
        return false
    }
    fun isMoveOutOfBoard(board: Board,sqTo: Square): Boolean{
        return maxBoardRule.isMovePossible(board,sqTo)
    }
}