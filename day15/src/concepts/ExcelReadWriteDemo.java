package concepts;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

public class ExcelReadWriteDemo {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Cricketers Data");
		
		Map<String,Object[]> sheetData = new LinkedHashMap<>();
		sheetData.put("1",new Object[] {1,"Virat Kohli","Batsmen"});
		sheetData.put("2", new Object[] {2,"Bhuvaneshwar","Bowler"});
		sheetData.put("3", new Object[] {3,"ABD","Batsmen"});
		sheetData.put("4",new Object[] {1,"KL Rahul","Batsmen"});
		
		Set<String> sheetKeys = sheetData.keySet();
		
		int row = 0;
		
		for(String key:sheetKeys) {
			Object[] currRowCellValues = sheetData.get(key);
			Row currRow = sheet.createRow(row++);
			
			int cell=0;
			for(Object obj:currRowCellValues) {
				Cell currCell = currRow.createCell(cell++);
				if(obj instanceof String) {
					currCell.setCellValue((String)obj);
				}
				if(obj instanceof Integer) {
					currCell.setCellValue((int)obj);
				}
				
			}
			
		}
		
		String excelSheetPath = Path.of(System.getProperty("user.dir"),"src","concepts","Cricketers.xlsx").toString();
		try
		(
			FileOutputStream excelFileOutputStream = new FileOutputStream(excelSheetPath);
				){
			
			workbook.write(excelFileOutputStream);
			System.out.println("Written data to workbook");
		}
	
		
	}
}
