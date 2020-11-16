package com.automation.selenium;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AlbiziappTest {
	
	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.firefox();

	private static final String SELENIUM_SERVER_URL = "http://127.0.0.1:4444/wd/hub";

	private static final String BASIC_URL = "http://automationpractice.com/index.php";

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
		//TODO
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
