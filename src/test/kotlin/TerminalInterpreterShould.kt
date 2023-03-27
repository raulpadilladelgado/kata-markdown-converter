import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class TerminalInterpreterShould {
    @Test
    fun `redirect to replace link by footnotes when it is specified by argument`() {
        val convertLinksToFootnotes = mockk<ConvertLinksToFootnotes>(relaxed = true)
        val arguments = arrayOf("link2footnote")

        TerminalInterpreter(convertLinksToFootnotes).execute(arguments)

        verify {
            convertLinksToFootnotes.execute()
        }
    }
}