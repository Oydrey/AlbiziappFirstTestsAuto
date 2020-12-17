package com.automation.selenium.manal;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By.ByXPath;

import com.automation.selenium.CommonMethods;

import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;

public class CTRF2611_TestVoirAvancementDeMissionEnCours {
	
	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.chrome();

	private static final String SELENIUM_SERVER_URL = "http://127.0.0.1:4444/wd/hub";

	private static final String LOGIN_URL = "https://albiziapp.ozytis.fr/login";

	private WebDriver driver = null;

	private String email = "tqlgroupe1@gmail.com";

	private String password = "tqlgroupe1";
	
	@Before
	public void setUp() throws MalformedURLException {

		// Create a new instance of the driver
		driver = new RemoteWebDriver(new URL(SELENIUM_SERVER_URL), CAPABILITY);

		// And now use this to open base url
		driver.navigate().to(LOGIN_URL);

		// Ask to the driver to wait for 3s when an element is not found
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void test() {
		CommonMethods.login(driver, email, password);
		driver.findElement((ByXPath.xpath("//*[@id=\"root\"]/div/div[2]/button[2]/span/svg/path"))).click();
	}
}



