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

public class CTRF191_TestInterfaceNonVisibleHorsConnexion {
	
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
	public void test() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://albiziapp.ozytis.fr/");
		driver.manage().window().setSize(new Dimension(785, 625));
		String vCurrentURL = driver.getCurrentUrl();
		assertEquals(vCurrentURL,"https://albiziapp.ozytis.fr/login");
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div")).isDisplayed());
	}
}
