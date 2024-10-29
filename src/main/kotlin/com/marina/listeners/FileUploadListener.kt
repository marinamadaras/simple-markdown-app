package com.marina.listeners

import com.marina.view.MarkdownFileChooser
import com.marina.controller.FileController
import com.marina.exceptions.FileReadingException
import com.marina.exceptions.InvalidFileTypeException
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JFileChooser

class FileUploadListener(private val onFileSelected: (List<String>) -> Unit,
                         private val showErrorLabel: (String) -> Unit)
    : ActionListener {

    var fileChooser = MarkdownFileChooser()

    /**
     * Method that is called when the file upload button is clicked.
     * It opens a file chooser dialog, which has the default file type set to markdown files,
     * and reads the content of the selected file.
     *
     * If the file is not a markdown file or there was an error while reading it,
     * it displays a suitable error message.
     *
     * @param e The button click event.
     */
    override fun actionPerformed(e: ActionEvent?) {
        val result = fileChooser.showOpenDialog(null)
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                val file = FileController.readFileContent(fileChooser.selectedFile)
                onFileSelected(file.content)
            } catch (ex: InvalidFileTypeException) {
                showErrorLabel(ex.message ?: "Invalid file type. Only .md files are allowed.")
            } catch (ex: FileReadingException) {
                showErrorLabel(ex.message ?: "There was an error while reading the file.")
            }
        }
    }
}