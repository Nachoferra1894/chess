package rules.moves

import pieces.CommonPiece
import pieces.Piece
import rules.Rule

interface MoveRule: Rule {
    val limit: Int?
}