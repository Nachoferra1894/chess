package edu.austral.dissis.chess.adapter

import edu.austral.dissis.chess.gui.*
import edu.austral.dissis.chess.mine.game.InitialGameState
import pieces.PieceColor

class CustomGameEngine: GameEngine {
    private val classicGame = GameAdapter()
    override fun applyMove(move: Move): MoveResult {
        return try {
            classicGame.move(move)
            println(classicGame.getPieces())
            println(classicGame.nextMove())
            NewGameState(classicGame.getPieces(),classicGame.nextMove())
        }catch (e: Exception){
            InvalidMove(e.message!!)
        }
    }

    override fun init(): InitialState {
        val cols = 8
        val rows = 8
        val initialGameState: InitialGameState = classicGame.startGame(cols,rows,PieceColor.WHITE,PieceColor.BLACK,"Player 1","Player 2")
        val pieces = classicGame.getConvertedPieces(initialGameState.pieces)
        val colorTurn = classicGame.convertColor(initialGameState.playerTurn)
        val board = BoardSize(initialGameState.cols,initialGameState.rows)
        return InitialState(board,pieces , colorTurn)
    }
}