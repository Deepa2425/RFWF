package com.rfwf.scripts;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.basetestng.libraries.BaseTestNGPageSiteCoreV2;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.ContentEditor;
import com.pageobjectmodel.pages.HomePage;
import com.pageobjectmodel.pages.InsertFromTemplate;

public class TC_RFWF_FolderDeletion_V2_MultiTenant extends BaseTestNGPageSiteCoreV2 {
	@Test
	public void textTC_RFWF_FolderDeletion_V2_MultiTenant() throws InterruptedException {
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_5();
		String date1 = aPOI.getDate_1();

		HomePage hP = new HomePage(driver);
		ContentEditor cE = new ContentEditor(driver);
		InsertFromTemplate iFT = new InsertFromTemplate(driver);

		try {
			hP.clickOnContentEditor();
			cE.clickOnTenant("TestMultiTenant");
			cE.clickOnTenant_01();
			int rowCount = g.getExcelRowCount(xlPath, sheetName);
			System.out.println("Row Count - " + rowCount);

			for (int i = 1; i <= rowCount; i++) {
				String folderNameToDelete = g.getExcelCellValue(xlPath, sheetName, i, 0);
				List<WebElement> v = driver.findElements(By.xpath("//span[text()='" + folderNameToDelete + "']"));

				// size check - print name and size
				if (!(v.size() == 0)) {
					iFT.rightClickOnElement(folderNameToDelete);
					System.out.println("Folder Name - " + folderNameToDelete + " - " + i);
					System.out.println("Size -" + v.size() + " - " + i);
					System.out.println("*********************************");
					try {
						hP.clickRtClickDelete();
						iFT.switchFrame();
						iFT.clickContinue();
						iFT.clickContinue();
						iFT.switchOutOfFrame();
						cE.rtClickOnelement("RfwfPresence", "Refresh");
						cE.clickOnTenant("home");
					} catch (Exception e) {

					}
					g.setExcelCellValue(xlPath, sheetName, i, 1, "DELETED");
					g.setExcelCellValue(xlPath, sheetName, i, 2, "Deleted on - " + date1);
				} else {
					g.setExcelCellValue(xlPath, sheetName, i, 1, "Folder Not Present");
					g.setExcelCellValue(xlPath, sheetName, i, 2, "Verified on - " + date1);
					continue;
				}
				continue;
			}

		} catch (Exception e1) {
		}
	}

}
