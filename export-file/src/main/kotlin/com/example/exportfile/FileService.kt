package com.example.exportfile

import java.io.File

interface FileService {
    fun export(): ByteArray

    fun import(file: File)
}