fun String.toLines() = split("\n")

fun String.toPair(delimiter: String) = split(delimiter, limit = 2).let {
    it.first() to it.last()
}

fun String.toRange(delimiter: String) = toPair(delimiter).let {
    it.first.toInt()..it.second.toInt()
}
