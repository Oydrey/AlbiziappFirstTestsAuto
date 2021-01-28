package com.automation.selenium.goran;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF251_TestVoirReleveAutreUtilisateur {

	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_OYDREY_EMAIL, Constantes.LOGIN_OYDREY_PASSWORD);
		CommonMethods.testRenseignerReleveSurLaCarteAvecHauteur2m5m(driver);
		String identifier = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_MAP_DERNIER_RELEVE)).getAttribute("d");
		CommonMethods.testSeDeconnecter(driver);
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		String identifierDernierReleve = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_MAP_DERNIER_RELEVE)).getAttribute("d");
		assertTrue(identifier.equals(identifierDernierReleve));
		CommonMethods.testSeDeconnecter(driver);
		CommonMethods.login(driver, Constantes.LOGIN_OYDREY_EMAIL, Constantes.LOGIN_OYDREY_PASSWORD);
		CommonMethods.SuprimeReleve1ere(driver);
	}

}
