package com.marina.exceptions

import java.io.IOException

class InvalidFileTypeException(
    message: String = "Invalid file type. Only .md files are allowed."
) : IOException(message)
