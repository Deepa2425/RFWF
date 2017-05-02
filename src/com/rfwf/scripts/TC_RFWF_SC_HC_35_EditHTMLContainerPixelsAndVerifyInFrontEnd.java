package com.rfwf.scripts;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.model.LayoutReport;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.ExperienceEditor;
import com.pageobjectmodel.pages.ForgotPassword;
import com.pageobjectmodel.pages.FrontEnd;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.pageobjectmodel.pages.Login;
import com.pageobjectmodel.pages.PageLayout;
import com.pageobjectmodel.pages.ScreenShotClass;
//incomplete test case
public class TC_RFWF_SC_HC_35_EditHTMLContainerPixelsAndVerifyInFrontEnd extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textTC_RFWF_SC_HC_35_EditHTMLContainerPixelsAndVerifyInFrontEnd() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		FrontEnd fE = new FrontEnd(driver);
		ForgotPassword fP = new ForgotPassword(driver);
		ExperienceEditor eE = new ExperienceEditor(driver);
		Login l = new Login(driver);

		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		String sheetName1 = aPOI.getSheet_2();
		boolean b = false;

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 1017, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 1018, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 1019, 2);
		
		String secure = g.getExcelCellValue(xlPath, sheetName, 1020, 2);
		String templateName =g.getExcelCellValue(xlPath, sheetName, 1021, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 1022, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 1023, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 1024, 2);
		String publish = g.getExcelCellValue(xlPath, sheetName, 1025	, 2);

		try {
			hP.clickOnContentEditor();
			cE.clickOnTenant(tenantName);

			cE.rtClickOnAndInsert(subElement);
			iFT.switchFrame();
			iFT.expandFolder(folderNameToSelect);
			iFT.selectSubFolder(subFolder);
			iFT.createTemplate(folderNameToCreate);
			iFT.clickInsert();
			Thread.sleep(5000);
			iFT.switchOutOfFrame();

			cE.rtClickOnAndInsert(folderNameToCreate);
			iFT.switchFrame();
			iFT.expandRfwPresencePagesSelectSecure();
			iFT.selectSubFolder(secure);
			iFT.createTemplate(templateName);
			iFT.clickInsert();
		
			iFT.switchOutOfFrame();
			cE.clickPublishAndExperienceEditor();
			Thread.sleep(40000);
			cE.switchWindow();

			pL.clickPageLayout();
			iFT.switchFrame();

			iFT.selectSubFolder(pageLayout);
			pL.selectPageLayout(5);
			pL.clickSelect();
			iFT.switchOutOfFrame();

			pL.clickPageLayout();
			iFT.switchFrame();
			iFT.selectSubFolder("Container");
			iFT.selectSubFolder("HtmlContainer");
			pL.clickSelect();
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();

			Thread.sleep(5000);

			cE.switchFrame();
			driver.findElement(By.xpath("//td[@class='scEditorFieldMarkerInputCell'][div[text()='Data Source']]/div/a[contains(text(),'Browse')]")).click();
			cE.switchOutOfFrame();
			cE.switchFrame3();			
			cE.clickOnTenant_01(tenantName);
			cE.clickOnTenant_01(subElement);
			cE.clickOnTenant_01(folderNameToCreate);
			cE.selectSubFolder(templateName);
			
			cE.clickOnTenant_01("Media Library");
			cE.clickOnTenant_01("rfwfpresence");
			cE.clickOnTenant_01("HTML Container");
			cE.selectSubFolder("Form");
			cE.clickOK();
			cE.switchOutOfFrame();
			cE.switchFrame();
			driver.findElement(By.xpath("(//input[@class='scContentControl'])[3]")).sendKeys("8px");
			cE.clickOK_01();
			cE.switchOutOfFrame();
			
			iFT.switchFrame1();
			pL.clickOnSave();
			iFT.switchOutOfFrame();
			
			driver.close();
			Thread.sleep(5000);
			cE.switchBackTpParentWindow();
			
			iFT.selectSubFolder(publish);
			cE.publishItem();
			iFT.switchFrame();
			cE.clickPublishButton();
			iFT.switchOutOfFrame();
			iFT.switchFrame2();
			cE.clickOK();
			iFT.switchOutOfFrame();
			iFT.switchFrame();
			cE.clickClose();
			iFT.switchOutOfFrame();
			cE.logout();
			cE.clearBrowserCache();
			//driver.get("http://vm-dev-e501617.cloudapp.net/Container_01/html_container_03");
		driver.get("http://vm-dev-e501617.cloudapp.net/container/html_container_01");
			
			
									
			//Home Page 
			LayoutReport layoutReport = Galen.checkLayout(driver,
					"C:\\RFWF_FRAMEWORK\\RFWF\\src\\com.pageobjectmodel.pages\\HtmlContainer.spec",
					Arrays.asList("", null, null, null));
			List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();
			GalenTestInfo test = GalenTestInfo.fromString("HtmlContainer Report");
			test.getReport().layout(layoutReport, "Html Container - Check layout");
			tests.add(test);
			ScreenShotClass.captureScreenShot(driver, "HtmlContainerFrontEnd" + date1);
					
			//need to check from above line
			b = true;
						
			g.setExcelCellValue(xlPath, sheetName, 1017, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 1017, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 1017, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 1017, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 1017, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 1017, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 1017, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
