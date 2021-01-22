package com.automation.selenium.manal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF1271_TestVoirSonNombreDeTrophees {

	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		driver.manage().window().setSize(new Dimension(1050, 670));
		driver.findElement(By.cssSelector(".fa-trophy")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".MuiListItem-root:nth-child(3) .MuiListItemText-primary")).click();
		Thread.sleep(5000);
	}
}

