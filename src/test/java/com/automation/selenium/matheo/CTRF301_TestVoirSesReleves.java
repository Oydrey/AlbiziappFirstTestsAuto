package com.automation.selenium.matheo;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;

public class CTRF301_TestVoirSesReleves {
	
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
		FonctionMethods.login(driver,"toxav87996@onmail3.com" , "azertyuiop");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[1]")).click();
		// diver,x,y,commonGenusSelect,GenusSelect,commonSpeciesSelect,SpeciesSelect,niveuaxdeconfiant
		FonctionMethods.testRenseignerReleveSurLaCarteSansPhoto(driver,100,100,"Bibacier","Eriobotrya","Bibacier du Japon","Eriobotrya Japonica","Confiant");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]/div[1]/p")).click();
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]/div/span")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div/button[1]/span[1]")).isDisplayed());
		WebElement non = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]/div/p"));
		Assert.assertEquals(non.getText(),"duzahfiuazh");//verif le non de l'auteur du releve
		FonctionMethods.SuprimeReleve1ere(driver);
	}
}
