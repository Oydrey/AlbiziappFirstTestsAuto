package com.automation.selenium.salim;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF1241_TestVoirSesPointsDeConnaissances {
	
	
	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		new WebDriverWait(driver, 5).until(ExpectedConditions.urlMatches("https://albiziapp.ozytis.fr/map"));
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[3]")).click();
		
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[2]/div[1]/p")).isDisplayed());
		
		
	}

}
