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

import com.automation.selenium.CommonMethods;

public class Goran {
	
	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.chrome();

	private static final String SELENIUM_SERVER_URL = "http://127.0.0.1:4444/wd/hub";

	private static final String LOGIN_URL = "https://albiziapp.ozytis.fr/login";
	
	private WebDriver mDriver = null;
	
	private String email = "tqlgroupe1@gmail.com";
	
	private String password = "tqlgroupe1";
	
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
	public void test() throws InterruptedException {
		CommonMethods.login(mDriver, email, password);
		CommonMethods.testRenseignerReleveSurLaCarteAvecAjoutPhoto(mDriver);
	}
	
	@After
	public void teardown() {
		mDriver.quit();
	}
	
}
