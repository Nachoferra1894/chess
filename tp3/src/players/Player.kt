package players

import pieces.PieceColor

interface Player{
    fun activeTurn()
    fun makeMove()
    fun offerStaleMate()
    fun respondStaleMate(): Boolean
    fun resign()
    fun getColor(): PieceColor
}