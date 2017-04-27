package com.basetestng.libraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;


public class ReadDataFromExcel {
	public int getExcelRowCount(String xlPath,String sheetName) {
		try
		{
			FileInputStream fis=new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			int rc=wb.getSheet(sheetName).getLastRowNum();
			return rc;
			
		}
		catch(Exception e)
		{
			return -1;
		}
	}
	
	public int returnRow(String xlPath,String Sheet) throws InvalidFormatException, IOException {
		FileInputStream fis=new FileInputStream(xlPath);
		Workbook wb = WorkbookFactory.create(fis);
		int r = wb.getSheet(Sheet).getLastRowNum();
		return r;
		
	}
	public String getExcelCellValue(String xlPath,String sheetName,int row,int cell) {
		try
		{
			FileInputStream fis=new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			String v=wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
			return v;
			
		}
		catch(Exception e)
		{
			return "";
		}
	}
	
	public void setExcelCellValue(String xlPath,String sheetName,int row,int cell,String cellValue) {
		try
		{
			FileInputStream fis=new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			try {
			wb.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(cellValue);
			} catch (Exception e) {
				wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(cellValue);
				
			}
			FileOutputStream fos = new FileOutputStream(xlPath);
			wb.write(fos);

		}
		catch(Exception e)
		{
			Assert.fail("Invalid row/column");
		}
	}
	
	
	public void setExcelCellValueColor(String xlPath,String sheetName,int row,int cell,String cellValue) throws InvalidFormatException, IOException {
		FileInputStream fis=new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			HSSFWorkbook workbook = new HSSFWorkbook();
			CellStyle style = workbook.createCellStyle();
	       	        
	        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			
			try {
				wb.getSheet(sheetName).getRow(row).createCell(cell).setCellStyle(style);
			} catch (Exception e) {
				wb.getSheet(sheetName).getRow(row).createCell(cell).setCellStyle(style);
				//wb.getSheet(sheetName).getRow(row).setCellStyle(style);
			}
			FileOutputStream fos = new FileOutputStream(xlPath);
			wb.write(fos);
	}

	
	public void setExcelCellValue_Status(String xlPath,String sheetName,int row,int cell,String cellValue) throws InvalidFormatException, IOException {
		FileInputStream fis=new FileInputStream(xlPath);
		Workbook wb = WorkbookFactory.create(fis);
		
		/*Sheet sheet = wb.getSheet(sheetName);
		Row sheetrow = sheet.getRow(row);
		if(sheetrow == null){
		    sheetrow = sheet.createRow(row);
		}
		//Update the value of cell
		Cell Rcell = sheetrow.getCell(cell);
		if(Rcell.equals(null)){
			Rcell = sheetrow.createCell(cell);
		}
		Rcell.setCellValue(cellValue);
		FileOutputStream fos = new FileOutputStream(xlPath);
		wb.write(fos);
		*/
		try{
			wb.getSheet(sheetName).createRow(row).createCell(cell).setCellValue(cellValue);
		} catch(Exception e) {
			//wb.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(cellValue);
			wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(cellValue);
		}
		
		FileOutputStream fos = new FileOutputStream(xlPath);
		wb.write(fos);
	}
}
