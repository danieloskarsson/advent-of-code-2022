infix fun IntRange.subset(other: IntRange) = all { it in other }

infix fun IntRange.overlapping(other: IntRange) = any { it in other }

private fun listFrom(input: String) = input.toLines()
    .map { line -> line.toPair(",") }
    .map { pair -> pair.first.toRange("-") to pair.second.toRange("-") }

fun fullyContainedRanges(input: String) = listFrom(input).count {
    it.first subset it.second || it.second subset it.first
}

fun overlappingPairs(input: String) = listFrom(input).count {
    it.first overlapping it.second || it.second overlapping it.first
}
