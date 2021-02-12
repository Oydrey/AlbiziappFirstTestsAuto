package com.automation.selenium.goran;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.automation.selenium.Constantes;

public class AllTestsGoran {

	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.chrome();

	private static WebDriver driver = null;

	@Before
	public static void setup() throws MalformedURLException, InterruptedException {
		// Create a new instance of the driver
		driver = new RemoteWebDriver(new URL(Constantes.SELENIUM_SERVER_URL), CAPABILITY);

		// And now use this to open base url
		driver.navigate().to(Constantes.LOGIN_URL);

		// Ask to the driver to wait for 10s when an element is not found
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void testCTRF031TestZoomerSurLaCarte() throws InterruptedException {
		CTRF031_TestZoomerSurLaCarte.test(driver);
	}
	
	@Test
	public void testCTRF041TestDezoomerSurLaCarte() throws InterruptedException {
		CTRF041_TestDezoomerSurLaCarte.test(driver);
	}
	
	@Test
	public void testCTRF061TestCentrerLaCarte() throws InterruptedException {
		CTRF061_TestCentrerLaCarte.test(driver);
	}
	
	@Test
	public void testCTRF201TestVoirSaPosition() throws InterruptedException {
		CTRF201_TestVoirSaPosition.test(driver);
	}

	@After
	public static void teardown() {
		driver.quit();
	}
	
}
