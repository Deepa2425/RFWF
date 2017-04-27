package com.rfwf.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class TC_RFWF_SC_SS_11_addImage extends BaseTestNGPageSiteCoreV2 {
	@Test(priority = 1)
	public void textTC_RFWF_SS_11_addImage() throws InterruptedException {
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

		String folderNameToSelect = g.getExcelCellValue(xlPath, sheetName, 3102, 2);
		String subFolder = g.getExcelCellValue(xlPath, sheetName, 3103, 2);
		String folderNameToCreate = g.getExcelCellValue(xlPath, sheetName, 3104, 2);

		String secure = g.getExcelCellValue(xlPath, sheetName, 3105, 2);
		String templateName = g.getExcelCellValue(xlPath, sheetName, 3106, 2);
		String tenantName = g.getExcelCellValue(xlPath, sheetName, 3107, 2);
		String subElement = g.getExcelCellValue(xlPath, sheetName, 3108, 2);
		String pageLayout = g.getExcelCellValue(xlPath, sheetName, 3109, 2);

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
			iFT.selectSubFolder("Collections");
			iFT.selectSubFolder("Slick Slider");
			pL.clickSelect();
			iFT.switchOutOfFrame();
			Thread.sleep(10000);

			cE.switchFrame();

			eE.selectControlPropertiesDrop("Carousel Speed", "Medium");
			eE.selectControlPropertiesDrop("Slider Style", "Default Slider");
			eE.selectControlPropertiesDrop("Transition Speed", "Medium");
			eE.InputControlPropertiesText("Items to Scroll", "3");
			eE.CheckControlPropertiesBox("Vertical Display");
			eE.clickInputButton("OK");

			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();
			Thread.sleep(10000);

			pL.clickPageLayout();
			iFT.switchFrame();
			iFT.selectSubFolder("Slick Slider Item");
			pL.clickSelect();
			iFT.switchOutOfFrame();

			pL.clickPageLayout();
			iFT.switchFrame();
			iFT.selectSubFolder("Features");
			iFT.selectSubFolder("HighLight");
			pL.clickSelect();
			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();
			iFT.switchFrame();
			pL.clickCreateNewContent();
			pL.clickOK();

			iFT.switchOutOfFrame();
			iFT.switchOutOfFrame();
			Thread.sleep(10000);
			eE.clickImageIcon();
			System.out.println("entering block");
			eE.chooseImageOperation("Choose an image.", 2);
			System.out.println("after img");
			iFT.switchFrame();
			System.out.println("frame chosen");
			Thread.sleep(10000);
			String img1 = eE.choosehighlightImge("cover", 1);
			System.out.println("pic found");

			System.out.println(img1);
			eE.clickFooterSelect();

			System.out.println("finding image");
			iFT.switchOutOfFrame();
			String match = "jpg";
		     
			  int index = img1.indexOf(match);
			       
			  index=index+2;
			      
			  System.out.println(index);
			   
			  String finalstring=img1.substring(0,index);

			driver.findElement(By.xpath("//img[contains(@src,'" + finalstring + "')]"));
			System.out.println("found image");
			eE.clickCaptionArea(1);

			// driver.findElement(By.xpath("//div[@class='caption']/h2")).click();
			System.out.println("clicked on blank");

			eE.editHighlightheading(1, "hello123");
			System.out.println("new text");
			eE.editHighlightDesc(1, "highlight dis");
			// done
			pL.clickOnSave();
			iFT.switchOutOfFrame();
			driver.close();
			cE.switchBackTpParentWindow();
			cE.logout();

			b = true;
			g.setExcelCellValue(xlPath, sheetName, 3102, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 3102, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 3102, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 3102, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 3102, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 3102, 4, "Executed on - " + date1);
				g.setExcelCellValue(xlPath, sheetName, 3102, 5, screenShot + v + "_" + date1);

			}
		}
	}

}
