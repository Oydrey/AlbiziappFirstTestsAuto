package com.automation.selenium.manal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CTRF141_TestReprendreMissionEnCours {
	
	public static void test(WebDriver driver) {
		driver.manage().window().setSize(new Dimension(1050, 670));
		driver.findElement(By.cssSelector(".MuiIconButton-label path")).click();
		
		{
			WebElement element = driver.findElement(By.cssSelector(".MuiIconButton-label path"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		
		{
			WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element, 0, 0).perform();
		}
		
		driver.findElement(By.cssSelector(".MuiButtonBase-root:nth-child(2) > .MuiListItemIcon-root")).click();
		driver.findElement(By.cssSelector(".MuiInputBase-input")).click();
		driver.findElement(By.cssSelector(".MuiInputBase-input")).sendKeys("ulex");
		driver.findElement(By.cssSelector(".MuiListItemText-primary")).click();
		driver.findElement(By.cssSelector(".material-icons:nth-child(2)")).click();
		driver.findElement(By.cssSelector(".material-icons:nth-child(3)")).click();
		driver.findElement(By.cssSelector(".material-icons:nth-child(4)")).click();
		driver.findElement(By.cssSelector(".material-icons:nth-child(5)")).click();
	}
}