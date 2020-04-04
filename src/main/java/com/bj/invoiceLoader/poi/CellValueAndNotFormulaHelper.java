package com.bj.invoiceLoader.poi;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Component
public class CellValueAndNotFormulaHelper {

    public Object getCellValueByFetchingLastCachedValue(String fileLocation, String cellLocation) throws IOException {
        Object cellValue = new Object();

        FileInputStream inputStream = new FileInputStream(new File(fileLocation));
        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        CellAddress cellAddress = new CellAddress(cellLocation);
        Row row = sheet.getRow(cellAddress.getRow());
        Cell cell = row.getCell(cellAddress.getColumn());

        if (cell.getCellType() == CellType.FORMULA) {
            switch (cell.getCachedFormulaResultType()) {
                case BOOLEAN:
                    cellValue = cell.getBooleanCellValue();
                    break;
                case NUMERIC:
                    cellValue = cell.getNumericCellValue();
                    break;
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                default:
                    cellValue = null;
            }
        }

        workbook.close();
        return cellValue;
    }

    public Object getCellValueByEvaluatingFormula(String fileLocation, String cellLocation) throws IOException {
        Object cellValue = new Object();

        FileInputStream inputStream = new FileInputStream(new File(fileLocation));
        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);
        FormulaEvaluator evaluator = workbook.getCreationHelper()
                .createFormulaEvaluator();

        CellAddress cellAddress = new CellAddress(cellLocation);
        Row row = sheet.getRow(cellAddress.getRow());
        Cell cell = row.getCell(cellAddress.getColumn());

        if (cell.getCellType() == CellType.FORMULA) {
            switch (evaluator.evaluateFormulaCell(cell)) {
                case BOOLEAN:
                    cellValue = cell.getBooleanCellValue();
                    break;
                case NUMERIC:
                    cellValue = cell.getNumericCellValue();
                    break;
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                default:
                    cellValue = null;
            }
        }

        workbook.close();
        return cellValue;
    }
}