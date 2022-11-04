package edu.austral.dissis.chess.mine.game

import pieces.MovementValidator
import pieces.Piece
import pieces.PieceColor
import pieces.chessPieces.King
import players.Player
import rules.RuleController
import rules.end.FiftyKingMovesRule
import squares.Square

class CommonEndGameController: EndGameController {
    private val ruleController = RuleController()
    private val fiftyKingMovesRule = FiftyKingMovesRule()

    override fun hasPlayerWon(pieceToCheck: Piece,otherColorPieces: List<Piece>,allPieces: List<Piece>,pieceController: PieceController,movementValidator: MovementValidator,rows: Int, cols: Int): Boolean {
        val king = pieceToCheck as King
        val kingPossiblePositions: List<Square> = pieceController.getKingPossiblePositions(king).filter {
            !movementValidator.isMoveOutOfBoard(rows, cols, it) && pieceController.getPieceInSquare(it) === null
        }
        return ruleController.checkForCheckMate(king,otherColorPieces,allPieces,kingPossiblePositions)
    }

    override fun isATie(pieceWithMaxMoves: Piece,allPieces: List<Piece>,pieceColor: PieceColor): Boolean {
        val king = pieceWithMaxMoves as King
        if (checkMaxKingMoves(king)) return true
        return ruleController.checkForTie(king, allPieces, pieceColor)
    }

    private fun checkMaxKingMoves(king: King): Boolean{
        return fiftyKingMovesRule.hasGameFinished(king)
    }

}