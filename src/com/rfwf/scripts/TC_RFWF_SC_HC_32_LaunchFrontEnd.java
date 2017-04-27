package com.rfwf.scripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.ExperienceEditor;
import com.pageobjectmodel.pages.ForgotPassword;
import com.pageobjectmodel.pages.FrontEnd;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;
import com.pageobjectmodel.pages.PageLayout;

public class TC_RFWF_SC_HC_32_LaunchFrontEnd extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textTC_RFWF_SC_HC_7_ConfigureComponent() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);
		PageLayout pL = new PageLayout(driver);
		FrontEnd fE = new FrontEnd(driver);
		ForgotPassword fP = new ForgotPassword(driver);
		ExperienceEditor eE = new ExperienceEditor(driver);

		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_4();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		String sheetName1 = aPOI.getSheet_2();
		boolean b = false;

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 3030, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 3031, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 3032, 2);
		
		String secure = g.getExcelCellValue(xlPath, sheetName, 3033, 2);
		String templateName =g.getExcelCellValue(xlPath, sheetName, 3034, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 3035, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 3036, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 3037, 2);
		String templateName1=g.getExcelCellValue(xlPath, sheetName, 3038, 2);
		String frontEndUrlStrt = g.getExcelCellValue(xlPath, sheetName, 3039, 2);
		String htmlContainerFrontEndUrl = frontEndUrlStrt + "\\" + folderNameToCreate + "\\" + templateName;
		String thankyouFrontEndUrl = frontEndUrlStrt + "\\" + folderNameToCreate + "\\" + templateName1;

		try {
			hP.clickOnContentEditor();
			cE.clickOnTenant(tenantName);

			cE.rtClickOnAndInsert(subElement);
			iFT.switchFrame();
			iFT.expandFolder(folderNameToSelect);
			iFT.selectSubFolder(subFolder);
			iFT.createTemplate(folderNameToCreate);
			iFT.clickInsert();
			System.out.println("folder created");
			Thread.sleep(5000);
			iFT.switchOutOfFrame();

			cE.rtClickOnAndInsert(folderNameToCreate);
			iFT.switchFrame();
			iFT.expandRfwPresencePagesSelectSecure();
			iFT.selectSubFolder(secure);
			System.out.println("page selected");

			iFT.createTemplate(templateName);
			iFT.clickInsert();
			System.out.println("page created");

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

			Thread.sleep(10000);

			cE.switchFrame();
			driver.findElement(By.xpath("//td[@class='scEditorFieldMarkerInputCell'][div[text()='Data Source']]/div/a[contains(text(),'Browse')]")).click();
			Thread.sleep(10000);
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();

			cE.switchFrame3();
			fE.expandFolderInternalLink1("Media Library", 1);
			fE.expandFolderInternalLink1("rfwfpresence", 1);
			fE.expandFolderInternalLink1("HTML Container", 1);
			Thread.sleep(5000);

			
			driver.findElement(By.xpath("//div[a[span[text()='HTML Container']]]//span[text()='Form']")).click();
			
			eE.clickOK();
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();
			
			cE.switchFrame();
			eE.clickInputButton("OK");

			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();
			
			iFT.switchFrame5();
			
			
			pL.clickOnSave();
			iFT.switchOutOfFrame();
			driver.close();
			cE.switchBackTpParentWindow();
			cE.rtClickOnelement(folderNameToCreate, "Refresh");
			cE.rtClickOnAndInsert2(folderNameToCreate);
			iFT.switchFrame();
			iFT.expandRfwPresencePagesSelectSecure();
			iFT.selectSubFolder(secure);
			System.out.println("page selected");

			iFT.createTemplate(templateName1);
			iFT.clickInsert();
			System.out.println("page created");

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

			Thread.sleep(10000);

			cE.switchFrame();
			driver.findElement(By.xpath("//td[@class='scEditorFieldMarkerInputCell'][div[text()='Data Source']]/div/a[contains(text(),'Browse')]")).click();
			Thread.sleep(10000);
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();

			cE.switchFrame3();
			fE.expandFolderInternalLink1("Media Library", 1);
			fE.expandFolderInternalLink1("rfwfpresence", 1);
			fE.expandFolderInternalLink1("HTML Container", 1);
			Thread.sleep(5000);

			
			driver.findElement(By.xpath("//div[a[span[text()='HTML Container']]]//span[contains(text(),'Thank')]")).click();
			
			eE.clickOK();
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();
			
			cE.switchFrame();
			eE.clickInputButton("OK");

			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();
			
			iFT.switchFrame5();
			
			
			pL.clickOnSave();
			iFT.switchOutOfFrame();
			driver.close();
			cE.switchBackTpParentWindow();
			cE.clickOnlyPublishButton();
			hP.clickSave1();
			Thread.sleep(5000);
			iFT.switchFrame();
			iFT.clickOK();
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();
			iFT.switchFrame();
			iFT.clickOK();
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();
			
			cE.publishOptions();
			cE.publishSite();
			iFT.switchFrame();
			cE.clickPublishButton();
			Thread.sleep(90000);
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();

			iFT.switchFrame();
			cE.clickClose();
			iFT.switchOutOfFrame();
			cE.logout();
			cE.clearBrowserCache();
			cE.clearBrowserCache();
			driver.get(htmlContainerFrontEndUrl);
			fE.verifyLabelText("Name:");
			fE.verifyLabelText("E-mail:");
			fE.verifyLabelText("Message:");
		fE.verifyButtonText("Send your message");
			
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 3030, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 3030, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 3030, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 3030, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 3030, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 3030, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 3030, 5, screenShot + v + "_" + date1);

			}
		}
	}

}