class ConvertLinksToFootnotes(
    private val fileReader: FileReader,
    private val fileWriter: FileWriter,
    private val textWithFootnotes: TextWithFootnotes
) {
    fun execute(sourceFilePath: String, outputFilePath: String) {
        val text: String = fileReader.read(sourceFilePath)
        val textWithFootnotes = textWithFootnotes.from(text)
        fileWriter.write(outputFilePath, textWithFootnotes)
    }
}
