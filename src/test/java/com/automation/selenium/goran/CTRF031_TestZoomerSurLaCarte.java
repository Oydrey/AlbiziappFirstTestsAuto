package com.automation.selenium.goran;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF031_TestZoomerSurLaCarte {

	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_OYDREY_EMAIL, Constantes.LOGIN_OYDREY_PASSWORD);
		String style = driver.findElement(By.xpath(Constantes.XPATH_MAP_STYLE_SCALE)).getAttribute("style");
		String[] tbl = style.split(Constantes.REGEX_CTRF031);
		for (String string : tbl) {
			System.out.println(string);
		}
		int scale = Integer.valueOf(style.split(Constantes.REGEX_CTRF031)[1]);
		driver.findElement(By.xpath(Constantes.XPATH_MAP_BOUTON_ZOOM)).click();
		style = driver.findElement(By.xpath(Constantes.XPATH_MAP_STYLE_SCALE)).getAttribute("style");
		int scaleAfterZoom = Integer.valueOf(style.split(Constantes.REGEX_CTRF031)[1]);
		System.out.println(style.split(Constantes.REGEX_CTRF031)[1]);
		assertTrue((scale*2)==scaleAfterZoom);
	}
	
}
