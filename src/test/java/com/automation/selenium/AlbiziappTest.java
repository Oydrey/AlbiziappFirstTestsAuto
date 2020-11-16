package com.automation.selenium;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AlbiziappTest {
	
	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.firefox();

	private static final String SELENIUM_SERVER_URL = "http://127.0.0.1:4444/wd/hub";

	private static final String BASIC_URL = "https://albiziapp.ozytis.fr/login";

	private static final String URL_SIGN_IN_OPENSTREETMAP = "https://www.openstreetmap.org/login?referer=%2Foauth%2Fauthorize%3Foauth_callback%3Dhttps%253A%252F%252Falbiziapp.ozytis.fr%252Fland.html%26oauth_token%3D0nrJlycjIuDiMutGhcFz3k4B1eyxzEXOT3ULTzD7";
	
	private WebDriver mDriver = null;
	
	@Before
	public void setup() throws MalformedURLException, InterruptedException {
		// Create a new instance of the driver
		mDriver = new RemoteWebDriver(new URL(SELENIUM_SERVER_URL), CAPABILITY);

		// And now use this to open base url
		mDriver.navigate().to(BASIC_URL);

		// Ask to the driver to wait for 3s when an element is not found
		mDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		mDriver.manage().window().maximize();
	}
	
	@Test
	public void testAuthentificationAvecIdentifiantsValides() throws InterruptedException {
		//Cliquer bouton Sign In
		WebElement vSignInButton = mDriver.findElement(ByXPath.xpath("/html/body/div[1]/div/div/div/div/button"));
		vSignInButton.click();
		
		mDriver.navigate().to(URL_SIGN_IN_OPENSTREETMAP);
		
		Thread.sleep(2000);
		
		//Remplir champ email
		WebElement emailField = mDriver.findElement(By.name("username"));
		emailField.sendKeys("tqlgroupe1@gmail.com");
		
		Thread.sleep(2000);
		
		//Remplir champ mdp
		WebElement passwordField = mDriver.findElement(By.name("password"));
		passwordField.sendKeys("tqlgroupe1");
		
		Thread.sleep(2000);
		
		//Cliquer bouton Sign In
		WebElement vSignButton = mDriver.findElement(By.name("commit"));
		vSignButton.click();
				
		Thread.sleep(5000);
		
		WebElement vAccordAccessButton = mDriver.findElement(ByXPath.xpath("/html/body/div/div[2]/div/form/input[5]"));
		vAccordAccessButton.click();
		
		Thread.sleep(2000);
	}
	
	@Test
	public void testRenseignerReleveSurLaCarteAvecAjoutPhoto() throws InterruptedException {
		//TODO
	}
	
	@Test
	public void testDifferencierLesReleves() throws InterruptedException {
		//TODO
	}
	
	@After
	public void teardown() {
		mDriver.quit();
	}

}
