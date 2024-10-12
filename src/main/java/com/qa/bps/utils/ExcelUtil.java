package com.qa.bps.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	int requiredColumn;

	public List<Object> readExcelData(int col,String path,String fieldType) throws IOException {

		// Create an object of FileInputStream class to read excel file

		requiredColumn = col;
		String fp = path;

		File file = new File(fp);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		List<Object> columnData = new ArrayList<Object>();
		for (int i = 1; i <= rowCount; i++) {

			if(fieldType=="str")
			{
			columnData.add(sheet.getRow(i).getCell(requiredColumn).getStringCellValue());
			}
			
			else
			{
				columnData.add((int)(sheet.getRow(i).getCell(requiredColumn).getNumericCellValue()));
			}
		}
		return columnData;

	}
}
