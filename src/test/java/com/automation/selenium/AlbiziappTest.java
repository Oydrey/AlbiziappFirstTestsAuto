package com.automation.selenium;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AlbiziappTest {
	
	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.chrome();

	private static final String SELENIUM_SERVER_URL = "http://127.0.0.1:4444/wd/hub";

	private static final String LOGIN_URL = "https://albiziapp.ozytis.fr/login";
	
	private WebDriver mDriver = null;
	
	@Before
	public void setup() throws MalformedURLException, InterruptedException {
		// Create a new instance of the driver
		mDriver = new RemoteWebDriver(new URL(SELENIUM_SERVER_URL), CAPABILITY);
		
		// And now use this to open base url
		mDriver.navigate().to(LOGIN_URL);

		// Ask to the driver to wait for 3s when an element is not found
		mDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		mDriver.manage().window().maximize();
	}
	
	@Test
	public void testAuthentificationAvecIdentifiantsValides() throws InterruptedException {
		WebElement vSignInButton = mDriver.findElement(ByXPath.xpath("/html/body/div[1]/div/div/div/div/button"));
		vSignInButton.click();
		
		String mainWindow = mDriver.getWindowHandle();
		
		Set<String> windows = mDriver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		
		while(iterator.hasNext()) {
			String childWindow = iterator.next();
			
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				mDriver.switchTo().window(childWindow);
				
				WebElement emailField = mDriver.findElement(By.name("username"));
				emailField.sendKeys("tqlgroupe1@gmail.com");
				
				WebElement passwordField = mDriver.findElement(By.name("password"));
				passwordField.sendKeys("tqlgroupe1");
				
				//verif mail
				assertEquals("tqlgroupe1@gmail.com", emailField.getAttribute("value"));
				//verif password
				assertEquals("tqlgroupe1", passwordField.getAttribute("value"));
				
				WebElement vSignButton = mDriver.findElement(By.name("commit"));
				vSignButton.click();
				
				WebElement vAccordAccessButton = mDriver.findElement(ByXPath.xpath("/html/body/div/div[2]/div/form/input[5]"));
				vAccordAccessButton.click();
			}
		}
		
		mDriver.switchTo().window(mainWindow);
	}
	
	@Test
	public void testRenseignerReleveSurLaCarteAvecAjoutPhoto() throws InterruptedException {
		login();
		
		//clique sur la carte
		Thread.sleep(5000);		//nécessaire pour que le carte charge
		Actions builder = new Actions(mDriver);
		builder.moveToElement(mDriver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[1]")), 0, 0);
		builder.moveByOffset(100, 100).click().build().perform();
		
		//confirme creation de relevé
		WebElement vCreatePlan = mDriver.findElement(ByXPath.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]"));
		vCreatePlan.click();
		
		//renseigne les champs
		WebElement genreCommun = mDriver.findElement(By.id("commonGenusSelect"));
		WebElement genreLatin = mDriver.findElement(By.id("GenusSelect"));
		WebElement especeCommune = mDriver.findElement(By.id("commonSpeciesSelect"));
		WebElement especeLatine = mDriver.findElement(By.id("SpeciesSelect"));
		
		genreCommun.sendKeys("Albizzia" + Keys.DOWN + Keys.ENTER);
		genreLatin.sendKeys("Albizia" + Keys.DOWN + Keys.ENTER);
		especeCommune.sendKeys("Albizzia commun" + Keys.DOWN + Keys.ENTER);
		especeLatine.sendKeys("Albizia Julibrissin" + Keys.DOWN + Keys.ENTER);	
		
		WebElement confiant = mDriver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[5]/label[3]/span[1]"));
		confiant.click();
		
		/* Permet de cliquer sur l'appareil photo puis "Choisir une photo existante" *
		WebElement photo = mDriver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[6]/div/div/span"));
		photo.click();
		
		WebElement chosePicture = mDriver.findElement(ByXPath.xpath("/html/body/div[5]/div[3]/div/div/div/button[2]"));
		chosePicture.click();
		*/
		
		WebElement inputPicture = mDriver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[6]/div/div/input"));
		inputPicture.sendKeys("C:/Users/Oydrey/Pictures/toucan.jpg");
		
		//verification avant validation
		assertEquals("Albizzia", genreCommun.getAttribute("value"));
		assertEquals("Albizia", genreLatin.getAttribute("value"));
		assertEquals("Albizzia commun", especeCommune.getAttribute("value"));
		assertEquals("Albizia Julibrissin", especeLatine.getAttribute("value"));
		
		//validation
		WebElement valider = mDriver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/button[1]"));
		valider.click();
		
		WebElement confirmValider = mDriver.findElement(ByXPath.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]"));
		confirmValider.click();
	}
	
//	@Test
//	public void testDifferencierLesReleves() throws InterruptedException {
//		//TODO
//	}
	
	@After
	public void teardown() {
		mDriver.quit();
	}
	
	private void login() {
		WebElement vSignInButton = mDriver.findElement(ByXPath.xpath("/html/body/div[1]/div/div/div/div/button"));
		vSignInButton.click();
		
		String mainWindow = mDriver.getWindowHandle();
		
		Set<String> windows = mDriver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		
		while(iterator.hasNext()) {
			String childWindow = iterator.next();
			
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				mDriver.switchTo().window(childWindow);
				
				WebElement emailField = mDriver.findElement(By.name("username"));
				emailField.sendKeys("tqlgroupe1@gmail.com");
				
				WebElement passwordField = mDriver.findElement(By.name("password"));
				passwordField.sendKeys("tqlgroupe1");
				
				WebElement vSignButton = mDriver.findElement(By.name("commit"));
				vSignButton.click();
				
				WebElement vAccordAccessButton = mDriver.findElement(ByXPath.xpath("/html/body/div/div[2]/div/form/input[5]"));
				vAccordAccessButton.click();
			}
		}
		
		mDriver.switchTo().window(mainWindow);
	}

}
