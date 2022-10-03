package com.ixigo.qa.testcases;

import org.testng.annotations.Test;

import com.ixigo.qa.common.TestBase;
import com.ixigo.qa.pages.SearchFlightsPage;

public class SearchFlightTestCases extends TestBase {

	SearchFlightsPage searchFlightsPage;

	@Test
	public void getTop20Flights() {
		searchFlightsPage = new SearchFlightsPage(driver);
		searchFlightsPage.getPageTitle();
		searchFlightsPage.SearchFlight("BOM", "HYD", "1", "Economy");

	}
}
