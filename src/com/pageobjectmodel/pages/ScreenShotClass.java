package com.pageobjectmodel.pages;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotClass {
	public static void captureScreenShot(WebDriver driver,String screenShot ) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./RFWF_SCREENSHOTS/"+screenShot+".png"));
		} catch(Exception e) {
			System.out.println("Exception while taking screenshot - "+e.getMessage());
		}
	}

}
