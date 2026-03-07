package Utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {
    public static Object[][] getExcelData(String path, String sheetName) throws Exception {

        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {

            for (int j = 0; j < colCount; j++) {

                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }

        workbook.close();
        fis.close();

        return data;
    }
}
