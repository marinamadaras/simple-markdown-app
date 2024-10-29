package com.marina.view

import javax.swing.JFrame


class MainFrame : JFrame("Markdown File Application") {
    private val mainPanel = MainPanel()

    init {
        contentPane.add(mainPanel)
        setupWindowProperties()
    }

    /**
     * Sets up the properties of the window which is shown to the user.
     */
    private fun setupWindowProperties() {
        size = UIConstants.WINDOW_SIZE
        defaultCloseOperation = EXIT_ON_CLOSE
        setLocationRelativeTo(null)
        isVisible = true
    }
}