package com.automation.selenium.manal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF102311_TestVoirLesPhotos {
	
	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		driver.manage().window().setSize(new Dimension(1050, 670));
		driver.findElement(By.cssSelector(".MuiIconButton-label path")).click();
		driver.findElement(By.cssSelector(".MuiButtonBase-root:nth-child(2) > .MuiListItemIcon-root")).click();
		driver.findElement(By.cssSelector(".MuiInputBase-input")).click();
		driver.findElement(By.cssSelector(".MuiInputBase-input")).sendKeys("chene vert");
		driver.findElement(By.cssSelector(".MuiListItemText-primary")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".material-icons:nth-child(2)")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".material-icons:nth-child(3)")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".material-icons:nth-child(4)")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".material-icons:nth-child(5)")).click();
	}
	
}

