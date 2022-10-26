package edu.austral.dissis.chess.adapter

import edu.austral.dissis.chess.gui.*
import edu.austral.dissis.chess.mine.game.InitialGameState
import game.Game
import game.GameFinisher
import pieces.Piece
import pieces.PieceColor
import squares.PositionSquare
import squares.Square

class GameAdapter() {
    private val customGame = Game()

    fun startGame(
        cols: Int,
        rows: Int,
        player1Color: PieceColor,
        player2Color: PieceColor,
        player1Name: String,
        player2Name: String
    ): InitialGameState {
        return customGame.startGame(cols, rows, player1Color, player2Color, player1Name, player2Name)
    }

    fun getConvertedPieces(pieces: List<Piece>): List<ChessPiece>{
        val newPieces = mutableListOf<ChessPiece>()
        for (piece in pieces){
            val convertedPiece = convertPiece(piece)
            if (convertedPiece !== null) newPieces.add(convertedPiece)
        }
        return newPieces
    }

     private fun convertPiece(piece: Piece): ChessPiece? {
        val piecePos: Square? = piece.getPosition()
        if (piecePos === null) return null

        val parsedPos = Position(piecePos.getColumn() + 1,piecePos.getRow() + 1)
        return ChessPiece(piece.getId(), convertColor(piece.getColor()),
            parsedPos,
            piece.getName().toString().lowercase()
        )
    }

    fun convertColor(color: PieceColor): PlayerColor {
        return if (color == PieceColor.WHITE) PlayerColor.WHITE else PlayerColor.BLACK
    }

    fun move(move: Move): MoveResult {
        val sqFrom: Square = PositionSquare(move.from.column - 1,move.from.row - 1)
        val sqTo: Square = PositionSquare(move.to.column - 1,move.to.row - 1)
        val gameFinisher: GameFinisher = customGame.movePiece(sqFrom,sqTo)
        if (gameFinisher.hasGameFinished){
            if (gameFinisher.winner != null){
                return GameOver(convertColor(gameFinisher.winner))
            } else {
                TODO("Finish in TIE?")
            }
        }
        return NewGameState(this.getPieces(), this.nextMove())
    }

    fun nextMove(): PlayerColor {
        return if(customGame.getPlayerToMove().getColor() == PieceColor.WHITE) {
            PlayerColor.WHITE
        }else{
            PlayerColor.BLACK
        }
    }

    fun getPieces(): List<ChessPiece>{
        return getConvertedPieces(customGame.getPieces())
    }
}