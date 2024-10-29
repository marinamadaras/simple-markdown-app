package com.marina.view

import com.marina.listeners.FileUploadListener
import javax.swing.BorderFactory
import javax.swing.Box
import javax.swing.BoxLayout
import javax.swing.JLabel
import javax.swing.JPanel

/**
 * MainPanel holds all the actual UI elements for the application.
 */
class MainPanel: JPanel() {
    val titleLabel = JLabel("Markdown File Viewer").apply {
        font = UIConstants.TITLE_FONT
        alignmentX = CENTER_ALIGNMENT
    }
    val errorLabel = ErrorLabel()
    val uploadButton = UploadButton()
    val fileContentPane = FileContentPane()

    init{
        setupUI()
        setupUploadListener()
    }

    /**
     * Sets up the UI for the main panel, which includes:
     * the title, upload button, error label, and file content pane.
     */
    private fun setupUI() {
        layout = BoxLayout(this, BoxLayout.Y_AXIS)
        border = BorderFactory.createEmptyBorder(20, 20, 20, 20)
        background = UIConstants.APP_BACKGROUND

        add(titleLabel)
        add(Box.createRigidArea(UIConstants.LARGE_SPACING))
        add(createButtonPanel())
        add(Box.createRigidArea(UIConstants.LARGE_SPACING))
        add(fileContentPane)
    }

    /**
     * Creates a panel to hold the upload button and error label.
     */
    private fun createButtonPanel(): JPanel {
        return JPanel().apply {
            layout = BoxLayout(this, BoxLayout.Y_AXIS)
            background = UIConstants.APP_BACKGROUND

            add(uploadButton)
            add(Box.createRigidArea(UIConstants.SMALL_SPACING))
            add(errorLabel)
        }
    }

    /**
     * Attaches the listener to the upload button.
     *
     * The listener is passed two callback functions:
     * - onFileSelected: updates the text in the file content pane
     * - showErrorLabel: shows an error message in the error label (if any)
     */
    private fun setupUploadListener() {
        uploadButton.addActionListener(FileUploadListener(::onFileSelected, ::showErrorLabel))
    }

    fun onFileSelected(content: List<String>) {
        fileContentPane.updateText(content)
        errorLabel.hideError()
        revalidate()
        repaint()
    }

    fun showErrorLabel(errorMessage: String) {
        fileContentPane.updateText(null)
        errorLabel.showError(errorMessage)
    }
}