package MyPractice;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelInput {


	static XSSFWorkbook workbook = null;
	static XSSFSheet sheet;

	public ExcelInput(String excelPath, String sheetName) {

		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int getRowCount() {

		int rowCount = 0;

		try {
			rowCount = sheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return(rowCount);
	}

	public int getColCount() {

		int colCount = 0;

		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return(colCount);
	}

	public String getCellDataString(int rowNum, int colNum){

		String cell = null;

		try {
			cell = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return(cell);
	}

	public double getCellDataNumber(int rowNum, int colNum){

		double cell = (Double) null;

		try {
			cell = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cell;
	}
}





