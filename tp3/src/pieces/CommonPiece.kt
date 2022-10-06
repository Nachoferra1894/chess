package pieces

import squares.Square

class CommonPiece(name: PieceName,color: PieceColor,private var position: Square) : Piece {

    override fun isActive(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getPosition(): Square {
        return position;
    }

    override fun getName(): PieceName {
        TODO("Not yet implemented")
    }

    override fun getColor(): PieceColor {
        TODO("Not yet implemented")
    }
}