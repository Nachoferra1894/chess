package rules.end


class CheckMateRule: EndGameRule {
    override fun hasGameFinished(): Boolean {
        return true
    }
}