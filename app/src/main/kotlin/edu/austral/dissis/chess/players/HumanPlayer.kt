package players

import pieces.PieceColor

class HumanPlayer(private val name: String,private val color: PieceColor): Player {

    override fun respondStaleMate(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getColor(): PieceColor {
       return color
    }
    override fun getName(): String {
        return name
    }
}