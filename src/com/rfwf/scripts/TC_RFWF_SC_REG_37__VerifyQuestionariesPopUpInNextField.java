package com.rfwf.scripts;

import org.testng.annotations.Test;

import com.basetestng.libraries.BaseTestNGPageDLSSiteFrontEnd;
import com.basetestng.libraries.ReadDataFromExcel;
import com.pageobjectmodel.pages.ApachePOIMethods;
import com.pageobjectmodel.pages.DLSSiteRegisterPage;

public class TC_RFWF_SC_REG_37__VerifyQuestionariesPopUpInNextField extends BaseTestNGPageDLSSiteFrontEnd {
	@Test
	public void textFE_TC_RFWF_SC_REG_37_VerifyQuestionariesPopUpInNextField() throws InterruptedException {
		DLSSiteRegisterPage dSSRP = new DLSSiteRegisterPage(driver);
		
		boolean b = false;
		ReadDataFromExcel g = new ReadDataFromExcel();
		ApachePOIMethods aPOI = new ApachePOIMethods();
		String xlPath = aPOI.getConfigFilePath();
		String sheetName = aPOI.getSheet_1();
		String sheetName1 = aPOI.getSheet_2();
		String screenShot = aPOI.screentShots();
		String date1 = aPOI.getDate_1();
		String date2 = aPOI.getDate_2();
		
		String q1 = g.getExcelCellValue(xlPath, sheetName, 34, 2);
		String q2 = g.getExcelCellValue(xlPath, sheetName, 35, 2);
		String q3 = g.getExcelCellValue(xlPath, sheetName, 36, 2);
		String q4 = g.getExcelCellValue(xlPath, sheetName, 37, 2);
		String q5 = g.getExcelCellValue(xlPath, sheetName, 38, 2);
		String q6 = g.getExcelCellValue(xlPath, sheetName, 39, 2);
		String q7 = g.getExcelCellValue(xlPath, sheetName, 40, 2);

		String a1 = g.getExcelCellValue(xlPath, sheetName, 41, 2);
		String a2 = g.getExcelCellValue(xlPath, sheetName, 42, 2);
		String a3 = g.getExcelCellValue(xlPath, sheetName, 43, 2);
		String a4 = g.getExcelCellValue(xlPath, sheetName, 44, 2);
		String a5 = g.getExcelCellValue(xlPath, sheetName, 45, 2);
		String a6 = g.getExcelCellValue(xlPath, sheetName, 46, 2);
		String a7 = g.getExcelCellValue(xlPath, sheetName, 47, 2);

		String qq1 = g.getExcelCellValue(xlPath, sheetName, 48, 2);
		String qq2 = g.getExcelCellValue(xlPath, sheetName, 49, 2);
		String qq3 = g.getExcelCellValue(xlPath, sheetName, 50, 2);
		String qq4 = g.getExcelCellValue(xlPath, sheetName, 51, 2);
		String qq5 = g.getExcelCellValue(xlPath, sheetName, 52, 2);
		String qq6 = g.getExcelCellValue(xlPath, sheetName, 53, 2);
		String qq7 = g.getExcelCellValue(xlPath, sheetName, 54, 2);

		String qq8 = g.getExcelCellValue(xlPath, sheetName, 55, 2);
		String qq9 = g.getExcelCellValue(xlPath, sheetName, 56, 2);
		String qq10 = g.getExcelCellValue(xlPath, sheetName, 57, 2);
		try {

			dSSRP.verifyQuestionariesInNextField(3,"Q1",4,1);
			dSSRP.verifyQuestionariesInNextField(3,"Q2",4,2);
			dSSRP.verifyQuestionariesInNextField(3,"Q3",4,3);
		
			b = true;
			g.setExcelCellValue(xlPath, sheetName, 323, 3, "PASS");
			g.setExcelCellValue(xlPath, sheetName, 323, 4, "Executed on - " + date1);

		} catch (Exception e1) {
			g.setExcelCellValue(xlPath, sheetName, 323, 3, "FAIL");
			g.setExcelCellValue(xlPath, sheetName, 323, 4, date1);
		} finally {
			if (!b) {
				String v = this.getClass().getSimpleName();
				com.pageobjectmodel.pages.ScreenShotClass.captureScreenShot(driver, v + date2);
				g.setExcelCellValue(xlPath, sheetName, 323, 3, "FAIL");
				g.setExcelCellValue(xlPath, sheetName, 323, 4, "Executed on - " + date1);

				g.setExcelCellValue(xlPath, sheetName, 323, 5,
						screenShot+ v + "_" + date1);
			}
		}
	}

}
