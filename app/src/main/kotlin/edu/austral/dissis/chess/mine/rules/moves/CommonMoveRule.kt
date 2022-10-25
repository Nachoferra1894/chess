package rules.moves

abstract class CommonMoveRule(open var limit: Int = 0, open val moveType: MoveType = MoveType.ANY) {
    fun isMovePossible(difference: Int): Boolean {
        if (difference === 0) return false
        val limitValidation = if (limit == 0) true else (kotlin.math.abs(difference) <= limit)
        if (moveType === MoveType.FORWARD){
            return limitValidation && difference > 0
        } else  if (moveType === MoveType.BACKWARDS){
            return limitValidation && difference < 0
        } else return limitValidation && difference != 0
    }
}