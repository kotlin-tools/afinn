package language

import org.afinn.Afinn
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import kotlin.test.Test

class DanishTest {

    @Test
    fun `creates the correct score for empty string`() {
        val afinn = Afinn(language = "da")

        val text = ""
        assertEquals(0.0, afinn.score(text))
        assertEquals("neutral", afinn.scoreToWords(text))
    }

    @Test
    fun `creates the correct score for Danish bad word`() {
        val afinn = Afinn(language = "da")

        val text = "dårligt"
        assertTrue(afinn.score(text) < 0)
        assertEquals("negative", afinn.scoreToWords(text))
    }

    @Test
    fun `creates the correct score for Danish words`() {
        val afinn = Afinn(language = "da")

        var text = "Fantastisk"
        assertTrue(afinn.score(text) > 0)
        assertEquals("positive", afinn.scoreToWords(text))

        text = "Dårligt produkt!"
        assertTrue(afinn.score(text) < 0)
        assertEquals("negative", afinn.scoreToWords(text))

        text = "Jeg elsker det her"
        assertTrue(afinn.score(text) > 0)
        assertEquals("positive", afinn.scoreToWords(text))

        text = "Gennemsnit."
        assertEquals(0.0, afinn.score(text))
        assertEquals("neutral", afinn.scoreToWords(text))

        text =
            "Moderate priser, udvidet åbningstider, gratis parkering og der er altid fri parkeringsplads."

        assertEquals(1.0, afinn.score(text))
        assertEquals("neutral", afinn.scoreToWords(text))

        text =
            "Jeg synes det er en god butik med mange gode " +
                    "Varer, dog til tider lidt for mange ting og rodde igennem i spot varene. " +
                    "Har et par gange osse købt nogen grøntsager der ikke var super friske men jeg kigger mere grundigt nu. " +
                    "Generelt mange spændene spot varer hver uge og generelt bredt udvalg. " +
                    "Ren butik."

        assertTrue(afinn.score(text) > 0)
        assertEquals("positive", afinn.scoreToWords(text))

        text =
            "Virkelig fantastisk ret nyt rekreativt område i en gammel grusgrav. :D " +
                    "Her kan du fiske, svømme, spille fodbold, cykle på mountainbike på de gode stier, " +
                    "gå på opdagelse efter trolde eller måske lave pizza i pizzaovnen. Perfekt til dig der eksempelvis skal på caminoen. " +
                    "Er du blevet træt kan du overnatte i en shelter eller bare nyde livet på en bænk eller " +
                    "lave mad på en af de mange grillpladser."

        assertTrue(afinn.score(text) > 0)
        assertEquals("positive", afinn.scoreToWords(text))

        text =
            "Rigtig god skole. Der er et godt sammenhold mellem eleverne og en god dynamik på skolen. " +
                    "Det er en skole hvor man udvikler sig personligt samt fagligt og lærerne er meget kompetente til at hjælpe " +
                    "de studerende med fremtidige muligheder."

        assertTrue(afinn.score(text) > 0)
        assertEquals("positive", afinn.scoreToWords(text))

        text =
            "Det var en meget forvirret oplevelse, priserne der var over og under varerne passede " +
                    "ikke med varerne omkring, de ansatte i butikken havde mere travlt med at snakke i hørersæt med hinanden, " +
                    "om personlige ting, end at betjene kunderne."

        assertTrue(afinn.score(text) < 0)
        assertEquals("negative", afinn.scoreToWords(text))
    }
}
