private fun mapFrom(input: String) = input
    .split("\n")
    .map { round ->
        val split = round.split(" ", limit = 2)
        Pair(split[0].first(), split[1].first())
    }

private fun objectFrom(letter: Char): RockPaperScissors {
    return when (letter) {
        'A', 'X' -> RockPaperScissors.Rock
        'B', 'Y' -> RockPaperScissors.Paper
        'C', 'Z' -> RockPaperScissors.Scissors
        else -> throw IllegalArgumentException()
    }
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
