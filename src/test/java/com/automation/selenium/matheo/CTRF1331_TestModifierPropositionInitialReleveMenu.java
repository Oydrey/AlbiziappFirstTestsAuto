package com.automation.selenium.matheo;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

import org.openqa.selenium.Dimension;

public class CTRF1331_TestModifierPropositionInitialReleveMenu {
	
	public static void test(WebDriver driver) throws InterruptedException {
		driver.manage().window().setSize(new Dimension(785, 625));
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL , Constantes.LOGIN_TQL_PASSWORD);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();	
		//mis sur le 2 eme releve de la list car le 1 ere est buger
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[2]/div[1]/p")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div[2]/span/span")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/button[1]")).click();
		String vCurrentURL = driver.getCurrentUrl();
		assertTrue(vCurrentURL.matches("https://albiziapp.ozytis.fr/edit-observation/.*"));
		
		assertTrue(driver.findElement(By.xpath("//*[@id=\"commonGenusSelect\"]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//*[@id=\"genusSelect\"]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//*[@id=\"speciesCommonNameSelect\"]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//*[@id=\"speciesNameSelect\"]")).isDisplayed());
	}
}
