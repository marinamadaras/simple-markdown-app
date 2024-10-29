package com.marina.view

import java.awt.Color
import java.awt.Dimension
import java.awt.Font

/**
 * Utility class for storing UI constants,
 * such as dimensions, fonts, and colors.
 */
object UIConstants {
    // Dimensions
    val WINDOW_SIZE = Dimension(900, 900)
    val BUTTON_SIZE = Dimension(200, 40)
    val FILE_CONTENT_SIZE = Dimension(750, 400)

    val SMALL_SPACING = Dimension(0, 5)
    val LARGE_SPACING = Dimension(0, 20)

    // Fonts
    val TITLE_FONT = Font(Font.MONOSPACED, Font.BOLD, 26)
    val MONO_FONT = Font(Font.MONOSPACED, Font.PLAIN, 13)

    // Colors
    val APP_BACKGROUND = Color(240, 237, 237)
    val DARK_BLUE = Color(17, 18, 38)
    val OFF_WHITE = Color(248, 248, 248)
    val ERROR_TEXT = Color(135, 12, 12)
    val DARK_GRAY = Color(26, 24, 24)

}