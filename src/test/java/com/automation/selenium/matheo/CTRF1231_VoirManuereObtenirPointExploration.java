package com.automation.selenium.matheo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class CTRF1231_VoirManuereObtenirPointExploration {
	
	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL , Constantes.LOGIN_TQL_PASSWORD);
		driver.findElement(By.xpath("//div[@id=\'root\']/div/div[2]/button[3]/span/span")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]/div[1]/span")).click();
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul[3]")).isDisplayed());
		WebElement elementnondate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul[3]/li[1]/div/span"));
		assertEquals(elementnondate.getText(),"Comment obtenir des points?");
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul[3]/li[2]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul[3]/li[3]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul[3]/li[4]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul[3]/li[5]")).isDisplayed());
	}
}
