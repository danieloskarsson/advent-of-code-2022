fun maxCalories(input: String) = input
    .split("\n\n")
    .maxOf { set -> set.lines().sumOf { it -> it.toInt() } }

fun max3Calories(input: String): Int {
    var max1 = 0
    var max2 = 0
    var max3 = 0
    input.split("\n\n").forEach { set ->
        val sum = set.lines().sumOf { it.toInt() }
        if (sum > max1) {
            max3 = max2
            max2 = max1
            max1 = sum
        } else if (sum > max2) {
            max3 = max2
            max2 = sum
        } else if (sum > max3) {
            max3 = sum
        }
    }
    return max1 + max2 + max3
}
