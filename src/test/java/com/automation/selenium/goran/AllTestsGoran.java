package com.automation.selenium.goran;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.automation.selenium.Constantes;

public class AllTestsGoran {

	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.chrome();

	private static WebDriver driver = null;

	@BeforeClass
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
	public void testCTRF051TestConsulterMissionEnCoursDepuisLaCarte() throws InterruptedException {
		CTRF051_TestConsulterMissionEnCoursDepuisLaCarte.test(driver);
	}
	
	@Test
	public void testCTRF061TestCentrerLaCarte() throws InterruptedException {
		CTRF061_TestCentrerLaCarte.test(driver);
	}
	
	@Test
	public void testCTRF151TestVoirGenresIdentifies() throws InterruptedException {
		CTRF151_TestVoirGenresIdentifies.test(driver);
	}
	
	@Test
	public void testCTRF161TestVoirNombreIdentifications() throws InterruptedException {
		CTRF161_TestVoirNombreIdentificactions.test(driver);
	}
	
	@Test
	public void testCTRF201TestVoirSaPosition() throws InterruptedException {
		CTRF201_TestVoirSaPosition.test(driver);
	}
	
	@Test
	public void testCTRF241TestDifferencierReleves() throws InterruptedException {
		CTRF241_TestDifferencierReleves.test(driver);
	}
	
	@Test
	public void testCTRF251TestVoirReleveAutreUtilisateur() throws InterruptedException {
		CTRF251_TestVoirReleveAutreUtilisateur.test(driver);
	}

	@AfterClass
	public static void teardown() {
		driver.quit();
	}
	
}
