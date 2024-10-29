package view

import com.marina.view.FileContentPane
import com.marina.view.UIConstants
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.swing.JScrollPane

class FileContentPaneTest {
    private lateinit var fileContentPane: FileContentPane

    @BeforeEach
    fun setUp() {
        fileContentPane = FileContentPane()
    }

    @Test
    fun `should be initialized with correct properties`() {
        assertThat(fileContentPane.verticalScrollBarPolicy).isEqualTo(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED)
        assertThat(fileContentPane.horizontalScrollBarPolicy).isEqualTo(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED)
        assertThat(fileContentPane.isVisible).isFalse
        assertThat(fileContentPane.preferredSize).isEqualTo(UIConstants.FILE_CONTENT_SIZE)

        assertThat(fileContentPane.textArea.isEditable).isFalse
        assertThat(fileContentPane.textArea.background).isEqualTo(UIConstants.OFF_WHITE)
        assertThat(fileContentPane.textArea.foreground).isEqualTo(UIConstants.DARK_BLUE)
        assertThat(fileContentPane.textArea.font).isEqualTo(UIConstants.MONO_FONT)
    }

    @Test
    fun `updateText should display content when given non-null content`() {
        val content = listOf("### Markdown file","<code>.")

        fileContentPane.updateText(content)

        assertThat(fileContentPane.textArea.text).isEqualTo("### Markdown file\n<code>.")
        assertThat(fileContentPane.textArea.caretPosition).isEqualTo(0)
        assertThat(fileContentPane.isVisible).isTrue
    }

    @Test
    fun `updateText should clear content and hide pane when given null content`() {
        fileContentPane.updateText(listOf("### Markdown file","<code>."))

        fileContentPane.updateText(null)

        assertThat(fileContentPane.textArea.text).isEmpty()
        assertThat(fileContentPane.isVisible).isFalse
    }
}