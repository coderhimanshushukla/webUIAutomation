package com.ixigo.qa.common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtils {

	 DateFormat dateFormat;
	 Date date;

	public static final String WORKSAPCE_PATH = System.getProperty("user.dir"); 

	public static final String SCREENSHOT_PATH = WORKSAPCE_PATH + "//Screenshot//";

	public static final String DateFormat = "yyyyMMddHH:mm:ss";

	
	public static final long PAGE_LOAD_TIMEOUT = 100;

	public static final long IMPLICIT_WAIT = 10;

	
	public  String getDate(String format) {
		dateFormat = new SimpleDateFormat(format);
		date = new Date();
		return dateFormat.format(date);
	}

	public  void takeScreenShot(WebDriver driver) {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(SCREENSHOT_PATH + "//screenshot//" + getDate(DateFormat) + ".png"));
		} catch (IOException e) {
			System.out.println("IO exception "+e.getMessage());
		}

	}

}
