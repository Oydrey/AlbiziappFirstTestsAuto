package com.automation.selenium.matheo;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.Constantes;

import org.openqa.selenium.Dimension;

public class CTRF121_TestAccederScore {
	
	public static void test(WebDriver driver) {
		FonctionMethods.login(driver, Constantes.LOGIN_TQL_EMAIL , Constantes.LOGIN_TQL_PASSWORD);
		driver.manage().window().setSize(new Dimension(785, 625));
		driver.findElement(By.cssSelector(".fa-trophy")).click();
		assertEquals("https://albiziapp.ozytis.fr/score", driver.getCurrentUrl());
	}
}
