package controller

import com.marina.controller.FileController
import com.marina.exceptions.FileReadingException
import com.marina.exceptions.InvalidFileTypeException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.io.TempDir
import java.io.File

class FileControllerTest {

    @TempDir
    lateinit var tempDir: File

    @Test
    fun `test reading a valid markdown file`() {
        val testFile = File(tempDir,"test.md")
        testFile.writeText("### Markdown file\n<code>.")

        val result = FileController.readFileContent(testFile)

        assertThat(result.content).isEqualTo(listOf("### Markdown file", "<code>."))
    }

    @Test
    fun `test file with invalid extension`() {
        val invalidFile = File("test.txt")

        assertThrows<InvalidFileTypeException>{ FileController.readFileContent(invalidFile)}
    }

    @Test
    fun `test file which throws IOException`() {
        val invalidFile = File("nonExistentFile.md")

        assertThrows<FileReadingException>{ FileController.readFileContent(invalidFile)}
    }

}