package com.marina.view

import javax.swing.BorderFactory
import javax.swing.JScrollPane
import javax.swing.JTextArea

class FileContentPane: JScrollPane() {
    val textArea = JTextArea(20, 50)

    init{
        setupUI()
    }

    /**
     * Sets up the file content pane, as a scrollable text area.
     */
    private fun setupUI(){
        verticalScrollBarPolicy = VERTICAL_SCROLLBAR_AS_NEEDED
        horizontalScrollBarPolicy = HORIZONTAL_SCROLLBAR_AS_NEEDED

        isVisible = false
        preferredSize = UIConstants.FILE_CONTENT_SIZE
        border = BorderFactory.createLineBorder(UIConstants.DARK_GRAY, 2)

        setupTextArea()
        setViewportView(textArea)
    }

    /**
     * Sets up the text area with its font and colors.
     */
    private fun setupTextArea() {
        textArea.isEditable = false
        textArea.background = UIConstants.OFF_WHITE
        textArea.foreground = UIConstants.DARK_BLUE
        textArea.font = UIConstants.MONO_FONT
    }

    /**
     * Updates the text area with the given content.
     *
     * If the content is null, the text area is hidden.
     */
    fun updateText(content: List<String>?) {
        if (content != null) {
            textArea.text = content.joinToString("\n")
            textArea.caretPosition = 0
            isVisible = true
        } else {
            textArea.text = ""
            isVisible = false
        }
    }
}