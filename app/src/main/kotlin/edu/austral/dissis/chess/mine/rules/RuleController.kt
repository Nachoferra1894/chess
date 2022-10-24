package rules

import generatos.BoardGenerator
import pieces.Piece
import pieces.PieceColor
import pieces.chessPieces.King
import rules.end.CheckMateRule
import rules.end.EndGameRule
import rules.end.FiftyKingMovesRule
import rules.end.StalemateRule

class RuleController() {
    private val isOnCheckRule = IsOnCheckRule()
    private val checkMateRule = CheckMateRule()
    private val fiftyKingMovesRule = FiftyKingMovesRule()
    private val stalemateRule = StalemateRule()
    private val tieRules: List<EndGameRule> = listOf(stalemateRule)
    private val boardGenerator = BoardGenerator()

    fun checkForCheck(king: King,otherColorPieces: List<Piece>,colorToCheck: PieceColor): Boolean{
        // I create a new board, to check if the move blocks the check
        return !isOnCheckRule.isMovePossible(king,otherColorPieces,colorToCheck)
    }
    fun checkForTie(king: King,pieces: List<Piece>,colorToCheck: PieceColor): Boolean{
        if (checkMaxKingMoves(king)) return true
        for (rule in tieRules){
            if (rule.hasGameFinished(pieces,colorToCheck)) return true
        }
        return false
    }
    private fun checkMaxKingMoves(king: King): Boolean{
        return fiftyKingMovesRule.hasGameFinished(king)
    }
    fun checkForCheckMate(pieces: List<Piece>,colorToCheck: PieceColor): Boolean {
        return checkMateRule.hasGameFinished(pieces,colorToCheck)
    }
}