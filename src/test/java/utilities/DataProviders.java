package utilities;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;

public class DataProviders {

    @DataProvider(name = "Data")
    public static Object[][] getAllUsers() throws Exception {

        File file = new File("data/UserData.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet1");

        int rows = sheet.getLastRowNum();
        int columns = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < columns; k++) {
                // Check the cell type and convert if necessary
                if (sheet.getRow(i + 1).getCell(k).getCellType() == CellType.NUMERIC) {
                    data[i][k] = String.valueOf((int) sheet.getRow(i + 1).getCell(k).getNumericCellValue()); // Convert numeric values to String
                } else {
                    data[i][k] = sheet.getRow(i + 1).getCell(k).toString(); // For String values
                }
            }
        }

        workbook.close();
        fis.close();

        return data;
    }
}
