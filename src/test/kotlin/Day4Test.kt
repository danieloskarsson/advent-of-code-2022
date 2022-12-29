import org.junit.Test
import kotlin.test.assertEquals

class Day4Test {

    private val input = """
        2-4,6-8
        2-3,4-5
        5-7,7-9
        2-8,3-7
        6-6,4-6
        2-6,4-8
    """.trimIndent()

    @Test
    fun testFullyContainedRanges() {
        assertEquals(2, fullyContainedRanges(input))
    }

    @Test
    fun testOverlappingPairs() {
        assertEquals(4, overlappingPairs(input))
    }

}
