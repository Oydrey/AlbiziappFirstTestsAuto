package com.automation.selenium.matheo;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.Constantes;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class CTRF1281_TestVoirSonStatut {
	
	public static void test(WebDriver driver) throws InterruptedException {
		driver.manage().window().setSize(new Dimension(1382, 744));
		FonctionMethods.login(driver, Constantes.LOGIN_TQL_EMAIL , Constantes.LOGIN_TQL_PASSWORD);
		driver.findElement(By.xpath("//div[@id=\'root\']/div/div[2]/button[3]/span/span")).click();
		driver.findElement(By.xpath("//div[@id=\'root\']/div/div/ul/li[4]/div/span")).click();
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]")).isDisplayed());
		WebElement classe  = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]"));
		Assert.assertEquals(classe.getAttribute("class"),"MuiListItem-root MuiListItem-gutters");
	}
}
