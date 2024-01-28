package language

import org.afinn.Afinn
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class EnglishTest {

    @Test
    fun `creates the correct score for empty string`() {
        val afinn = Afinn(language = "en")

        val text = ""
        assertEquals(0.0, afinn.score(text))
        assertEquals("neutral", afinn.scoreToWords(text))
    }

    @Test
    fun `creates the correct score for English bad word`() {
        val afinn = Afinn(language = "en")

        val text = "bad"
        assertTrue(afinn.score(text) < 0)
        assertEquals("negative", afinn.scoreToWords(text))
    }

    @Test
    fun `creates the correct score for English words`() {
        val afinn = Afinn(language = "en")

        var text = "Awesome"
        assertTrue(afinn.score(text) > 0)
        assertEquals("positive", afinn.scoreToWords(text))

        text = "Bad product!"
        assertTrue(afinn.score(text) < 0)
        assertEquals("negative", afinn.scoreToWords(text))

        text = "I love this"
        assertTrue(afinn.score(text) > 0)
        assertEquals("positive", afinn.scoreToWords(text))

        text = "Average."
        assertEquals(0.0, afinn.score(text))
        assertEquals("neutral", afinn.scoreToWords(text))

        text =
            "If you ever need to contact them it’s the worst and terrible place to call " +
                    "- phone not being answered for hours  but when you come in the reception they are sitting and talking " +
                    "between each other while phone lines are ringing non stop. Was calling a morning before the appointment " +
                    "to confirm the time but because nobody never answered the phone we missed an appointment and when came " +
                    "to reception said we can’t disclose information of what time your grandfather’s appointment is. Just ridiculous!"

        assertTrue(afinn.score(text) < 0)
        assertEquals("negative", afinn.scoreToWords(text))

        text =
            "I'm a local lad. Raised right next door to this place and Bowling Park so both hold fond " +
                    "memories for me and my family. Passed my driving test recently and the first place I wanted to take my missus " +
                    "and 1 year old daughter was here. Still wonderful. So fascinating. Got lots of lovely photos of my baby's first visit. " +
                    "Staff are lovely, helpful and passionate about the place. Full of interesting trivia and knowledge. " +
                    "Made a donation and bought some cute keepsakes from the gift shop. " +
                    "Also I'm a descendant of the family who owned it some time ago, so there's that cool fact :)"

        assertTrue(afinn.score(text) > 0)
        assertEquals("positive", afinn.scoreToWords(text))

        text =
            "Did a walk here. Such a lovely place with all the walk-through and we went in the church (not for service). " +
                    "New building also very nice and old-looking. Beautiful place to be and its all history there"

        assertTrue(afinn.score(text) > 0)
        assertEquals("positive", afinn.scoreToWords(text))

        text =
            "This pharmacy is fantastic! Service is brilliant and staff are really friendly and nice. " +
                    "I would recommend this pharmacy to anyone if you want fast and efficient service. " +
                    "I never have to wait that long for my prescriptions and my medication is always given on time without any issues or concerns."

        assertTrue(afinn.score(text) > 0)
        assertEquals("positive", afinn.scoreToWords(text))
    }
}
