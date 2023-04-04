fun main(args: Array<String>) {
    TerminalInterpreter(
        ConvertLinksToFootnotes(
            FileReaderFromLocalFilesystem(),
            FileWriterToLocalFilesystem(),
            TextWithFootnotes()
        )
    ).execute(args)
}