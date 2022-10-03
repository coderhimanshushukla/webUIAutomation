package com.ixigo.qa.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	protected static WebDriver driver;
	protected static Properties properties;
	public  static Logger log = Logger.getLogger("IXIGO Automation");

	// constructor
	public TestBase() {
		System.out.println("-----------------TEST BASE------------------------");
		String configPath = "/src/main/java/com/ixigo/qa/configuration/config.properties";
		try {
			properties = new Properties();
			FileInputStream inputstream = new FileInputStream(System.getProperty("user.dir") + configPath);

			properties.load(inputstream);
		} catch (FileNotFoundException e) {
			System.out.println(" File Exception " + e.getMessage());

		} catch (IOException e) {
			System.out.println("io exception " + e.getMessage());

		}

		initializaton();
	}

	private static void initializaton()  {
	
		


		WebDriverManager.chromedriver().setup();
		System.out.println("--------------------INIT---------------------");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		log.info(" chrome browser is selected by default");
		System.out.println("--------------------INIT---------------------");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	
		String url = properties.getProperty("url");
		driver.get(url);

	}

	
	public WebDriver getDriverInstance() {
		return driver;
	}
	
	public void tearDownMain() {
		driver.manage().deleteAllCookies();
		driver.close();
	}

}
