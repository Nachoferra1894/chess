package generatos

import pieces.PieceColor
import players.HumanPlayer
import players.Player

class PlayerGenerator {
    fun createPlayer(name: String,pieceColor: PieceColor): Player {
        return HumanPlayer(name,pieceColor)
    }
}