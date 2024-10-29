package com.marina.view

import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter

open class MarkdownFileChooser : JFileChooser(){
    init {
        fileSelectionMode = FILES_ONLY
        fileFilter = FileNameExtensionFilter("Markdown Files", "md")
    }
}