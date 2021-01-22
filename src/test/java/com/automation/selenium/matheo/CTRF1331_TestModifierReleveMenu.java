package com.automation.selenium.matheo;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.Constantes;

import org.openqa.selenium.Dimension;

public class CTRF1331_TestModifierReleveMenu {
	
	public static void test(WebDriver driver) throws InterruptedException {
		driver.manage().window().setSize(new Dimension(785, 625));
		FonctionMethods.login(driver, Constantes.LOGIN_TQL_EMAIL , Constantes.LOGIN_TQL_PASSWORD);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();	  
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]/div[1]/p")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/button")).click();
		String vCurrentURL = driver.getCurrentUrl();
		assertTrue(vCurrentURL.matches("https://albiziapp.ozytis.fr/edit-observation/.*"));

	}
}
