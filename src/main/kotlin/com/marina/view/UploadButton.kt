package com.marina.view

import javax.swing.JButton

class UploadButton:JButton("Upload Markdown File"){
    init{
        preferredSize = UIConstants.BUTTON_SIZE
        maximumSize = UIConstants.BUTTON_SIZE
        alignmentX = CENTER_ALIGNMENT
        foreground = UIConstants.DARK_BLUE
        font =  UIConstants.MONO_FONT
    }
}