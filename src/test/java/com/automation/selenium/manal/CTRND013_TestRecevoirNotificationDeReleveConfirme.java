package com.automation.selenium.manal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CTRND013_TestRecevoirNotificationDeReleveConfirme {

	public static void test(WebDriver driver) {
		driver.manage().window().setSize(new Dimension(1050, 670));
		driver.findElement(By.cssSelector(".MuiButtonBase-root:nth-child(1) > .MuiBottomNavigationAction-wrapper > .MuiSvgIcon-root")).click();
		driver.findElement(By.cssSelector(".jss31")).click();
		driver.findElement(By.cssSelector(".MuiButton-textPrimary > .MuiButton-label")).click();
		
		{
			WebElement element = driver.findElement(By.cssSelector(".MuiFormControl-root:nth-child(2) .MuiButtonBase-root:nth-child(2) .MuiSvgIcon-root"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		
		driver.findElement(By.cssSelector(".MuiFormControl-root:nth-child(2) .MuiButtonBase-root:nth-child(2) .MuiSvgIcon-root")).click();
		
		{
			WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element, 0, 0).perform();
		}
		
		driver.findElement(By.id("commonGenusSelect-option-0")).click();
		driver.findElement(By.id("GenusSelect")).click();
		driver.findElement(By.id("GenusSelect-option-0")).click();
		driver.findElement(By.id("commonSpeciesSelect")).click();
		driver.findElement(By.id("commonSpeciesSelect-option-3")).click();
		driver.findElement(By.id("SpeciesSelect")).click();
		driver.findElement(By.id("SpeciesSelect-option-3")).click();
		driver.findElement(By.name("mui-49925")).click();
		driver.findElement(By.cssSelector(".MuiButton-containedPrimary > .MuiButton-label")).click();
		
		{
			WebElement element = driver.findElement(By.cssSelector(".MuiButton-textPrimary > .MuiButton-label"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		
		driver.findElement(By.cssSelector(".MuiButton-textPrimary > .MuiButton-label")).click();
	}
}


