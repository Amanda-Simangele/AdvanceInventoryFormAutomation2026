package Utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

        @DataProvider(name = "loginData")
        public Object[][] loginData() throws Exception {

            String path = "src/test/resources/TestData.xlsx";
            return ExcelUtils.getExcelData(path, "Sheet1");
        }
}
