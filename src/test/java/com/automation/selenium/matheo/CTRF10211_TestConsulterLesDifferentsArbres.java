package com.automation.selenium.matheo;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.Constantes;

import org.openqa.selenium.Dimension;

public class CTRF10211_TestConsulterLesDifferentsArbres {
	
	public static void test(WebDriver driver) {
		driver.manage().window().setSize(new Dimension(785, 625));
		FonctionMethods.login(driver, Constantes.LOGIN_TQL_EMAIL , Constantes.LOGIN_TQL_PASSWORD);
		driver.findElement(By.cssSelector(".MuiIconButton-label > .MuiSvgIcon-root")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/ul/div[1]")).click();
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul")).isDisplayed());
		
		for (int i = 1 ; i < 10; i++) { //on regarde si la liste des arbres s'affiche ici, je test que 10
			assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li["+i+"]")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/div["+i+"]")).isDisplayed());
		}
	}
}
