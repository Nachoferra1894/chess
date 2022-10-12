package pieces

abstract class CommonPiece(private val color: PieceColor) {
    private var isAlive: Boolean = true
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

    fun isFirstMove(): Boolean{
        return movesCount == 0
    }

    fun getMoveCount(): Int {
        return movesCount
    }

    fun resetMoves(){
        movesCount = 0;
    }
    open fun addMove(){
        movesCount++;
    }
    open fun useNoPieceCrashRule(): Boolean{
        return true
    }

}