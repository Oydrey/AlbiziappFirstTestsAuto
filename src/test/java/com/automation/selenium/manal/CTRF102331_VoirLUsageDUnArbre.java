package com.automation.selenium.manal;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automation.selenium.CommonMethods;

import java.net.MalformedURLException;
import java.net.URL;

public class CTRF102331_VoirLUsageDUnArbre {
	private WebDriver driver;
	private String email = "tqlgroupe1@gmail.com";
	private String password = "tqlgroupe1";
	
	@Before
	public void setUp() throws MalformedURLException {
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());

	}
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get("https://albiziapp.ozytis.fr/");
		CommonMethods.login(driver, email, password);
		driver.manage().window().setSize(new Dimension(1050, 670));
		driver.findElement(By.cssSelector(".MuiIconButton-label path")).click();
		driver.findElement(By.cssSelector(".MuiButtonBase-root:nth-child(2) .MuiTypography-root")).click();
		driver.findElement(By.cssSelector(".MuiInputBase-input")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".MuiInputBase-input")).sendKeys("chene vert");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".MuiListItemText-primary")).click();
		
		{
			WebElement element = driver.findElement(By.cssSelector(".MuiButtonBase-root:nth-child(2) > .MuiTab-wrapper"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		
		driver.findElement(By.cssSelector(".MuiButtonBase-root:nth-child(2) > .MuiTab-wrapper")).click();
		
		{
			WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element, 0, 0).perform();
		}
		
		Thread.sleep(5000);
	}
}

