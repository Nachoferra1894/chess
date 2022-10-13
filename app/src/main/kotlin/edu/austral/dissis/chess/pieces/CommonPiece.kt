package pieces

import rules.ExtraRule

abstract class CommonPiece(private val color: PieceColor,private  val id: String) {
    private var isAlive: Boolean = true
    fun getId(): String{
        return this.id
    }
    fun getColor(): PieceColor{
        return this.color
    }
    fun hasBeenEaten() {
        this.isAlive = false
    }
    fun isActive(): Boolean {
        return this.isAlive
    }
    var movesCount: Int = 0;

    fun makeMove(){
        movesCount++
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