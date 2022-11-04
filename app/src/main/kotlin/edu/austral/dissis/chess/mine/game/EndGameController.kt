package edu.austral.dissis.chess.mine.game

import pieces.MovementValidator
import pieces.Piece
import pieces.PieceColor
import pieces.chessPieces.King


interface EndGameController {
    fun hasPlayerWon(pieceToCheck: Piece, otherColorPieces: List<Piece>, allPieces: List<Piece>, pieceController: PieceController, movementValidator: MovementValidator, rows: Int, cols: Int): Boolean
    fun isATie(pieceWithMaxMoves: Piece,allPieces: List<Piece>,pieceColor: PieceColor): Boolean
}