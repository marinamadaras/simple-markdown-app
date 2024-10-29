package com.marina.view

import javax.swing.JLabel

class ErrorLabel: JLabel() {
    init {
        foreground = UIConstants.ERROR_TEXT
        isVisible = false
        alignmentX = CENTER_ALIGNMENT
        font = UIConstants.MONO_FONT
    }

    /**
     * Shows an error message in the label.
     */
    fun showError(message: String) {
        text = message
        isVisible = true
    }

    /**
     * Hides the error message.
     */
    fun hideError() {
        text = ""
        isVisible = false
    }
}