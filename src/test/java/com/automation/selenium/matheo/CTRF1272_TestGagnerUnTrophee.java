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
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;

public class CTRF1272_TestGagnerUnTrophee {
	
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
		driver.findElement(By.cssSelector(".fa-trophy")).click();
		WebElement verif = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[3]/div[1]/p"));
		/*System.out.println("Printing " + verif.getText());
    String a = verif.getText();
    System.out.println("Printing " + a);
    if (a.equals("0 / 5")) {
    	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[1]")).click();
    	   //on fait la premiere mission (5 releves)
          	// diver,x,y,commonGenusSelect,GenusSelect,commonSpeciesSelect,SpeciesSelect,niveuaxdeconfiant
        	FonctionMethods.testRenseignerReleveSurLaCarteSansPhoto(driver,200,200,"Albizzia","Albizia","Albizzia commun","Albizia Julibrissin","Confiant");
        	FonctionMethods.testRenseignerReleveSurLaCarteSansPhoto(driver,500,500,"Albizzia","Albizia","Albizzia commun","Albizia Julibrissin","Confiant");
        	FonctionMethods.testRenseignerReleveSurLaCarteSansPhoto(driver,200,500,"Albizzia","Albizia","Albizzia commun","Albizia Julibrissin","Confiant");
        	FonctionMethods.testRenseignerReleveSurLaCarteSansPhoto(driver,500,200,"Albizzia","Albizia","Albizzia commun","Albizia Julibrissin","Confiant");
        	FonctionMethods.testRenseignerReleveSurLaCarteSansPhoto(driver,100,100,"Albizzia","Albizia","Albizzia commun","Albizia Julibrissin","Confiant");

	}*/
		driver.findElement(By.cssSelector(".fa-trophy")).click();
		WebElement verif2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[3]/div[1]/p"));
		assertTrue(verif2.getText().matches("([1-5]) / 5"));
		/*//on supprime les 5 releves
    if (a.equals("0 / 5")) {
    FonctionMethods.SuprimeReleve1ere(driver);
    FonctionMethods.SuprimeReleve1ere(driver);
    FonctionMethods.SuprimeReleve1ere(driver);
    FonctionMethods.SuprimeReleve1ere(driver);
    FonctionMethods.SuprimeReleve1ere(driver);
    }*/
	}
}
