package game

import pieces.PieceColor

class TurnController {
    private var playerTurn = 0;

    fun initTurns(player1Color: PieceColor) {
        playerTurn = if (player1Color == PieceColor.WHITE) 0 else 1
    }

    fun getPlayerTurn(): Int {
        return playerTurn
    }

    fun changePlayerTurn(): Int {
        val player = if (playerTurn == 1) 0 else 1
        playerTurn = player
        return player
    }

}