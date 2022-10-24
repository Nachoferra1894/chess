package edu.austral.dissis.chess.mine.game

import generatos.PieceGenerator
import pieces.Piece
import pieces.PieceColor
import pieces.PieceName
import pieces.chessPieces.King
import squares.Square

class PieceController {
    private val pieceNames: HashMap<PieceName,Int> = hashMapOf(
        PieceName.KING to 1,
        PieceName.QUEEN to 1,
        PieceName.PAWN to 8,
        PieceName.ROOK to 2,
        PieceName.BISHOP to 2,
        PieceName.KNIGHT to 2)
    private lateinit var pieces: List<Piece>
    private val pieceGenerator: PieceGenerator = PieceGenerator()

    fun generatePieces(player1Color: PieceColor, player2Color: PieceColor): List<Piece> {
        val thisPieces: MutableList<Piece> = mutableListOf();
        for ((key,value) in pieceNames) {
            for (i in 1..value){
                thisPieces.add(pieceGenerator.createPiece(key, player1Color))
                thisPieces.add(pieceGenerator.createPiece(key, player2Color))
            }
        }
        return thisPieces
    }


    fun getPieces(): List<Piece> {
        return pieces
    }

    fun getPieceInSquare(sq: Square): Piece? {
        return pieces.find {
            val pos = it.getPosition()
            ((pos?.getRow() ?: false) === sq.getRow()) && ((pos?.getRow() ?: false) === sq.getColumn());
        }
    }


    fun movePieceToSquare(sq: Square, pieceToMove: Piece) {
        pieceToMove.makeMove(sq)
    }

    fun getKingPosition(pieceColor: PieceColor): King {
        return pieces.find {
            it.getName() === PieceName.KING && it.getColor() === pieceColor
        } as King
    }

    fun getPiecesNotFromColor(color: PieceColor): List<Piece> {
        return pieces.filter { it.getColor() !== color }
    }

}