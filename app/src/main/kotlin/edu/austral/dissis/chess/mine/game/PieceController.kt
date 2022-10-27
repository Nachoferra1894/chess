package edu.austral.dissis.chess.mine.game

import generatos.PieceGenerator
import pieces.Piece
import pieces.PieceColor
import pieces.PieceName
import pieces.chessPieces.King
import pieces.chessPieces.Rook
import squares.PositionSquare
import squares.Square

class PieceController {
    private val pieceNames: HashMap<PieceName, Int> = hashMapOf(
        PieceName.KING to 1,
        PieceName.QUEEN to 1,
        PieceName.PAWN to 8,
        PieceName.ROOK to 2,
        PieceName.BISHOP to 2,
        PieceName.KNIGHT to 2
    )
    private var pieces: MutableList<Piece> = mutableListOf()
    private val pieceGenerator: PieceGenerator = PieceGenerator()

    constructor() {
    }

    constructor(pieces: List<Piece>) {
        this.pieces = pieces.toMutableList()
    }

    fun generatePieces(player1Color: PieceColor, player2Color: PieceColor): List<Piece> {
        val thisPieces: MutableList<Piece> = mutableListOf();
        var index = 0
        for ((key, value) in pieceNames) {
            for (i in 1..value) {
                val pieceId = "${key.toString().slice(0..2)}:${index}:${i}"
                thisPieces.add(pieceGenerator.createPiece(key, player1Color,"${player1Color}${pieceId}"))
                thisPieces.add(pieceGenerator.createPiece(key, player2Color,"${player2Color}${pieceId}"))
            }
            index++;
        }

        pieces = thisPieces;

        return thisPieces
    }


    fun getPieces(): List<Piece> {
        return pieces
    }

    fun getPieceInSquare(sq: Square): Piece? {
        return pieces.find {
            val pos = it.getPosition()
            ((pos?.getRow() ?: false) === sq.getRow()) && ((pos?.getColumn() ?: false) === sq.getColumn());
        }
    }


    fun movePieceToSquare(sq: Square, pieceToMove: Piece) {
        pieceToMove.makeMove(sq)
    }

    fun getKingPosition(pieceColor: PieceColor): King {
        val king: Piece? = pieces.find {
            it.getName() === PieceName.KING && it.getColor() === pieceColor
        }
        if (king === null){
            throw IllegalArgumentException("King not in board!")
        } else return king as King
    }

    fun getPiecesNotFromColor(color: PieceColor): List<Piece> {
        return pieces.filter { it.getColor() !== color }
    }

    fun promotePiece(pieceToMove: Piece, newPiece: PieceName) {
        pieces[pieces.indexOf(pieceToMove)] = pieceGenerator.promotePiece(pieceToMove, newPiece)
    }

    fun getPiecesFromColor(color: PieceColor): List<Piece> {
        return pieces.filter { it.getColor() === color }
    }

    fun getKingPossiblePositions(nextKing: King): List<Square> {
        val possibleMoves: MutableList<Square> = mutableListOf()
        val row: Int? = nextKing.getPosition()?.getRow()
        val col: Int? = nextKing.getPosition()?.getColumn()
        val possibleMovesArray = listOf(-1, 0, 1)

        if (row != null && col != null) {
            for (i in possibleMovesArray) {
                for (j in possibleMovesArray) {
                    if (j != 0 || i != 0) {
                        possibleMoves.add(PositionSquare(row + i, col + j))
                    }

                }
            }
            return possibleMoves;
        }
        return emptyList()
    }

    fun getCastleNearestRook(piece: Piece, sqTo: Square, maxRows: Int, maxCols: Int): Rook? {
        if (piece.getName() === PieceName.KING) {
            val kingColor = piece.getColor()
            if (sqTo.getRow() == 0 || sqTo.getRow() == maxCols - 1) {
                for (i in 1..Math.ceilDiv(maxRows, 2)) {
                    val nextPos = PositionSquare(sqTo.getRow(), sqTo.getColumn() + i)
                    val prevPos = PositionSquare(sqTo.getRow(), sqTo.getColumn() - i)
                    val nextRook: Piece? = getPieceInSquare(nextPos)
                    val prevRook: Piece? = getPieceInSquare(prevPos)

                    if (nextRook != null && nextRook.getName() === PieceName.ROOK && nextRook.getColor() === kingColor) {
                        return nextRook as Rook?
                    }
                    if (prevRook != null && prevRook.getName() === PieceName.ROOK && prevRook.getColor() === kingColor) {
                        return prevRook as Rook?
                    }
                }
            }
        }
        return null
    }

}