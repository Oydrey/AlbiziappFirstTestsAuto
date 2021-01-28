package com.automation.selenium.goran;

import static org.junit.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF151_TestVoirGenresIdentifies {

	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_OYDREY_EMAIL, Constantes.LOGIN_OYDREY_PASSWORD);
		CommonMethods.testRenseignerReleveSurLaCarteAvecHauteur2m5m(driver);
		driver.findElement(ByXPath.xpath(Constantes.XPATH_MENU_BAS_ARBORETUM_BOUTON)).click();
		boolean isPresent = false;
		List <WebElement> parentElements = driver.findElements(ByXPath.xpath(Constantes.XPATH_ARBORETUM_LISTE_IDENTIFICATION));
		for (WebElement element : parentElements) {
			String nomGenre = element.findElement(ByXPath.xpath(Constantes.XPATH_LISTE_IDENTIFIACTION_NOM_ESPECE_SELECT)).getText();
			if (nomGenre.equals("Albizia Julibrissin")) {
				isPresent = true;
			}
		}
		assertTrue(isPresent);
		CommonMethods.SuprimeReleve1ere(driver);
	}
	
}
