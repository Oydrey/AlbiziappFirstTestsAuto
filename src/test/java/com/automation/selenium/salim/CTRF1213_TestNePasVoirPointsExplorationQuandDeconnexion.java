package com.automation.selenium.salim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CTRF1213_TestNePasVoirPointsExplorationQuandDeconnexion {

	public static void test(WebDriver driver) {
		driver.get("https://albiziapp.ozytis.fr/");
		new WebDriverWait(driver, 5).until(ExpectedConditions.urlMatches("https://albiziapp.ozytis.fr/login"));
	}

}
