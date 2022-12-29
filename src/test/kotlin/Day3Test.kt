import org.junit.Test
import kotlin.test.assertEquals

class Day3Test {

    private val input = """
        vJrwpWtwJgWrhcsFMMfFFhFp
        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        PmmdzqPrVvPwwTWBwg
        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        ttgJtRGJQctTZtZT
        CrZsJsPPZsGzwwsLwLmpwMDw
    """.trimIndent()

    @Test
    fun testCharInBothRucksackCompartmentsSum() {
        assertEquals(157, charInBothRucksackCompartmentsSum(input))
    }

    @Test
    fun testSumOfGroupBadgePriorities() {
        assertEquals(70, groupBadgePrioritiesSum(input))
    }

}
