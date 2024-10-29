package com.marina.controller

import com.marina.exceptions.FileReadingException
import com.marina.exceptions.InvalidFileTypeException
import com.marina.model.MarkdownFile
import java.io.File
import java.io.IOException
import java.nio.file.Files

object FileController {

    /**
     * Reads the content of a file.
     * If the file is a Markdown file, it reads it line by line
     * and saves it.
     *
     * @param file The file to read.
     * @return The content of the file as a MarkdownFile object.
     *
     * @throws InvalidFileTypeException If the file is not a Markdown file.
     * @throws FileReadingException If there was an error while reading the file.
     */
    fun readFileContent(file: File): MarkdownFile {
        if (!file.extension.equals("md", ignoreCase = true)) {
            throw InvalidFileTypeException()
        }
        return try {
            val fileContent = Files.readAllLines(file.toPath())
            MarkdownFile(fileContent)
        } catch (e: IOException) {
            throw FileReadingException()
        }
    }
}