package edu.austral.dissis.chess.mine.game

import pieces.MovementValidator
import pieces.Piece
import pieces.PieceColor
import pieces.PieceName
import players.Player

class ChancellorEndGameController: EndGameController {
    override fun hasPlayerWon(
        pieceToMove: Piece,
        playerToMove: Player,
        pieceController: PieceController,
        movementValidator: MovementValidator,
        rows: Int,
        cols: Int
    ): Boolean {
        val chancellor = pieceController.getFirstPiecePosition(PieceName.CHANCELLOR,playerToMove.getColor()) ?: return true
        chancellor.getPosition() ?: return true
        return false
    }


    override fun isATie(allPieces: List<Piece>, pieceColor: PieceColor, pieceController: PieceController): Boolean {
        return false
    }


}