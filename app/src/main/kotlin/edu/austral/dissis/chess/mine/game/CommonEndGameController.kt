package edu.austral.dissis.chess.mine.game

import pieces.MovementValidator
import pieces.Piece
import pieces.PieceColor
import pieces.PieceName
import pieces.chessPieces.King
import players.Player
import rules.RuleController
import rules.end.FiftyKingMovesRule
import squares.Square

class CommonEndGameController: EndGameController {
    private val ruleController = RuleController()
    private val fiftyKingMovesRule = FiftyKingMovesRule()

    override fun hasPlayerWon(pieceToMove: Piece,playerToMove: Player,pieceController: PieceController,movementValidator: MovementValidator,rows: Int, cols: Int): Boolean {
        val allPieces = pieceController.getPieces()
        val otherColorPieces = pieceController.getPiecesNotFromColor(playerToMove.getColor())
        val nextKing: Piece = pieceController.getFirstPiecePosition(PieceName.KING,playerToMove.getColor()) ?: throw IllegalArgumentException("King not in board")
        if (pieceToMove.getName() === PieceName.PAWN) {
            nextKing.resetMoves()
        }
        val kingPossiblePositions: List<Square> = pieceController.getKingPossiblePositions(nextKing as King).filter {
            !movementValidator.isMoveOutOfBoard(rows, cols, it) && pieceController.getPieceInSquare(it) === null
        }
        return ruleController.checkForCheckMate(nextKing as King,otherColorPieces,allPieces,kingPossiblePositions)
    }

    override fun isATie(allPieces: List<Piece>,pieceColor: PieceColor,pieceController: PieceController): Boolean {
        val king: Piece = pieceController.getFirstPiecePosition(PieceName.KING,pieceColor) ?: throw IllegalArgumentException("King not in board")
        if (checkMaxKingMoves(king as King)) return true
        return ruleController.checkForTie(king, allPieces, pieceColor)
    }

    private fun checkMaxKingMoves(king: King): Boolean{
        return fiftyKingMovesRule.hasGameFinished(king)
    }

}