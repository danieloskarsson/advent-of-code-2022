import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day2Test {

    private val input = """
        A Y
        B X
        C Z
    """.trimIndent()

    @Test
    fun testRockPaperScissorsTotalScore() {
        assertEquals(15, rockPaperScissorsTotalScore(input))
    }

    @Test
    fun testRockPaperScissorsStrategyScore() {
        assertEquals(12, rockPaperScissorsStrategyScore(input))
    }

}
