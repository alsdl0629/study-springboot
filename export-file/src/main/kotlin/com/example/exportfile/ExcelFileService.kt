package com.example.exportfile

import org.apache.poi.hssf.usermodel.HSSFDataFormat
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service
import java.io.ByteArrayOutputStream
import java.io.File

@Service
class ExcelFileService(
    private val userRepository: UserRepository,
) : FileService {
    override fun export(): ByteArray {

        val workBook = XSSFWorkbook()
        val sheet = workBook.createSheet("유저 정보 목록")

        val numberCellStyle = workBook.createCellStyle()
        numberCellStyle.dataFormat = HSSFDataFormat.getBuiltinFormat("#,##0")

        // 헤더
        val headerInfo = listOf("아이디", "이름", "성별", "나이")
        headerInfo.forEachIndexed { index, value ->
            val row = sheet.createRow(0)
            createCell(row = row, position = index, value = value)
        }

        // 바디
        userRepository.findAll().forEachIndexed { index, user ->
            val row = sheet.createRow(index + 1) // 0은 헤더, 1부터 데이터들이 출력

            val userInfo: List<String> = listOf(user.id.toString(), user.name, user.gender, user.age.toString())

            userInfo.forEachIndexed { index, value ->
                createCell(row, index, value)
            }
        }

        ByteArrayOutputStream().use {
            workBook.write(it)
            return it.toByteArray()
        }
    }

    private fun createCell(row: Row, position: Int, value: String) {
        row.createCell(position).apply { setCellValue(value) }
    }

    override fun import(file: File) {
        userRepository.deleteAllInBatch()

        val workbook: Workbook
        file.inputStream().use {
            workbook = XSSFWorkbook(it)
        }

        val sheet = workbook.getSheetAt(0)
        val users = mutableListOf<User>()

        (1..sheet.lastRowNum).forEach {
            val row = sheet.getRow(it)

            users.add(
                User(
                    name = row.getCell(1).stringCellValue,
                    gender = row.getCell(2).stringCellValue,
                    age = row.getCell(3).stringCellValue.toInt(),
                )
            )
        }
        file.delete()
        userRepository.saveAll(users)
    }
}