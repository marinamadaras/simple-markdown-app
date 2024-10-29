package com.marina.controller

import com.marina.view.MainFrame
import javax.swing.SwingUtilities

object ApplicationController {
    var mainFrame: MainFrame? = null

    /**
     * Starts the application, by creating the main frame.
     */
    fun startApplication() {
        SwingUtilities.invokeLater{
            mainFrame = MainFrame()
        }
    }
}