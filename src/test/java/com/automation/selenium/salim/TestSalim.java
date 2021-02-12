package com.automation.selenium.salim;

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

/**
 * 
 * @author Salim
 * Classe qui lance tout mes tests
 *
 */
public class TestSalim {
	
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
	public void testCTRF091_TestRetourSurPage() throws InterruptedException {
		CTRF091_TestRetourSurPage.test(driver);
	}
	
	@Test
	public void testCTRF10231_TestConsulterEspeceArbre() throws InterruptedException {
		CTRF10231_TestConsulterEspeceArbre.test(driver);
	}
	
	@Test
	public void testCTRF102321_TestVoirLaDescription() throws InterruptedException {
		CTRF102321_TestVoirLaDescription.test(driver);
	}
	
	@Test
	public void testCTRF102341_TestVoirHabitatArbre() throws InterruptedException {
		CTRF102341_TestVoirHabitatArbre.test(driver);
	}
	
	@Test
	public void testCTRF1111_TestAccederCarteApresConnexion() throws InterruptedException {
		CTRF1111_TestAccederCarteApresConnexion.test(driver);
	}

	@AfterClass
	public static void teardown() {
		driver.quit();
	}

}
