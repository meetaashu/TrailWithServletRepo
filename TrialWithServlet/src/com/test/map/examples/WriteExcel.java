package com.test.map.examples;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
XSSFWorkbook workbook=new XSSFWorkbook();
XSSFSheet sheet=workbook.createSheet("Student Record");
Map<String,String> map=new HashMap<String, String>();
map.put("1", "10");
map.put("2", "20");
map.put("3", "30");

int rownum=0;
Set<String> keyset=map.keySet();
for(String key:keyset){
	Row row=sheet.createRow(rownum++);
	String valueOfRow=map.get(key);
	
	int cellnum=0;
	Cell cell=row.createCell(cellnum++);
	cell.setCellValue(valueOfRow);
}
		
	
	try{
	FileOutputStream out=new FileOutputStream(new File("/Users/jonysingla/Documents/trial.xlsx"));
	workbook.write(out);
	System.out.println("Done");
	out.close();
	}catch(Exception e){
		System.out.println(e);
	}
}
}