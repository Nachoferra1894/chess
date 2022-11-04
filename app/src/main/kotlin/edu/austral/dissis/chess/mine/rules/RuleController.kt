package rules

import generatos.BoardGenerator
import pieces.MovementValidator
import pieces.Piece
import pieces.PieceColor
import pieces.PieceName
import pieces.chessPieces.King
import rules.end.EndGameRule
import rules.end.FiftyKingMovesRule
import rules.end.StalemateRule
import squares.Square

class RuleController() {
    private val piecePointerRule = PiecePointer()
    private val stalemateRule = StalemateRule()
    private val tieRules: List<EndGameRule> = listOf(stalemateRule)

    fun checkForCheck(king: King,otherColorPieces: List<Piece>,allPieces: List<Piece>,eatenPiece: Piece? = null): Boolean{
        // I create a new board, to check if the move blocks the check
        val kingPos: Square = king.getPosition() ?: throw IllegalArgumentException("King not in board")
        return piecePointerRule.isPiecePointedBy(kingPos,otherColorPieces,allPieces,eatenPiece) !== null
    }
    fun checkForTie(king: King,pieces: List<Piece>,colorToCheck: PieceColor): Boolean{
        for (rule in tieRules){
            if (rule.hasGameFinished(pieces,colorToCheck)) return true
        }
        return false
    }
    fun checkForCheckMate(king: King,otherColorPieces: List<Piece>,allPieces: List<Piece>,kingPossibleMoves: List<Square>): Boolean {
        val kingPos = king.getPosition() ?: return false
        val pieceThatChecks = piecePointerRule.isPiecePointedBy(kingPos,otherColorPieces,allPieces) ?: return false
        val pieceThatChecksPos = pieceThatChecks.getPosition()

        if (pieceThatChecksPos !== null) {
            // Check if the king can move
            if (!kingPossibleMoves.all {
                    piecePointerRule.isPiecePointedBy(it,otherColorPieces,allPieces) !== null
            }) return false

            // If the king can eat the piece, it has to be defended
            if (piecePointerRule.isPiecePointedBy(pieceThatChecksPos, listOf(king),allPieces) !== null) {
                if (piecePointerRule.isPiecePointedBy(pieceThatChecksPos,otherColorPieces,allPieces) === null){
                    return false
                }
            }
            return true
        }
        return false

    }

    fun checkForPromotion(pieceToMove: Piece, sqTo: Square,maxRows: Int): Boolean {
        if(pieceToMove.getName() === PieceName.PAWN && (sqTo.getRow() == maxRows - 1 || sqTo.getRow() == 0)){
            return true
        }
        return false
    }
}