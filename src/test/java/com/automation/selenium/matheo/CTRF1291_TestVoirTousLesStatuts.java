package com.automation.selenium.matheo;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CTRF1291_TestVoirTousLesStatuts {
	
	private WebDriver driver;

	@Before
	public void setUp() throws MalformedURLException {
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), DesiredCapabilities.chrome());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://albiziapp.ozytis.fr/");
		driver.manage().window().setSize(new Dimension(1000, 744));
		FonctionMethods.login(driver,"tqlgroupe1@gmail.com" , "tqlgroupe1");
		driver.findElement(By.xpath("//div[@id=\'root\']/div/div[2]/button[3]/span/span")).click();
		WebElement nbstatut = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[4]/div[1]/p"));
		//regex pour recuper la valeur du nombre de titre 
		final String regex = ".*([\\d][\\d])";
		final String string = nbstatut.getText();
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher m = pattern.matcher(string);
		if (m.find()) System.out.println("nombre de titre (satute) :"+m.group(1));

		driver.findElement(By.xpath("//div[@id=\'root\']/div/div/ul/li[4]/div/span")).click();
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul")).isDisplayed());
		
		for (int i = 1 ; i < Integer.parseInt(m.group(1))+1; i++) { //on regarde si tout titre sont afficher
			assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li["+i+"]")).isDisplayed());
		}

	}
}
