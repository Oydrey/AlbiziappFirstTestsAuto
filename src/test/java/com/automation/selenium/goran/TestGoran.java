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
import com.automation.selenium.Constantes;

/**
 * 
 * @author Oydrey
 * Classe qui permet de tester un test en particulier, il y a juste a changer le nom du test
 *
 */
public class TestGoran {
	
	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.chrome();

	private WebDriver driver = null;

	@Before
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
	public void test() throws InterruptedException {
		CTRF061_TestCentrerLaCarte.test(driver); 	//nom du test a changer : NomDeLaClasse.test(driver)
	}

	@After
	public void teardown() {
		driver.navigate().to(Constantes.URL_ALBIZIAPP_MAP);
		CommonMethods.SupprimerToutLesReleves(driver);
		driver.quit();
	}

}
