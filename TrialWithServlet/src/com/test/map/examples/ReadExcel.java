package com.test.map.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	private static final String fileName="/Users/jonysingla/Documents/trial.xlsx";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	FileInputStream excelFile=new FileInputStream(new File(fileName));
	Workbook workbook= new XSSFWorkbook(excelFile);
	Sheet dataSheet=workbook.getSheetAt(0);
	
	Iterator<Row> rowIterator=dataSheet.iterator();
	while(rowIterator.hasNext()){
		Row currentRow=rowIterator.next();
		Iterator<Cell> cellIterator=currentRow.iterator();
		while(cellIterator.hasNext()){
			Cell currentCell=cellIterator.next();
			if(currentCell.getCellTypeEnum()==CellType.STRING){
				System.out.println(currentCell.getStringCellValue());
				//System.out.println("/n");
			}else if(currentCell.getCellTypeEnum()==CellType.NUMERIC){
				System.out.println(currentCell.getNumericCellValue());
			}
		}
	}
	
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
