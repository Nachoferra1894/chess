package rules

import pieces.PieceColor
import players.Player
import rules.end.CheckMateRule
import rules.end.EndGameRule
import rules.end.FiftyKingMovesRule
import rules.end.StalemateRule
import squares.Board
import squares.Square

class RuleController() {
    private val isOnCheckRule = IsOnCheckRule()
    private val checkMateRule = CheckMateRule()
    private val fiftyKingMovesRule = FiftyKingMovesRule()
    private val stalemateRule = StalemateRule()
    private val tieRules: List<EndGameRule> = listOf(fiftyKingMovesRule,stalemateRule)

    fun checkForCheck(board: Board,sqFrom: Square,sqTo: Square,colorToCheck: PieceColor): Boolean{
        if (isOnCheckRule.isMovePossible(board,colorToCheck)){
            if (!isOnCheckRule.doesMoveBlock(board,sqFrom,sqTo,colorToCheck)) return false
        }
        return true
    }
    fun checkForTie(board: Board,colorToCheck: PieceColor): Boolean{
        for (rule in tieRules){
            if (rule.hasGameFinished(board,colorToCheck)) return true
        }
        return false
    }
    fun checkForCheckMate(board: Board,colorToCheck: PieceColor): Boolean {
        return checkMateRule.hasGameFinished(board,colorToCheck)
    }
}