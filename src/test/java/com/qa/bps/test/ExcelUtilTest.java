package com.qa.bps.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.bps.utils.Constants;
import com.qa.bps.utils.ExcelUtil;

public class ExcelUtilTest {

	 ExcelUtil eu=new ExcelUtil();
	@Test(groups = { "SmokeTest","Workflow" }, priority = 1)
  public void readExcelDataTest() throws IOException {
	  //System.out.println(eu.readExcelData(1,Constants.inventoryFilepath));
	  System.out.println(eu.readExcelData(1, Constants.campaignFilepath, "str"));
  }
}
