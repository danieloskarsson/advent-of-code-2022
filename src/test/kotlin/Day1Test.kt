import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {

    private val input = """
        1000
        2000
        3000

        4000

        5000
        6000

        7000
        8000
        9000

        10000
    """.trimIndent()

    @Test
    fun testMaxCalories() {
        assertEquals(24000, maxCalories(input))
    }

    @Test
    fun testMax3Calories() {
        assertEquals(45000, max3Calories(input))
    }

}
