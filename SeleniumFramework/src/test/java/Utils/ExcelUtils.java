package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workbook = null;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {


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
				System.out.println("No. of rows:"+rowCount);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return(rowCount);
		}
		
		public int getColCount() {
			
			int colCount = 0;

			try {
				colCount = sheet.getRow(0).getPhysicalNumberOfCells();
				System.out.println("No. of Columns:"+colCount);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return(colCount);
		}

		public String getCellDataString(int rowNum, int colNum){
			
			String cell = null;

			try {
				cell = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
				//System.out.println("Cell Data:"+cell);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return(cell);
		}

		public double getCellDataNumber(int rowNum, int colNum){
			
			double cell = (Double) null;

			try {
				cell = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
				//System.out.println("Cell Data:"+cell);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cell;
		}
	}


