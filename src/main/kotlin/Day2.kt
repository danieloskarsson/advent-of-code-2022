private fun listFrom(input: String) = input
    .lines()
    .map { line ->
        line.split(" ").let {
            it.first().first() to it.last().first()
        }
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

    val superiorTo get() = when(this) {
        Rock -> Scissors
        Paper -> Rock
        Scissors -> Paper
    }

    val inferiorTo get() = when(this) {
        Rock -> Paper
        Paper -> Scissors
        Scissors -> Rock
    }

    fun versusPoints(other: RockPaperScissors) = when(other) {
        superiorTo -> 6
        inferiorTo -> 0
        else -> 3
    }

    fun versusObject(letter: Char) = when(letter) {
        'X' -> superiorTo
        'Z' -> inferiorTo
        'Y' -> this
        else -> throw IllegalArgumentException()
    }
}

fun rockPaperScissorsTotalScore(input: String) = listFrom(input).sumOf {
    val other = objectFrom(it.first)
    val you = objectFrom(it.second)
    you.points + you.versusPoints(other)
}

fun rockPaperScissorsStrategyScore(input: String) = listFrom(input).sumOf {
    val other = objectFrom(it.first)
    val you = other.versusObject(it.second)
    you.points + you.versusPoints(other)
}
