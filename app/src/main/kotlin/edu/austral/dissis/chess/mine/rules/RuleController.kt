package rules

import generatos.BoardGenerator
import pieces.Piece
import pieces.PieceColor
import pieces.PieceName
import pieces.chessPieces.King
import rules.end.EndGameRule
import rules.end.FiftyKingMovesRule
import rules.end.StalemateRule
import squares.Square

class RuleController() {
    private val isOnCheckRule = IsOnCheckRule()
    private val fiftyKingMovesRule = FiftyKingMovesRule()
    private val stalemateRule = StalemateRule()
    private val tieRules: List<EndGameRule> = listOf(stalemateRule)
    private val boardGenerator = BoardGenerator()

    fun checkForCheck(king: King,otherColorPieces: List<Piece>,allPieces: List<Piece>,eatenPiece: Piece? = null): Boolean{
        // I create a new board, to check if the move blocks the check
        val kingPos: Square = king.getPosition() ?: throw IllegalArgumentException("King not in board")
        return isOnCheckRule.isOnCheck(kingPos,otherColorPieces,allPieces,eatenPiece) !== null
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
    fun checkForCheckMate(kingPos: Square,otherColorPieces: List<Piece>,allPieces: List<Piece>,eatenPiece: Piece? = null): Boolean {
        val pieceThatChecks = isOnCheckRule.isOnCheck(kingPos,otherColorPieces,allPieces,eatenPiece)
        if (pieceThatChecks === null || pieceThatChecks.getPosition() === null){
            return false
        } else {
            val thisColorPieces = allPieces.filter { otherColorPieces.indexOf(it) == -1 && it.getPosition().getRow() !== pieceThatChecks.getPosition().getRow() }
            return (isOnCheckRule.isOnCheck(pieceThatChecks.getPosition()!!,thisColorPieces,allPieces,eatenPiece) !== null)
        }
    }

    fun checkForPromotion(pieceToMove: Piece, sqTo: Square,maxRows: Int): Boolean {
        if(pieceToMove.getName() === PieceName.PAWN && (sqTo.getRow() === maxRows || sqTo.getRow() === 0)){
            return true
        }
        return false
    }
}