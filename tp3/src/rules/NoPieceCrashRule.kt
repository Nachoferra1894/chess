package rules

import pieces.Piece
import squares.Board
import squares.Square

class NoPieceCrashRule: Rule {
    override fun isMovePossible(board: Board, sqFrom: Square, sqTo: Square): Boolean {
        TODO("Not yet implemented")
    }
}