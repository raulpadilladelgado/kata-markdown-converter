import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TerminalInterpreterShould {
    @Test
    fun `redirect to replace link by footnotes when it is specified by argument`() {
        val convertLinksToFootnotes = mockk<ConvertLinksToFootnotes>(relaxed = true)
        val arguments = arrayOf("link2footnote", "source.md", "output.md")

        TerminalInterpreter(convertLinksToFootnotes).execute(arguments)

        verify {
            convertLinksToFootnotes.execute("source.md", "output.md")
        }
    }

    @Test
    fun `fail if the given command doesn't exist`() {
        val convertLinksToFootnotes = mockk<ConvertLinksToFootnotes>(relaxed = true)
        val arguments = arrayOf("wrong-command")

        assertThrows<UnknownCommandError> {
            TerminalInterpreter(convertLinksToFootnotes).execute(arguments)
        }
    }
}