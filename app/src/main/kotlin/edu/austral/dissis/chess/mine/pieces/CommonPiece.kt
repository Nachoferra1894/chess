package pieces

import squares.Square

abstract class CommonPiece(private val color: PieceColor,private val id: String) {
    private var position: Square? = null
    var movesCount: Int = 0;

    fun getPosition(): Square?{
        return this.position
    }
    fun getColor(): PieceColor{
        return this.color
    }
    fun getId(): String{
        return this.id
    }
    fun hasBeenEaten() {
        this.position = null
    }

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
}

