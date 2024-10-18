package com.automation.framework.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private Workbook workbook;

    public ExcelUtils(String excelFilePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
        workbook = new XSSFWorkbook(fileInputStream);
    }

    public String getCellData(String sheetName, int rowNum, int colNum) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        return cell.getStringCellValue();
    }

    public int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        return sheet.getPhysicalNumberOfRows();
    }

    public void close() throws IOException {
        workbook.close();
    }
}
