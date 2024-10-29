package com.marina.exceptions

import java.io.IOException

class FileReadingException(
    message: String = "There was an error while reading the file."
) : IOException(message)