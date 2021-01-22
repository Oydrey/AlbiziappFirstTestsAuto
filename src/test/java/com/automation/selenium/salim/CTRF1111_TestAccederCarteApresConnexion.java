package com.automation.selenium.salim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF1111_TestAccederCarteApresConnexion {

	public static void test(WebDriver driver) {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		new WebDriverWait(driver, 5).until(ExpectedConditions.urlMatches("https://albiziapp.ozytis.fr/map"));
	}

}
