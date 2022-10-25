package generatos

import edu.austral.dissis.chess.mine.pieces.MoveType
import pieces.*
import pieces.chessPieces.*

class PieceGenerator {
    fun createPiece(pieceName: PieceName,pieceColor: PieceColor): Piece{
        return if (pieceName === PieceName.PAWN){
            val moveType = if (pieceColor === PieceColor.WHITE) MoveType.FORWARD else MoveType.BACKWARDS
            Pawn(pieceColor)
        } else when(pieceName) {
            PieceName.ROOK -> Rook(pieceColor)
            PieceName.KNIGHT -> Knight(pieceColor)
            PieceName.BISHOP -> Bishop(pieceColor)
            PieceName.QUEEN -> Queen(pieceColor)
            PieceName.KING -> King(pieceColor)
            PieceName.PAWN -> Pawn(pieceColor)
        }
    }
    fun promotePiece(piece: Piece,newPiece: PieceName): Piece{
        TODO()
        //  add second constructor to pieces
    }
}
