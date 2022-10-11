package pieces

import rules.MaxBoardRule
import rules.Rule
import squares.Board
import squares.Square

class MovementValidator {
    private val maxBoardRule = MaxBoardRule()
    fun isMovePossible(sqFrom: Square,sqTo: Square,rules: List<Rule>): Boolean{
        for (rule in rules){
            if(!rule.isMovePossible(sqFrom,sqTo)){
               return false
            }
        }
        return true
    }
    fun isMoveOutOfBoard(board: Board,sqTo: Square): Boolean{
        return maxBoardRule.isMovePossible(board,sqTo)
    }
}