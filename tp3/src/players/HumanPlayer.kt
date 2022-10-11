package players

import pieces.PieceColor

class HumanPlayer(private val name: String,private val color: PieceColor): Player {
    override fun activeTurn() {
        TODO("Not yet implemented")
    }

    override fun makeMove() {
        TODO("Not yet implemented")
    }

    override fun offerStaleMate() {
        TODO("Not yet implemented")
    }

    override fun respondStaleMate(): Boolean {
        TODO("Not yet implemented")
    }

    override fun resign() {
        TODO("Not yet implemented")
    }

    override fun getColor(): PieceColor {
       return color
    }
    override fun getName(): String {
        return name
    }
}