package players

interface Player{
    fun activeTurn()
    fun makeMove()
    fun offerStaleMate()
    fun respondStaleMate(): Boolean
    fun resign()
}