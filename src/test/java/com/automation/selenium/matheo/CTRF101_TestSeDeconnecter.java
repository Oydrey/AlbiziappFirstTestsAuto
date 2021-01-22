package com.automation.selenium.matheo;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.Constantes;

import org.openqa.selenium.Dimension;

public class CTRF101_TestSeDeconnecter {

	public static void test(WebDriver driver) {
		driver.manage().window().setSize(new Dimension(785, 625));
		FonctionMethods.login(driver, Constantes.LOGIN_TQL_EMAIL , Constantes.LOGIN_TQL_PASSWORD);
		driver.findElement(By.cssSelector(".MuiIconButton-label > .MuiSvgIcon-root")).click();
		driver.findElement(By.xpath("//div[3]/div[2]/span")).click();
		assertEquals("https://albiziapp.ozytis.fr/login", driver.getCurrentUrl());
	}
}
