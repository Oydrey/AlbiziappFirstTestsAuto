package com.automation.selenium.matheo;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

import org.openqa.selenium.Dimension;

public class CTRF101_TestSeDeconnecter {

	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL , Constantes.LOGIN_TQL_PASSWORD);
		driver.findElement(By.cssSelector(".MuiIconButton-label > .MuiSvgIcon-root")).click();
		driver.findElement(By.xpath("//div[4]/div[2]/span")).click();
		assertEquals("https://albiziapp.ozytis.fr/login", driver.getCurrentUrl());
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		driver.switchTo().window(iterator.next());	
		
		WebElement vSignInButton = driver.findElement(ByXPath.xpath(Constantes.XPATH_LOGIN_SIGN_IN_BOUTON));
		vSignInButton.click();	
		
		windows = driver.getWindowHandles();
		iterator = windows.iterator();
		
		while(iterator.hasNext()) {
			String childWindow = iterator.next();
			
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				
				driver.findElement(By.xpath(Constantes.XPATH_OSM_MENU_ICONE)).click();
				driver.findElement(By.xpath(Constantes.XPATH_OSM_MENU_PROFIL_BOUTON)).click();
				driver.findElement(By.xpath(Constantes.XPATH_OSM_SE_DECONNECTER_BOUTON)).click();
				driver.close();
				
			}
		}
		
		driver.switchTo().window(mainWindow);
	}
}
