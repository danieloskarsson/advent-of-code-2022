fun getResourceAsText(path: String): String? =
    object {}.javaClass.getResource(path)?.readText()

fun main() {
    val day1 = getResourceAsText("day1")!!
    println(maxCalories(day1)) // first half
    println(max3Calories(day1)) // second half
}
