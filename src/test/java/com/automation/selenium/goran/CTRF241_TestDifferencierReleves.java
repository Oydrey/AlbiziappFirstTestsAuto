package com.automation.selenium.goran;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF241_TestDifferencierReleves {

	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_OYDREY_EMAIL, Constantes.LOGIN_OYDREY_PASSWORD); 
		CommonMethods.testRenseignerReleveSurLaCarteAvecHauteur2m5m(driver);
		String color = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_MAP_DERNIER_RELEVE)).getAttribute("fill-opacity");
		CommonMethods.testSeDeconnecter(driver);
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		String colorDernierReleve = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_MAP_DERNIER_RELEVE)).getAttribute("fill-opacity");
		assertTrue(color.equals("0.5"));
		assertTrue(colorDernierReleve.equals("0"));
		CommonMethods.testSeDeconnecter(driver);
		CommonMethods.login(driver, Constantes.LOGIN_OYDREY_EMAIL, Constantes.LOGIN_OYDREY_PASSWORD); 
		CommonMethods.SuprimeReleve1ere(driver);
	}
	
}
