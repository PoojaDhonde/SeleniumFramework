package Utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String projpath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projpath+"/excel/InputFile.xlsx", "Sheet1");
		
		excel.getRowCount();
		excel.getCellDataString(0, 0);
		excel.getCellDataNumber(1, 1);

	}

}
