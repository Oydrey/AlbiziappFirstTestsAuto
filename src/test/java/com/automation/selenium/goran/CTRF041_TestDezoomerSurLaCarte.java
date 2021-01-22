package com.automation.selenium.goran;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF041_TestDezoomerSurLaCarte {

	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_OYDREY_EMAIL, Constantes.LOGIN_OYDREY_PASSWORD);
		String style = driver.findElement(By.xpath(Constantes.XPATH_MAP_STYLE_SCALE)).getAttribute("style");
		int scale = Integer.valueOf(style.split(" ")[4].split("(")[1].split(")")[0]);
		driver.findElement(By.xpath(Constantes.XPATH_MAP_BOUTON_DEZOOM)).click();
		style = driver.findElement(By.xpath(Constantes.XPATH_MAP_STYLE_SCALE)).getAttribute("style");
		int scaleAfterDezoom = Integer.valueOf(style.split(" ")[4].split("(")[1].split(")")[0]);
		assertTrue((scaleAfterDezoom*2)==scale);
	}
	
}
