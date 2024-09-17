import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private static Workbook workbook;
    private static Sheet sheet;

    // Initialize Excel file and sheet
    public static void setExcelFile(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheetName);
    }

    // Get the row count
    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    // Get the column count
    public static int getColumnCount(int rowNum) {
        return sheet.getRow(rowNum).getPhysicalNumberOfCells();
    }

    // Get cell data
    public static String getCellData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);

        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return "";
        }
    }

    // Close Excel after use
    public static void closeExcel() throws IOException {
        workbook.close();
    }
}
