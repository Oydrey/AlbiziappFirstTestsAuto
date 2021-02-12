package com.automation.selenium.matheo;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

import org.openqa.selenium.Dimension;

public class CTRF1021_TestConsulterOngletFlore {
	
	public static void test(WebDriver driver) throws InterruptedException {
		driver.manage().window().setSize(new Dimension(785, 625));
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL , Constantes.LOGIN_TQL_PASSWORD);
		driver.findElement(By.cssSelector(".MuiIconButton-label > .MuiSvgIcon-root")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/ul/div[1]")).click();
		assertEquals("https://albiziapp.ozytis.fr/species", driver.getCurrentUrl());
	}
}
