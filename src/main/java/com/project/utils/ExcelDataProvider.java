package com.project.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		File src=new File(System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx");
		FileInputStream fin;
		try {
			fin = new FileInputStream(src);
			wb=new XSSFWorkbook(fin);
		} catch (Exception e) {
			System.out.println("unable to load Excel file"+e.getMessage());
		}
	}
	
	/**
	 * Method to get String Value from excel sheet
	 * @param SheetName
	 * @param row
	 * @param column
	 * @return
	 */
	public String getStringValue(String SheetName,int row,int column) {
		return wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	
	/**
	 * Method to get Numeric Value from excel sheet
	 * @param SheetName
	 * @param row
	 * @param column
	 * @return
	 */
	public int getIntValue(String SheetName,int row,int column) {
		return (int) wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	
	

}
