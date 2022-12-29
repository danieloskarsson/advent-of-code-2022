fun getResourceAsText(path: String): String? =
    object {}.javaClass.getResource(path)?.readText()

fun main() {
    val day1 = getResourceAsText("day1")!!
    println(maxCalories(day1)) // first half
    println(max3Calories(day1)) // second half

    val day2 = getResourceAsText("day2")!!
    println(rockPaperScissorsTotalScore(day2))
    println(rockPaperScissorsStrategyScore(day2))

    val day3 = getResourceAsText("day3")!!
    println(charInBothRucksackCompartmentsSum(day3))
    println(groupBadgePrioritiesSum(day3))

    val day4 = getResourceAsText("day4")!!
    println(fullyContainedRanges(day4))
}
