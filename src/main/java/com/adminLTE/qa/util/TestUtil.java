package com.adminLTE.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.adminLTE.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long Pageload_timeunit=10;
	public static long implcitwaittimeunit =5;
	public static String getexcelfileforTestdata ="F:\\Selenium practice\\AdminLTE1\\src\\main\\java\\com\\adminLTE\\qa\\testdata\\AEXL.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	
	public static void popuphandleaccept() {
				
		driver.switchTo().alert().accept();
	}
	
	public static void alerthandledismiss() {
		driver.switchTo().alert().dismiss();
	}
	
	
	public static String gettitle() {
		return driver.getTitle();
	}
	
	public static Object[][] getTestdatafromexcel(String sheetname){
		FileInputStream file=null;
		try {
			
			file = new FileInputStream(getexcelfileforTestdata);
		}
		catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		
		try{
			
			book = WorkbookFactory.create(file);
			
		}  	 catch( InvalidFormatException ex)
		{
			 ex.printStackTrace();
		System.out.println("InvalidFormatException exception occure");
	}
			 catch( IOException ex)
		{
				 ex.printStackTrace();
			System.out.println("IO exception occure");
		}
		sheet = book.getSheet(sheetname);
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i = 0 ;i<sheet.getLastRowNum();i++) {
			for(int j= 0;j<sheet.getRow(i).getLastCellNum();j++)
			{
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				System.out.println(data);
			
			}
		}
				
		return data;
		
		
	}
}
