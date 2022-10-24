package players

import pieces.PieceColor

interface Player{
    fun respondStaleMate(): Boolean
    fun getColor(): PieceColor
    fun getName(): String
}