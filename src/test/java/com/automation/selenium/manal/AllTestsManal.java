package com.automation.selenium.manal;

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

public class AllTestsManal {

	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.chrome();

	private WebDriver driver = null;

	@BeforeClass
	public void setup() throws MalformedURLException, InterruptedException {
		// Create a new instance of the driver
		driver = new RemoteWebDriver(new URL(Constantes.SELENIUM_SERVER_URL), CAPABILITY);

		// And now use this to open base url
		driver.navigate().to(Constantes.LOGIN_URL);

		// Ask to the driver to wait for 10s when an element is not found
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void testCTRF10231TestConsulterUneEspeceDArbre() throws InterruptedException {
		CTRF10231_TestConsulterUneEspeceDArbre.test(driver);
	}
	
	@Test
	public void testCTRF102311TestVoirLesPhotos() throws InterruptedException {
		CTRF102311_TestVoirLesPhotos.test(driver);
	}
	
	//TODO Ajouter autres tests

	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
}
