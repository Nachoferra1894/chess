package pieces

import rules.Rule
import squares.Board
import squares.Square

class MovementValidator {
    fun isMovePossible(sqFrom: Square,sqTo: Square,rules: List<Rule>): Boolean{
        for (rule in rules){
            if(!rule.isMovePossible(sqFrom,sqTo)){
               return false
            }
        }
        return true
    }
    fun isMoveOutOfBoard(board: Board,sqTo: Square): Boolean{
        return false
    }
}