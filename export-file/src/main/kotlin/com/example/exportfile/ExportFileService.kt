package com.example.exportfile

import jakarta.servlet.http.HttpServletResponse
import org.apache.poi.hssf.usermodel.HSSFDataFormat
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service
import java.lang.Exception
import java.net.URLEncoder

@Service
class ExportFileService(
    private val userRepository: UserRepository,
) {
    fun export(response: HttpServletResponse) {
        try {
            val workBook = XSSFWorkbook()
            val sheet = workBook.createSheet("유저 정보 목록")

            val numberCellStyle = workBook.createCellStyle()
            numberCellStyle.dataFormat = HSSFDataFormat.getBuiltinFormat("#,##0")

            // 헤더
            val row = sheet.createRow(0)
            val headers = listOf("아이디", "이름", "성별", "나이").mapIndexed { index, value ->
                row.createCell(index).apply {
                    setCellValue(value)
                }
            }

            // 바디
            val users = userRepository.findAll().mapIndexed { index, user ->
                val row = sheet.createRow(index + 1)

                var cell: Cell? = null
                cell = row.createCell(0)
                cell.setCellValue(user.id.toString())

                cell = row.createCell(1)
                cell.setCellValue(user.name)

                cell = row.createCell(2)
                cell.setCellValue(user.gender)

                cell = row.createCell(3)
                cell.setCellValue(user.age.toString())
            }

            response.contentType = "application/vnd.ms-excel"
            response.setHeader("Content-Disposition", "attachment;filename=${URLEncoder.encode(FILE_NAME, "UTF-8")}.xlsx")

            workBook.write(response.outputStream)
            workBook.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        private const val FILE_NAME = "유저 정보 목록"
    }
}