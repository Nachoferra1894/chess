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
        return this.hashCode().toString()
    }
    fun hasBeenEaten() {
        this.isAlive = false
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
    open fun addMove(){
        movesCount++;
    }
    open fun useNoPieceCrashRule(): Boolean{
        return true
    }
    open fun getExtraRules(): List<ExtraRule> {
        return emptyList()
    }

}