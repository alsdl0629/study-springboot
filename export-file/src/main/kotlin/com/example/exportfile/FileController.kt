package com.example.exportfile

import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.net.URLEncoder

@RequestMapping("/files")
@RestController
class FileController(
    private val fileService: ExcelFileService,
) {
    @GetMapping
    fun exportUserInformation(response: HttpServletResponse): ByteArray {
        val file = fileService.export()
        val fileName = "${URLEncoder.encode("유저 정보 목록", "UTF-8")}.xlsx"
        response.contentType = "application/vnd.ms-excel"
        response.setHeader("Content-Disposition", "attachment; filename=$fileName")
        return file
    }

    @PostMapping
    fun importUserInformation(@RequestPart multipartFile: MultipartFile) {
        val file = File(multipartFile.originalFilename.toString()).let {
            val fileOutputStream = FileOutputStream(it)
            fileOutputStream.write(multipartFile.bytes)
            fileOutputStream.close()
            it
        }
        fileService.import(file)
    }
}