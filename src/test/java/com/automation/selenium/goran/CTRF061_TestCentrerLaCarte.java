package com.automation.selenium.goran;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF061_TestCentrerLaCarte {
	
	@Test 
	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_OYDREY_EMAIL, Constantes.LOGIN_OYDREY_PASSWORD);
		driver.findElement(By.xpath(Constantes.XPATH_MAP_BOUTON_CENTRER)).click();
		String position = driver.findElement(By.xpath(Constantes.XPATH_MAP_STYLE)).getAttribute("style");
		assertTrue(position.equals(Constantes.ASSERT_CTRF061_STYLE));
	}
	
}
