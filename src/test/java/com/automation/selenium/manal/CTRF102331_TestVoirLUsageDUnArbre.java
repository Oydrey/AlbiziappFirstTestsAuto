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

public class CTRF102331_TestVoirLUsageDUnArbre {
	
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
    driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
    Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[6]/div[3]/ul/div[1]")).click();
	driver.navigate().refresh();
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/input")).sendKeys("chene vert");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/div/div[1]")).click();
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div/div/button[2]/span[1]")).click();
    Thread.sleep(5000);
    String usageText = "L'écorce se caractérise par une forte richesse en tanins. Elle était récoltée pour la tannerie. Le chêne vert a été une source de bois de chauffage depuis l'Antiquité.\r\n"
    		+ "\r\n"
    		+ "Ses fuits, les glands, servent également de nourriture pour le bétail en élevage extensif.";
	assertEquals(usageText, driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/p[2]")).getText());
	
  }
}

