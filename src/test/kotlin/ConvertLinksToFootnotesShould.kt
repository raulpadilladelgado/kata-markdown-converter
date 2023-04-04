import org.junit.jupiter.api.Test
import org.mockito.MockedStatic
import org.mockito.Mockito.*
import kotlin.test.assertEquals


class ConvertLinksToFootnotesShould {
    @Test
    fun `write converted text to the output file path`() {
        val fileReader = mock(FileReader::class.java)
        val fileWriter = mock(FileWriter::class.java)
        val textWithFootnotes = mock(TextWithFootnotes::class.java)
        val sourceFilePath = "source.md"
        val outputFilePath = "output.md"
        val sourceText = """
            visible text [link](url or text)
            """.trimIndent()
        `when`(fileReader.read(sourceFilePath)).thenReturn(sourceText)
        val expectedText = TextWithFootnotes(
            """
                visible text link [^anchor1]

                [^anchor1]: url or text
            """.trimIndent()
        )
        `when`(textWithFootnotes.from(sourceText)).thenReturn(expectedText)

        ConvertLinksToFootnotes(fileReader, fileWriter, textWithFootnotes).execute(sourceFilePath, outputFilePath)

        verify(fileReader).read(sourceFilePath)
        verify(fileWriter).write(outputFilePath, expectedText)
    }
}