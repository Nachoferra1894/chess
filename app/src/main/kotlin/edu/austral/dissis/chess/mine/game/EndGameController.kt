package edu.austral.dissis.chess.mine.game

import pieces.MovementValidator
import pieces.Piece
import pieces.PieceColor
import pieces.chessPieces.King
import players.Player


interface EndGameController {
    fun hasPlayerWon(pieceToMove: Piece, playerToMove: Player, pieceController: PieceController, movementValidator: MovementValidator, rows: Int, cols: Int): Boolean
    fun isATie(allPieces: List<Piece>,pieceColor: PieceColor,pieceController: PieceController): Boolean;
}