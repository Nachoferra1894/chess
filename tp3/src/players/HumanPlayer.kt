package players

import pieces.PieceColor

class HumanPlayer(name: String,color: PieceColor): Player {
    private val color: PieceColor = color
        get() = field

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
}