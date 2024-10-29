package view

import com.marina.view.ErrorLabel
import com.marina.view.UIConstants
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.swing.JLabel

class ErrorLabelTest {
    private lateinit var errorLabel: ErrorLabel

    @BeforeEach
    fun setUp() {
        errorLabel = ErrorLabel()
    }

    @Test
    fun `should be initialized with correct properties`() {
        assertThat(errorLabel.foreground).isEqualTo(UIConstants.ERROR_TEXT)
        assertThat(errorLabel.isVisible).isFalse
        assertThat(errorLabel.alignmentX).isEqualTo(JLabel.CENTER_ALIGNMENT)
        assertThat(errorLabel.font).isEqualTo(UIConstants.MONO_FONT)
        assertThat(errorLabel.text).isEmpty()
    }

    @Test
    fun `showError should set text and make label visible`() {
        val errorMessage = "error"

        errorLabel.showError(errorMessage)

        assertThat(errorLabel.text).isEqualTo(errorMessage)
        assertThat(errorLabel.isVisible).isTrue
    }

    @Test
    fun `hideError should clear text and make label invisible`() {
        errorLabel.showError("error")

        errorLabel.hideError()

        assertThat(errorLabel.text).isEmpty()
        assertThat(errorLabel.isVisible).isFalse
    }
}