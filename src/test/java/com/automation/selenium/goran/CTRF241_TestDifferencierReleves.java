package com.automation.selenium.goran;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;
import com.automation.selenium.matheo.FonctionMethods;

public class CTRF241_TestDifferencierReleves {

	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.chrome();
	
	private WebDriver driver = null;
	
	@Before
	public void setup() throws MalformedURLException, InterruptedException {
		// Create a new instance of the driver
		driver = new RemoteWebDriver(new URL(Constantes.SELENIUM_SERVER_URL), CAPABILITY);
		
		// And now use this to open base url
		driver.navigate().to(Constantes.LOGIN_URL);

		// Ask to the driver to wait for 3s when an element is not found
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_OYDREY_EMAIL, Constantes.LOGIN_OYDREY_PASSWORD); 
		CommonMethods.testRenseignerReleveSurLaCarteAvecHauteur2m5m(driver);
		String color = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_MAP_DERNIER_RELEVE)).getAttribute("fill-opacity");
		CommonMethods.testSeDeconnecter(driver);
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		String colorDernierReleve = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_MAP_DERNIER_RELEVE)).getAttribute("fill-opacity");
		assertTrue(color.equals("0.5"));
		assertTrue(colorDernierReleve.equals("0"));
		CommonMethods.testSeDeconnecter(driver);
		CommonMethods.login(driver, Constantes.LOGIN_OYDREY_EMAIL, Constantes.LOGIN_OYDREY_PASSWORD); 
		FonctionMethods.SuprimeReleve1ere(driver);
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
}
