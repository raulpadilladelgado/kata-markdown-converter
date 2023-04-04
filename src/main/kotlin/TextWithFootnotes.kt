data class TextWithFootnotes(private val value: String = "") {
    fun from(text: String): TextWithFootnotes {
        return TextWithFootnotes("")
    }
}
