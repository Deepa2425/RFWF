package com.pageobjectmodel.pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.basetestng.libraries.BaseTestNGPageHoneyWellEIDLoginToManageProfile;
import com.basetestng.libraries.ReadDataFromExcel;

public class Temp_TestNGListeners_HoneyWellEIDLoginToManageProfile extends TestListenerAdapter {

	ReadDataFromExcel g = new ReadDataFromExcel();
	ApachePOIMethods aPOI = new ApachePOIMethods();
	String xlPath = aPOI.getConfigFilePath();
	String sheetName = aPOI.getSheet_2();
	String date1 = aPOI.getDate_1();
	String date2 = aPOI.getDate_2();
	String serverFile = aPOI.getServerFiles();
	
	public void onTestFailure(ITestResult result) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date date = new Date();
		String startTime = dateFormat.format(date);

		BaseTestNGPageHoneyWellEIDLoginToManageProfile s = (BaseTestNGPageHoneyWellEIDLoginToManageProfile) result.getInstance();
		Class<? extends BaseTestNGPageHoneyWellEIDLoginToManageProfile> v = s.getClass();
		
		String className = v.toString().substring(14);
		System.out.println("Class Name - "+v);
		File src = s.driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./screenshots/" + className +"_"+startTime+ ".png"));
			//g.setExcelCellValue(xlPath, sheetName, 34, 5, "C:->Users->19403->Workspace_Dec2016->RFWF->screenshots->"+className+"_"+date1);
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
