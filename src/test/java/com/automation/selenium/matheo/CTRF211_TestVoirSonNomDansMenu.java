package com.automation.selenium.matheo;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.Constantes;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class CTRF211_TestVoirSonNomDansMenu {
	
	public static void test(WebDriver driver) throws InterruptedException {
		FonctionMethods.login(driver, Constantes.LOGIN_TQL_EMAIL , Constantes.LOGIN_TQL_PASSWORD);
		driver.manage().window().setSize(new Dimension(785, 625));
		//driver.navigate.refresh
		((JavascriptExecutor)driver).executeScript("document.location.reload()");
		driver.findElement(By.cssSelector(".MuiIconButton-label > .MuiSvgIcon-root")).click();
		WebElement verif = driver.findElement(By.xpath("/html/body/div[6]/div[3]/ul/li"));
		assertEquals(verif.getText(),"TestGroupe1");

	}
}
