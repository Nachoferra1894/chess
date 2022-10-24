package game

import players.Player
import kotlin.system.exitProcess

class GameFinisher {
    fun finishGameInTie(){
        println("The Game finished in a Tie!")
        exitProcess(0)
    }
    fun  finishGame(player: Player){
        println("Player ${player.getName()} has won!")
        exitProcess(0)
    }
}