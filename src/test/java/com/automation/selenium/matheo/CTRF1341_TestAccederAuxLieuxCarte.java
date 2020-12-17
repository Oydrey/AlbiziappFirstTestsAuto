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
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.MalformedURLException;
import java.net.URL;

public class CTRF1341_TestAccederAuxLieuxCarte {
	
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
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://albiziapp.ozytis.fr/");
		driver.manage().window().setSize(new Dimension(785, 625));
		FonctionMethods.login(driver,"tqlgroupe1@gmail.com" , "tqlgroupe1");
		
		for (int i = 1 ; i < 3; i++) {
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();	
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li["+i+"]/div[1]/p")).click();
			//regex pour recuper l'id du releve dan l'url 
			final String regex = "https://albiziapp.ozytis.fr/observation/(.*)";
			final String string = driver.getCurrentUrl();
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher m = pattern.matcher(string);
			if (m.find()) System.out.println("id oservation (releve) :"+m.group(1));
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/button")).click();
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[1]")), 0, 0).click();
			builder.moveByOffset(1,1).click().build().perform();
			assertEquals("https://albiziapp.ozytis.fr/observation/"+m.group(1),driver.getCurrentUrl());
		}
	}
}
