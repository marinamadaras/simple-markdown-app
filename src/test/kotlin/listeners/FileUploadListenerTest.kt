package listeners

import com.marina.listeners.FileUploadListener
import com.marina.view.MarkdownFileChooser
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import com.marina.view.MainPanel
import org.junit.jupiter.api.io.TempDir
import java.io.File
import javax.swing.JFileChooser

class FileUploadListenerTest {
    private lateinit var listener: FileUploadListener
    private lateinit var fileChooser: MarkdownFileChooser
    private lateinit var mainPanel: MainPanel
    private lateinit var testFile: File

    @TempDir
    lateinit var tempDir: File

    @BeforeEach
    fun setUp() {
        mainPanel = MainPanel()

        // mock the behavior of the file chooser, so it returns a file when showOpenDialog is called
        fileChooser = mock(MarkdownFileChooser::class.java)
        `when`(fileChooser.showOpenDialog(null)).thenReturn(JFileChooser.APPROVE_OPTION)

        listener = FileUploadListener(mainPanel::onFileSelected, mainPanel::showErrorLabel)
        listener.fileChooser = fileChooser
    }

    @Test
    fun `markdown file should be displayed as plain text`() {
        testFile = File(tempDir,"test.md")
        testFile.writeText("### Markdown file\n<code>.")
        `when`(fileChooser.selectedFile).thenReturn(testFile)

        listener.actionPerformed(null)

        assertThat(mainPanel.errorLabel.text).isEqualTo("")
        assertThat(mainPanel.errorLabel.isVisible).isFalse()
        assertThat(mainPanel.fileContentPane.textArea.text).isEqualTo("### Markdown file\n<code>.")
    }

    @Test
    fun `error label should show that file is not markdown`() {
        testFile = File("test.txt")
        `when`(fileChooser.selectedFile).thenReturn(testFile)

        listener.actionPerformed(null)

        assertThat(mainPanel.errorLabel.text).isEqualTo("Invalid file type. Only .md files are allowed.")
        assertThat(mainPanel.fileContentPane.isVisible).isFalse()
    }

    @Test
    fun `error label should show that there was an error reading the file`() {
        testFile = File("nonExistentFile.md")
        `when`(fileChooser.selectedFile).thenReturn(testFile)

        listener.actionPerformed(null)

        assertThat(mainPanel.errorLabel.text).isEqualTo("There was an error while reading the file.")
        assertThat(mainPanel.fileContentPane.isVisible).isFalse()
    }

}