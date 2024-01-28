import org.afinn.Afinn
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class EmojisTest {
    @Test
    fun `creates the correct score for emojis`() {
        val afinn = Afinn(language = "en", emoticons = true)

        var text = "🤗"
        var score = afinn.score(text)
        assertTrue(score > 0)
        var scoreToWords = afinn.scoreToWords(text)
        assertEquals("positive", scoreToWords)

        text = "🙄"
        score = afinn.score(text)
        assertEquals(-1.0, score)
        scoreToWords = afinn.scoreToWords(text)
        assertEquals("neutral", scoreToWords)

        text = "👿"
        score = afinn.score(text)
        assertTrue(score < 0)
        scoreToWords = afinn.scoreToWords(text)
        assertEquals("negative", scoreToWords)
    }
}