package com.test.map.examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCompare {
private static final String file1="/Users/jonysingla/Documents/trial.xlsx";
private static final String file2="/Users/jonysingla/Documents/trial1.xlsx";
//static Map<String,String> outerOuterMap1=null;
static String s1,s2,s;
static String a1,a2,a3;

public void sheetIterator(Sheet sheet){
	Map<String,Map<String,Map<String,String>>> sheetMap1=new HashMap<String,Map<String,Map<String,String>>>();
	Map<String,Map<String,String>> innerMap1=new HashMap<String,Map<String,String>>();
	Map<String,String> innerInnerMap1=new HashMap<>();
	
	
	
	Iterator<Row> rowIterator=sheet.iterator();
	while(rowIterator.hasNext()){
		
		Row currentRow=rowIterator.next();
		Iterator<Cell> cellIterator=currentRow.iterator();
		while(cellIterator.hasNext()){
			Cell currentCell=cellIterator.next();
		//System.out.println(currentCell.Ce);

			if(currentCell.getColumnIndex()==0){
			//innerInnerMap1.put("EntityName",currentCell.getStringCellValue());
				a1=currentCell.getStringCellValue();
			}
			else if(currentCell.getColumnIndex()==2){
				//innerInnerMap1.put("Status",currentCell.getStringCellValue());
				a2=currentCell.getStringCellValue();
			}
			else if(currentCell.getColumnIndex()==3){
				//innerInnerMap1.put("Flag",currentCell.getStringCellValue());
				a3=currentCell.getStringCellValue();
			}
			else if(currentCell.getColumnIndex()==1){
				//innerInnerMap1.put("Status",currentCell.getStringCellValue());
				s1=currentCell.getStringCellValue();
				
			}
			else if(currentCell.getColumnIndex()==4){
				//innerInnerMap1.put("Status",currentCell.getStringCellValue());
				 s2=currentCell.getStringCellValue();
				 
			}
			s=s1+"-"+s2;
			//System.out.println("Old s:"+s);
			s.replaceAll("CTRQa", "CTRDev");
			//s.replace("CTRDev","CTRQa");
			s=s1+"-"+s2;
			//System.out.println("New s:"+s);
			//System.out.println("ININMAP1:"+innerInnerMap1);
			
		}
		innerInnerMap1.put("EntityName", a1);
		innerInnerMap1.put("Status", a2);
		innerInnerMap1.put("Flag", a3);
		//System.out.println("ININMAP1:"+innerMap1.put(s, innerInnerMap1));
		innerMap1.put(s, innerInnerMap1);
		innerInnerMap1=new HashMap<>();
		
		
	}
	//outerOuterMap1.putAll(innerInnerMap1);
	//System.out.println("O:"+outerOuterMap1);
	//innerMap1.put(s, innerInnerMap1);
	//Map<String,String> outerMap1.p
	System.out.println("INMAP1:"+innerMap1);
	sheetMap1.put("EntityDetail",innerMap1);
	System.out.println("SheetMAp1:"+sheetMap1);
	

}
	public static void main(String[] args) {
		  try {
			FileInputStream inputFile1=new FileInputStream(file1);
			FileInputStream inputFile2=new FileInputStream(file2);
			Workbook workbook1=new XSSFWorkbook(inputFile1);
			Workbook workbook2= new XSSFWorkbook(inputFile2);
		Sheet sheet1=null;
		Sheet sheet2=null;
			for(int i=0;i<workbook1.getNumberOfSheets();i++){
				 sheet1=workbook1.getSheetAt(i);
				 sheet2=workbook2.getSheetAt(i);
			}
			ExcelCompare comp=new ExcelCompare();
			comp.sheetIterator(sheet1);
			comp.sheetIterator(sheet2);
			//Sheet sheet1=workbook1.getSheetAt(0);
			//Sheet sheet2=workbook2.getSheetAt(0);
			
			//			Map<String,Map<String,Map<String,String>>> sheetMap2=new HashMap<String,Map<String,Map<String,String>>>();
//			Map<String,Map<String,String>> innerMap2=new HashMap<String,Map<String,String>>();
//			Map<String,String> innerInnerMap2=new HashMap<>();
//			
//			
//			
//			Iterator<Row> rowIterator2=sheet2.iterator();
//			while(rowIterator2.hasNext()){
//				Row currentRow2=rowIterator2.next();
//				Iterator<Cell> cellIterator2=currentRow2.iterator();
//				while(cellIterator2.hasNext()){
//					Cell currentCell2=cellIterator2.next();
//					
//					
//					if(currentCell2.getColumnIndex()==0){
//					innerInnerMap2.put("EntityName",currentCell2.getStringCellValue());
//					}
//					else if(currentCell2.getColumnIndex()==2){
//						innerInnerMap2.put("Status",currentCell2.getStringCellValue());
//					}
//					else if(currentCell2.getColumnIndex()==3){
//						innerInnerMap2.put("Flag",currentCell2.getStringCellValue());
//					}
//					else if(currentCell2.getColumnIndex()==1){
//						//innerInnerMap1.put("Status",currentCell.getStringCellValue());
//						s1=currentCell2.getStringCellValue();
//						
//					}
//					else if(currentCell2.getColumnIndex()==4){
//						//innerInnerMap1.put("Status",currentCell.getStringCellValue());
//						 s2=currentCell2.getStringCellValue();
//						 
//					}
//					s=s1+"-"+s2;
//				}
//				innerMap2.put(s, innerInnerMap2);
//				//System.out.println("InnerInnerMap:"+innerInnerMap2);
//				//System.out.println("InnerMap:"+innerMap2);
//			}
//			sheetMap2.put("EntityDetail",innerMap2);
//			System.out.println("SheetMap2:"+sheetMap2);
//			
//			
//			Map<String,Map<String,String>> resultSheetValue1=sheetMap1.get("EntityDetail");
//			Map<String,Map<String,String>> resultSheetValue2=sheetMap2.get("EntityDetail");
//			
//			for(String comp:resultSheetValue1.keySet()){
//				if(!resultSheetValue1.get(comp).equals((resultSheetValue2).get(comp))){
//					System.out.println("sheet1="+resultSheetValue1.get(comp));
//					System.out.println("sheet2="+resultSheetValue2.get(comp));
//					System.out.println("Files not the same");
//				}
//					
//			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}

}
