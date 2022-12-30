private fun String.toPair(delimiter: String) = split(delimiter).let {
    it.first() to it.last()
}

private fun String.toRange(delimiter: String) = toPair(delimiter).let {
    it.first.toInt()..it.second.toInt()
}

private infix fun IntRange.subset(other: IntRange) = all { it in other }

private infix fun IntRange.overlapping(other: IntRange) = any { it in other }

private fun listFrom(input: String) = input.lines()
    .map { it.toPair(",") }
    .map { it.first.toRange("-") to it.second.toRange("-") }

fun fullyContainedRanges(input: String) = listFrom(input).count {
    it.first subset it.second || it.second subset it.first
}

fun overlappingPairs(input: String) = listFrom(input).count {
    it.first overlapping it.second || it.second overlapping it.first
}
