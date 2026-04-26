package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class ReadXLSData {

        @DataProvider(name = "testData")
        public String[][] getData(Method method) throws IOException {
            String excelSheetName = method.getName(); // Get the name of the test method
            InputStream is = getClass()
                    .getClassLoader()
                    .getResourceAsStream("TestData/TestData.xlsx");

            if (is == null) {
                throw new RuntimeException("Excel file NOT FOUND in resources!");
            }
            Workbook workbook = WorkbookFactory.create(is); // Create a Workbook from the input stream
            Sheet sheetName = workbook.getSheet(excelSheetName); // Get the sheet by name


            int totalRows = sheetName.getLastRowNum(); // Get the index of the last row (0-based)
            Row rowCells = sheetName.getRow(0); // Get the first row (header) to determine the number of columns
            int totalCols = rowCells.getLastCellNum(); // Get the number of columns from the header row

            DataFormatter formatter = new DataFormatter(); // Create a DataFormatter to convert cell values to String
            String testData[][] = new String[totalRows][totalCols];

            for (int i = 1; i <= totalRows; i++) {
                for (int j = 0; j < totalCols; j++) {
                    testData[i-1][j] = formatter.formatCellValue(sheetName.getRow(i).getCell(j)); // Read cell value, format to String, and store in array

                }
            }
            return testData;
        }
}
