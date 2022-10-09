package pieces

import squares.Square

class PromotablePiece(private var name: PieceName, private var color: PieceColor) : Piece {
    override fun isActive(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getName(): PieceName {
        return name
    }

    override fun getColor(): PieceColor {
        return color
    }

    fun promoteTo(piece: CommonPiece) {
        this.name = piece.getName()
    }

}