package edu.austral.dissis.chess.mine.generatos

import pieces.PieceColor
import pieces.PieceName
import squares.Square
import kotlin.Int

interface PiecesInBoardGenerator {
    fun getPiecesInBoard(): HashMap<PieceName,Int>;
}