import org.afinn.Afinn
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class EmoticonsTest {
    @Test
    fun `creates the correct score for emoticons`() {
        val afinn = Afinn(language = "en", emoticons = true)

        var score = afinn.score(":-)")
        assertTrue(score > 0)
        var scoreToWords = afinn.scoreToWords(":-)")
        assertEquals("positive", scoreToWords)

        score = afinn.score(":-(")
        assertTrue(score < 0)
        scoreToWords = afinn.scoreToWords(":-(")
        assertEquals("negative", scoreToWords)

        score = afinn.score(":-|")
        assertEquals(-1.0, score)
        scoreToWords = afinn.scoreToWords(":-|")
        assertEquals("neutral", scoreToWords)

        score = afinn.score("<3")
        assertTrue(score > 0)
        scoreToWords = afinn.scoreToWords("<3")
        assertEquals("positive", scoreToWords)
    }
}