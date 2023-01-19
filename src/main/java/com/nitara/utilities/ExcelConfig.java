package com.nitara.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelConfig {
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	XSSFRow row;
	XSSFCell cell;

	public ExcelConfig(String path) {
		try {
			File src = new File(path);
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String readData(String sheetName, int row, int col) {
		sheet1 = wb.getSheet(sheetName);
		String data = sheet1.getRow(row).getCell(col).getStringCellValue();

		return data;
	}
 
	public int getRowCount(String sheetName) {
		sheet1 = wb.getSheet(sheetName);

		return sheet1.getLastRowNum() + 1;
	}

	public int getColCount(String sheetName) {
		sheet1 = wb.getSheet(sheetName);

		XSSFRow row = sheet1.getRow(0);
		return row.getLastCellNum() + 1;
	}

	public String readData(String sheetName, String colName, int rowNum) {
		try {
			int colNum = -1;
			sheet1 = wb.getSheet(sheetName);
			row = sheet1.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().equals(colName)) {
					colNum = i;
				}
			}

			DataFormatter formatter = new DataFormatter();
			String val = formatter.formatCellValue(sheet1.getRow(rowNum).getCell(colNum));

			/*
			 * row= sheet1.getRow(rowNum); cell= row.getCell(colNum);
			 * 
			 * return cell.getStringCellValue();
			 */
			return val;

		} catch (Exception e) {
			System.out.println("Error is:" + e.getMessage());
			e.printStackTrace();
			return "Some issue";

		}

	}

	public int getRowCountBasedOnColumn(String sheetName, String colName) throws IOException {
		int colNum = -1;
		sheet1 = wb.getSheet(sheetName);
		row = sheet1.getRow(0);
		int n = row.getLastCellNum();
		for (int i = 0; i < n; i++) {
			Cell cell = row.getCell(i);
			if (cell != null && row.getCell(i).getStringCellValue().equals(colName)) {
				colNum = i;
			}
		}
		DataFormatter df = new DataFormatter();
		Iterator rowIter = sheet1.rowIterator();
		rowIter.next();
		int count = 0;
		while (rowIter.hasNext()) {
			String data = df.formatCellValue(((Row) rowIter.next()).getCell(colNum));
			if (data == null || data == "")
				break;
			count++;
		}
		return count;

	}

}
