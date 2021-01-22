package com.automation.selenium.goran;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF201_TestVoirSaPosition {

	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_OYDREY_EMAIL, Constantes.LOGIN_OYDREY_PASSWORD);
		assertTrue(driver.findElement(By.xpath(Constantes.XPATH_MAP_CURSEUR_POSITION)).isDisplayed());
	}
	
}
