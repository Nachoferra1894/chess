package rules.end

import pieces.chessPieces.King

class FiftyKingMovesRule {
     fun hasGameFinished(king: King): Boolean {
            return king.getMoveCount() == 51
    }
}