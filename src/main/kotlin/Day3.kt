import kotlin.streams.toList

private val String.split get() = chunked(length / 2).let { it.first() to it.last() }

private val Char.rucksackPriority get() = if (code > 96) code - 96 else code - 38

fun charInBothRucksackCompartmentsSum(input: String) = input
    .lines()
    .map { it.split }
    .sumOf { it.first.first { char -> char in it.second }.rucksackPriority }

fun groupBadgePrioritiesSum(input: String): Int {
    val badges = mutableListOf<Char>()
    val list = input.lines().toMutableList()
    while (list.isNotEmpty()) {
        val rucksack1 = list.removeFirst().chars().toList()
        val rucksack2 = list.removeFirst().chars().toList()
        val rucksack3 = list.removeFirst().chars().toList()
        val badge = rucksack1.first { it in rucksack2 && it in rucksack3 }.toChar()
        badges.add(badge)
    }
    return badges.sumOf { it.rucksackPriority }
}
