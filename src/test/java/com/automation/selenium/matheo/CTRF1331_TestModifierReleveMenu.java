package com.automation.selenium.matheo;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;

public class CTRF1331_TestModifierReleveMenu {
	
	private WebDriver driver;

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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://albiziapp.ozytis.fr/");
		driver.manage().window().setSize(new Dimension(785, 625));
		FonctionMethods.login(driver,"tqlgroupe1@gmail.com" , "tqlgroupe1");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();	  
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]/div[1]/p")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/button")).click();
		String vCurrentURL = driver.getCurrentUrl();
		assertTrue(vCurrentURL.matches("https://albiziapp.ozytis.fr/edit-observation/.*"));

	}
}
