package pieces

import rules.ExtraRule
import squares.Square

abstract class CommonPiece(private val color: PieceColor) {
    private var isAlive: Boolean = true
    private var position: Square? = null

    fun getPosition(): Square?{
        return this.position
    }
    fun getColor(): PieceColor{
        return this.color
    }
    fun getId(): String{
        return System.identityHashCode(this).toString()
    }
    fun hasBeenEaten() {
        this.isAlive = false
        this.position = null
    }
    fun isActive(): Boolean {
        return this.isAlive
    }
    var movesCount: Int = 0;

    open fun makeMove(sq: Square){
        movesCount++;
        position = sq;
    }

    fun getMoveCount(): Int {
        return movesCount
    }

    fun resetMoves(){
        movesCount = 1;
    }
    open fun useNoPieceCrashRule(): Boolean{
        return true
    }
    open fun useNoPieceCollide(): Boolean{
        return true
    }
    open fun getExtraRules(): List<ExtraRule> {
        return emptyList()
    }

}