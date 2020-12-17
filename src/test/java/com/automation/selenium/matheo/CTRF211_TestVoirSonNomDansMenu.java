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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;

public class CTRF211_TestVoirSonNomDansMenu {
	
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
		FonctionMethods.login(driver,"tqlgroupe1@gmail.com" , "tqlgroupe1");
		driver.manage().window().setSize(new Dimension(785, 625));
		//driver.navigate.refresh
		((JavascriptExecutor)driver).executeScript("document.location.reload()");
		driver.findElement(By.cssSelector(".MuiIconButton-label > .MuiSvgIcon-root")).click();
		WebElement verif = driver.findElement(By.xpath("/html/body/div[6]/div[3]/ul/li"));
		assertEquals(verif.getText(),"TestGroupe1");

	}
}