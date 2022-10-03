package com.ixigo.qa.pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFlightsPage {
	WebDriver driver;

	@FindBy(xpath = "//img[@class='ixigo-logo']")
	WebElement ixigoLogo;

	@FindBy(xpath = "//span[text() ='Round Trip']")
	WebElement roundTripBtn;

	@FindBy(xpath = "//div[text() ='From']/following-sibling::input")
	WebElement fromInputField;

	@FindBy(xpath = "(//div[@class='clear-input ixi-icon-cross'])[1]")
	WebElement clearFromField;

	@FindBy(xpath = "//div[text() ='To']/following-sibling::input")
	WebElement toInputField;

	@FindBy(xpath = "//div[text() ='Departure']/following-sibling::input")
	WebElement departureDateField;

	@FindBy(xpath = "//div[text() ='Return']/following-sibling::input")
	WebElement arrivalDateField;

	@FindBy(xpath = "//div[text() ='Travellers | Class']/following-sibling::input")
	WebElement travellersClassField;

	@FindBy(xpath = "//div[@class='search u-ib u-v-align-bottom']/button")
	WebElement searchButton;

	public SearchFlightsPage(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		return driver.getTitle();

	}

	public void SearchFlight(String from, String to, String noOfAdult, String userClass) {
		try {

			// click round trip button

			roundTripBtn.click();
			Thread.sleep(2000);

			// From field code
			clearFromField.click();
			Thread.sleep(2000);
			fromInputField.click();
			fromInputField.sendKeys(from);
			Thread.sleep(3000);
			fromInputField.sendKeys(Keys.ENTER);
			Thread.sleep(2000);

			// To Field Code
			toInputField.click();
			toInputField.sendKeys(to);
			Thread.sleep(3000);
			toInputField.sendKeys(Keys.ENTER);
			Thread.sleep(3000);

			// Departure Date Field code
			String departureDate = addDaysInCurrentDate(10);

			departureDateField.click();
			driver.findElement(By.xpath("//td[@data-date='" + departureDate + "']")).click();
			Thread.sleep(3000);

			// Arrival Date Field Code
			String arrivalDate = addDaysInCurrentDate(11);
			arrivalDateField.click();
			driver.findElement(By.xpath("(//td[@data-date='" + arrivalDate + "'])[2]")).click();

			searchButton.click();

			Thread.sleep(30000);

			for (int j = 1; j <= 20; j++) {
				Thread.sleep(1000);
				WebElement deptFlight = driver.findElement(By.xpath(
						"(//div[@class='result-col outr']//div[contains(@class,'c-flight-listing-split-row')]/div[@class='summary-section'])"
								+ "[" + j + "]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deptFlight);

				System.out.println("<----------------Top 20 cheapest flight information ----------------->");
				System.out.println("<-----departure flight----->");
				System.out.println("No." + (j) + " " + deptFlight.getText());

				Thread.sleep(1000);

				System.out.println("<------Arrival flight----->");
				WebElement arrivalFlight = driver.findElement(By.xpath(
						"(//div[@class='result-col']//div[contains(@class,'c-flight-listing-split-row')]/div[@class='summary-section'])"
								+ "[" + j + "]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deptFlight);

				System.out.println("No." + (j) + " " + arrivalFlight.getText());
				System.out.println("<========================END==============================>");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String addDaysInCurrentDate(int noOfDays) {
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, noOfDays);
		Date currentDatePlusOne = c.getTime();

		String dateAsString = new SimpleDateFormat("ddMMyyyy").format(currentDatePlusOne);
		return dateAsString;

	}

}
