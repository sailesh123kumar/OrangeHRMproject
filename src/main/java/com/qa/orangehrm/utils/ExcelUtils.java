package com.qa.orangehrm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	
	public final static String PATH = System.getProperty("user.dir")+  "\\src\\test\\resources\\testData\\OrangeHRMTestData.xlsx";
	public final static String SHEET_NAME = "search";
	
	public static void main(String[] args) {
		getTestData(PATH, SHEET_NAME);
	}
	
	
	public static void getTestData(String path, String sheetName) {
		
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName.trim());
			
			int rowCount = sheet.getLastRowNum();
			
			int colCount = sheet.getRow(0).getLastCellNum();
			
			System.out.println("Total rows ==>"+rowCount);
			System.out.println("Total column ==>"+colCount);
			
			Object[][] obj = new Object[rowCount][colCount];
			
			
			 // Populating and printing data
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    obj[i][j] = sheet.getRow(i + 1).getCell(j).toString();
                    System.out.print(obj[i][j] + "\t"); // Print each cell data
                }
                System.out.println(); // New line after each row
            }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
