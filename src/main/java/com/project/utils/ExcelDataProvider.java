package com.project.utils;

import java.io.File;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataProvider {
	
	
	Sheet sh;
	
	public ExcelDataProvider(String sheetName) {
		File src=new File(System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx");
		Workbook wb=null;
		try {
			wb=WorkbookFactory.create(src);
		} catch (Exception e) {
			System.out.println("unable to load Excel file"+e.getMessage());
		}
		sh=wb.getSheet(sheetName);
	}
	
	/**
	 * Method to get String Value from excel sheet
	 * @param SheetName
	 * @param row
	 * @param column
	 * @return
	 */
	public String getStringValue(int row,int column) {
		return sh.getRow(row).getCell(column).getStringCellValue();
	}
	
	
	/**
	 * Method to get Numeric Value from excel sheet
	 * @param SheetName
	 * @param row
	 * @param column
	 * @return
	 */
	public int getIntValue(int row,int column) {
		return (int) sh.getRow(row).getCell(column).getNumericCellValue();
	}
	
	@SuppressWarnings("deprecation")
	public HashMap<String, String> getValue(int rownumber) {
		HashMap<String,String> hm=new HashMap<String,String>();
		for(int i=0;i<=sh.getRow(0).getLastCellNum();i++) {
			sh.getRow(rownumber).getCell(i).setCellType(CellType.STRING);
			hm.put(sh.getRow(0).getCell(i).getStringCellValue(), sh.getRow(rownumber).getCell(i).getStringCellValue());
			
		}
		return hm; 
	}

}
