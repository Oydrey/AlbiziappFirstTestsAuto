package com.automation.selenium.manal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.automation.selenium.CommonMethods;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CTRF141_TestReprendreMissionEnCours {
	
	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_OYDREY_EMAIL, Constantes.LOGIN_OYDREY_PASSWORD);
		driver.manage().window().setSize(new Dimension(1050, 670));
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".MuiIconButton-label > .MuiSvgIcon-root")).click();
		Thread.sleep(2000);
		CommonMethods.testSeDeconnecter(driver);
	        CommonMethods.login(driver, Constantes.LOGIN_OYDREY_EMAIL, Constantes.LOGIN_OYDREY_PASSWORD);
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".MuiIconButton-label > .MuiSvgIcon-root")).click();
		Thread.sleep(5000);
	}
}
