package com.automation.selenium.goran;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;
import com.automation.selenium.matheo.FonctionMethods;

public class CTRF161_TestVoirNombreIdentificactions {

	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_OYDREY_EMAIL, Constantes.LOGIN_OYDREY_PASSWORD);
		driver.findElement(ByXPath.xpath(Constantes.XPATH_MENU_BAS_ARBORETUM_BOUTON)).click();
		String text = driver.findElement(ByXPath.xpath(Constantes.XPATH_ARBORETUM_PREMIERE_ESPECE_NOMBRE_IDENTIFICATIONS_TEXTE)).getText();
		int nombreIdentificationAvantReleve = Integer.valueOf(text.split(" ")[3]);
		driver.findElement(ByXPath.xpath(Constantes.XPATH_MENU_BAS_MAP_BOUTON)).click();
		CommonMethods.testRenseignerReleveSurLaCarteAvecHauteur2m5m(driver);
		driver.findElement(ByXPath.xpath(Constantes.XPATH_MENU_BAS_ARBORETUM_BOUTON)).click();
		text = driver.findElement(ByXPath.xpath(Constantes.XPATH_ARBORETUM_PREMIERE_ESPECE_NOMBRE_IDENTIFICATIONS_TEXTE)).getText();
		int nombreIdentificationApresReleve = Integer.valueOf(text.split(" ")[3]);
		assertTrue((nombreIdentificationAvantReleve + 1)==nombreIdentificationApresReleve);
		FonctionMethods.SuprimeReleve1ere(driver);
	}
	
}
