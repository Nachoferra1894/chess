package edu.austral.dissis.chess.mine.rules

abstract class CommonMoveRule(private var limit: Int? = 0) {
    fun isMovePossible(difference: Int): Boolean {
//        val limitValidation = if (limit == 0) true else (kotlin.math.abs(difference) <= limit)
//        return if (moveType === MoveType.FORWARD){
//            limitValidation && difference > 0
//        } else if (moveType === MoveType.BACKWARDS) {
//            limitValidation && difference < 0
//        } else limitValidation && difference != 0
        return true
    }
}
