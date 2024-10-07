package test

import main.TextGenerator
import org.testng.Assert.assertEquals
import org.testng.Assert.assertTrue
import org.testng.annotations.Test

class TextGeneratorTest {

    @Test
    fun testSimpleSentence() {
        val inputText = "The quick brown fox jumps over the lazy dog."

        TextGenerator.learnWords(inputText)
        val generatedText = TextGenerator.generateText()

        assertTrue(generatedText.startsWith("The quick"), "Generated text should start with 'The quick'")

        assertTrue(generatedText.isNotEmpty(), "Generated text should not be empty")
    }

    @Test
    fun testRepeatedWords() {
        val inputText = "She sells sea shells by the sea shore. She sells sea shells in the shop."

        TextGenerator.learnWords(inputText)
        val generatedText = TextGenerator.generateText()

        assertTrue(generatedText.startsWith("She sells"), "Generated text should start with 'She sells'")

        assertTrue(
            generatedText.contains("sea shells") || generatedText.contains("sea shore") || generatedText.contains("in the shop"),
            "Generated text should contain valid continuations from the input"
        )
    }

    @Test
    fun testStateResets() {
        val inputText1 = "The cat chased the mouse."
        TextGenerator.learnWords(inputText1)
        val generatedText1 = TextGenerator.generateText()

        assertTrue(generatedText1.startsWith("The cat"), "Generated text should start with 'The cat' after first input")

        val inputText2 = "A quick brown fox jumps over the lazy dog."
        TextGenerator.learnWords(inputText2)
        val generatedText2 = TextGenerator.generateText()

        assertTrue(generatedText2.startsWith("A quick"), "Generated text should start with 'A quick' after second input")

        assertTrue(
            !generatedText2.contains("cat") && !generatedText2.contains("mouse"),
            "Generated text should not contain words from the first input after reset"
        )
    }

    @Test
    fun testComplexSentenceWithVariations() {
        val inputText = "I think, therefore I am, but sometimes I think I am something else."

        TextGenerator.learnWords(inputText)
        val generatedText = TextGenerator.generateText()

        assertTrue(generatedText.startsWith("I think"), "Generated text should start with 'I think'")

        assertTrue(
            generatedText.contains("therefore I am") || generatedText.contains("sometimes I think"),
            "Generated text should contain valid continuations from the input"
        )
    }

    @Test
    fun testEmptyText() {
        val inputText = ""

        TextGenerator.learnWords(inputText)
        val generatedText = TextGenerator.generateText()

        assertEquals("", generatedText, "Generated text should be empty for empty input")
    }

    @Test
    fun testOnlyTwoWords() {
        val nonEmptyInput = "Hello world!"
        TextGenerator.learnWords(nonEmptyInput)
        val generatedText = TextGenerator.generateText()
        assertEquals("", generatedText, "Generated must contain Hello world!")
    }
}