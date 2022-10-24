package edu.austral.dissis.chess.mine.game

import pieces.Piece
import pieces.PieceColor

class InitialGameState(val rows: Int,val cols: Int,val pieces: List<Piece>,val playerTurn: PieceColor) {
}