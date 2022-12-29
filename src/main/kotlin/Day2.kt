private fun mapFrom(input: String) = input
    .split("\n")
    .map { round ->
        val split = round.split(" ", limit = 2)
        Pair(split[0].first(), split[1].first())
    }

private fun objectFrom(letter: Char) = when (letter) {
    'A', 'X' -> RockPaperScissors.Rock
    'B', 'Y' -> RockPaperScissors.Paper
    'C', 'Z' -> RockPaperScissors.Scissors
    else -> throw IllegalArgumentException()
}

private sealed class RockPaperScissors(val points: Int) {
    object Rock : RockPaperScissors(1)
    object Paper : RockPaperScissors(2)
    object Scissors : RockPaperScissors(3)

    fun versusPoints(other: RockPaperScissors): Int {
        if (this.points == other.points) {
            return 3
        }

        if ((this == Rock && other == Scissors)
            || (this == Paper && other == Rock)
            || (this == Scissors && other == Paper)
        ) {
            return 6
        }

        return 0
    }

    /**
     * Return the corresponding object for when letter is:
     *  X -> this wins, return corresponding loosing object
     *  Z -> this loose, return corresponding winning object
     *  Y -> draw, return same object
     */
    fun versusObject(letter: Char) = when (letter) {
        'X' -> when (this) {
            Rock -> Scissors
            Paper -> Rock
            Scissors -> Paper
        }
        'Z' -> when (this) {
            Rock -> Paper
            Paper -> Scissors
            Scissors -> Rock
        }
        'Y' -> this
        else -> throw IllegalArgumentException()
    }
}

fun rockPaperScissorsTotalScore(input: String): Int {
    var sum = 0
    mapFrom(input).forEach {
        val other = objectFrom(it.first)
        val you = objectFrom(it.second)
        sum += you.points
        sum += you.versusPoints(other)
    }
    return sum
}

fun rockPaperScissorsStrategyScore(input: String): Int {
    var sum = 0
    mapFrom(input).forEach {
        val other = objectFrom(it.first)
        val you = other.versusObject(it.second)
        sum += you.points
        sum += you.versusPoints(other)
    }
    return sum
}
