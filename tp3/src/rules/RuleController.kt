package rules

import generatos.BoardGenerator
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
    private val boardGenerator = BoardGenerator()

    fun checkForCheck(board: Board,sqFrom: Square,sqTo: Square,colorToCheck: PieceColor): Boolean{
        // I create a new board, to check if the move blocks the check
        val mockBoard = boardGenerator.createBoardFromSquares(board.getSquares())
        return !isOnCheckRule.isMovePossible(mockBoard,sqFrom,sqTo,colorToCheck)
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