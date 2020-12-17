package com.automation.selenium.salim;

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

public class CTRF291_TestAjouterReleveHorsLigne {

	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.chrome();

	private static final String SELENIUM_SERVER_URL = "http://127.0.0.1:4444/wd/hub";

	private static final String LOGIN_URL = "https://albiziapp.ozytis.fr/login";

	private WebDriver driver = null;

	@Before
	public void setup() throws MalformedURLException, InterruptedException {
		// Create a new instance of the driver
		driver = new RemoteWebDriver(new URL(SELENIUM_SERVER_URL), CAPABILITY);

		// And now use this to open base url
		driver.navigate().to(LOGIN_URL);

		// Ask to the driver to wait for 10s when an element is not found
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws InterruptedException {
		//impossible pour l'instant
		assertEquals("os", "kour");
	}

	@After
	public void teardown() {
		driver.quit();
	}

}
