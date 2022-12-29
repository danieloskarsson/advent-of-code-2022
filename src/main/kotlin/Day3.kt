private fun rucksackCompartmentsFrom(input: String) = input
    .split("\n")
    .map { rucksack ->
        val half = rucksack.length / 2
        val compartment1 = rucksack.substring(0, half)
        val compartment2 = rucksack.substring(half)
        Pair(compartment1, compartment2)
    }

private val Char.rucksackPriority get() = if (code > 96) code - 96 else code - 38

private fun charInBothCompartments(compartment1: String, compartment2: String) = compartment1
    .chars()
    .filter { it.toChar() in compartment2 }
    .findFirst()!!
    .asInt
    .toChar()

fun charInBothRucksackCompartmentsSum(input: String) =
    rucksackCompartmentsFrom(input).sumOf { charInBothCompartments(it.first, it.second).rucksackPriority }
