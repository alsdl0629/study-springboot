package com.example.exportfile

import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FileController(
    private val exportFileService: ExportFileService
) {
    @GetMapping("files")
    fun exportUserInformation(response: HttpServletResponse) {
        exportFileService.export(response)
    }
}