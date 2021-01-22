package com.automation.selenium.goran;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF051_TestConsulterMissionEnCoursDepuisLaCarte {

	public static void test(WebDriver driver) {
		CommonMethods.login(driver, Constantes.LOGIN_OYDREY_EMAIL, Constantes.LOGIN_OYDREY_PASSWORD);
		assertTrue(driver.findElement(By.xpath(Constantes.XPATH_MAP_MISSION_EN_COURS)).isDisplayed());
		String nomMission = driver.findElement(By.xpath(Constantes.XPATH_MAP_MISSION_EN_COURS)).getText();
		driver.findElement(By.xpath(Constantes.XPATH_MENU_BAS_MISSION_BOUTON)).click();
		//verifier mission
		boolean isPresent = false;
		List <WebElement> parentElements = driver.findElements(ByXPath.xpath(Constantes.XPATH_MISSIONS_LISTE_MISSIONS));
		for (WebElement element : parentElements) {
			if ((element.findElement(By.xpath(Constantes.XPATH_lISTE_MISSIONS_NOM_MISSION_SELECT)).getText()).equals(nomMission)) {
				isPresent = element.findElement(By.xpath(Constantes.XPATH_LISTE_MISSIONS_BARRE_PROGRESSION_MISSION_SELECT)).isDisplayed();
			}
		}
		assertTrue(isPresent);
	}
	
}
