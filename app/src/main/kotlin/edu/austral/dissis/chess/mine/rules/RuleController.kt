package rules

import generatos.BoardGenerator
import pieces.Piece
import pieces.PieceColor
import pieces.PieceName
import pieces.chessPieces.King
import rules.end.CheckMateRule
import rules.end.EndGameRule
import rules.end.FiftyKingMovesRule
import rules.end.StalemateRule
import squares.Square

class RuleController() {
    private val isOnCheckRule = IsOnCheckRule()
    private val checkMateRule = CheckMateRule()
    private val fiftyKingMovesRule = FiftyKingMovesRule()
    private val stalemateRule = StalemateRule()
    private val tieRules: List<EndGameRule> = listOf(stalemateRule)
    private val boardGenerator = BoardGenerator()

    fun checkForCheck(king: King,otherColorPieces: List<Piece>,allPieces: List<Piece>,sqTo: Square ): Boolean{
        // I create a new board, to check if the move blocks the check
        return isOnCheckRule.isOnCheck(king,otherColorPieces,allPieces,sqTo)
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

    fun checkForPromotion(pieceToMove: Piece, sqTo: Square,maxRows: Int): Boolean {
        if(pieceToMove.getName() === PieceName.PAWN && (sqTo.getRow() === maxRows || sqTo.getRow() === 0)){
            return true
        }
        return false
    }
}