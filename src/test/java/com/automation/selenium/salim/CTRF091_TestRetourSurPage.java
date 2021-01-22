package com.automation.selenium.salim;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF091_TestRetourSurPage {

	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		driver.findElement(By.cssSelector(".fa-trophy")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]/div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
		assertEquals("https://albiziapp.ozytis.fr/score", driver.getCurrentUrl());
	}

}
