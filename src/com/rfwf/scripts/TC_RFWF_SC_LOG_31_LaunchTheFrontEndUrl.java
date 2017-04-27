package com.rfwf.scripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.ExperienceEditor;
import com.pageobjectmodel.pages.FrontEnd;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.basetestng.libraries.BaseTestNGPageDLSSiteFrontEnd;
import com.basetestng.libraries.BaseTestNGPageRFWFFrontEnd;
import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.Login;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_LOG_31_LaunchTheFrontEndUrl extends BaseTestNGPageRFWFFrontEnd {
	@Test(priority = 1)
	public void text_TC_RFWF_SC_LOG_31_LaunchTheFrontEndUrl() throws InterruptedException {


		FrontEnd fE = new FrontEnd(driver);
		ReadDataFromExcel g = new ReadDataFromExcel();

		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_4();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		String sheetName1 = aPOI.getSheet_2();
		boolean b = false;
		String url = g.getExcelCellValue(xlPath, sheetName1, 28, 1);

		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 112, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 113, 2);
		String frontEndUrl = url + "/" + folderNameToCreate + "/" + templateName;

		try {
			driver.get(frontEndUrl);
			fE.verifyNoFrontEndServerError();
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 112, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 112, 4, "Executed on - " + date1);
		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 112, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 112, 4, date1);
		} finally {
			if (b == false) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 112, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 112, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 112, 5,
						screenShot+ v + "_" + date1);

			}
		}
	}

}
