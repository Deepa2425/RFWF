package com.rfwf.scripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;

public class TC_RFWF_SC_EA_2_RfwfPresenceV2_CreateComponentAndPageLayout extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_SC_EA_2_RfwfPresenceV2_CreateComponentAndPageLayout() throws InterruptedException {
		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
			
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String sheetName1 = aPOI.getSheet_2();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();

		boolean b = false;
		
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName,826, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 830, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 831, 2);

		String component = g.getExcelCellValue(xlPath, sheetName, 835, 2);
		String userActivate = g.getExcelCellValue(xlPath, sheetName, 837, 2);
		String itemPath = g.getExcelCellValue(xlPath, sheetName, 844, 2);
		String frontEndURL = g.getExcelCellValue(xlPath, sheetName1, 29, 1);

		try {
			hP.clickOnContentEditor();
			cE.clickOnTenant(tenantName);
/*			cE.rtClickOnAndInsert(subElement);
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
			cE.unlockTemplate();

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
			iFT.selectSubFolderS1(templateName, templateName1);
			pL.clickSelect();
			iFT.switchOutOfFrame();
			iFT.switchFrame();
			pL.clickCreateNewContent();
			pL.clickOK();
			iFT.switchOutOfFrame();
			
			iFT.switchFrame1();
			pL.clickOnSave();
			iFT.switchOutOfFrame();
			driver.close();
			Thread.sleep(5000);
			cE.switchBackTpParentWindow();
			cE.rtClickOnelement(tenantName, refresh);*/
			
			//cE.clickOnTenant(tenantName);
			cE.clickOnTenant(subElement);
			cE.clickOnTenant(folderNameToCreate);
			cE.clickOnTenant(component);
			
			hP.expandContent();
			cE.clickOnTenant(userActivate);
			driver.findElement(By.xpath("(//span[text()='Activate Email'])[1]")).click();
			driver.findElement(By.xpath("(//span[text()='Activate Email'])[1]")).click();
			cE.verifyItemPath(itemPath);
			/*String v = driver.findElement(By.xpath(".//*[@id='EditorPanel']/table/tbody/tr/td/table/tbody/tr[3]/td[2]/input")).getAttribute("value");
			System.out.println(v);
			System.out.println(itemPath);
			if(!(v.contains(itemPath))) {
				Assert.fail("Item Path not found!");
			}*/
		/*	hP.editField(3,"");
			hP.editField(19,"");
			hP.editField(21,"");
			hP.editField(22,"");
			hP.selectSubFolder(save);
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
	         iFT.switchOutOfFrame();*/
	     cE.logout();
	     cE.clearBrowserCache();
	        driver.get(frontEndURL);

	        cE.verifyFrontEndFieldsPositive("txtUsername","");
	        cE.verifyFrontEndFieldsPositive("txtPassword","");
	       
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 824, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 824, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 824, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 824, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v+ date2);
				g.setExcelCellValue(xlPath, sheetName, 824, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 824, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 824, 5,
						screenShot + v + "_" + date1);

			}
		}
	}

}
