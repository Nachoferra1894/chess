package pieces

abstract class MoveCountPiece {
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
}