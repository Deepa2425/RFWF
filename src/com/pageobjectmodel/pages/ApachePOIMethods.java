package com.pageobjectmodel.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApachePOIMethods {
	
	public String getConfigFilePath() {
		String xlPath = "C:\\RFWF_FRAMEWORK\\RFWF\\test-input\\config.xlsx";
		return xlPath;
	}
	
	public String getDate_1() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		return date1;
	}
	public String getDate_2() {
		Date date = new Date();
		String date2 = date.toString().replace(" ", "").replace(":", "-");
		return date2;
	}
	//sysout
	public String getServerFiles() {
		return "C:\\RFWF_FRAMEWORK\\RFWF\\ServerFiles\\chromedriver.exe";
	}
	
	public String screentShots() {
		return "C:->Users->RFWF_FRAMEWORK->RFWF->RFWF_SCREENSHOTS->";
	}
	
	public String getSheet_1() {
		return "DeepaScripts";
	}
	
	public String getSheet_2() {
		return "URL";
	}
	
	public String getSheet_3() {
		return "DLSSiteRegisterUser";
	}
	
	public String getSheet_4() {
		return "NewScriptsPrincy";
	}
	
	public String getSheet_5() {
		return "RFWF_FOLDER_DELETION";
	}

	public String getSheet_6() {
		return "RFWF_STATUS";
	}
}
