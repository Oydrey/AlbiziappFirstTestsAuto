package com.automation.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestsCommonMethods {
	
	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.chrome();

	private static WebDriver driver = null;
	
	@Before
	public static void setup() throws MalformedURLException, InterruptedException {
		// Create a new instance of the driver
		driver = new RemoteWebDriver(new URL(Constantes.SELENIUM_SERVER_URL), CAPABILITY);
		
		// And now use this to open base url
		driver.navigate().to(Constantes.LOGIN_URL);

		// Ask to the driver to wait for 3s when an element is not found
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testLogin() throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
	}	
	
	@Test
	public void testSeDeconnecter() throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		CommonMethods.testSeDeconnecter(driver);
	}
	
	@Test
	public void testReleveAjoutPhotoHauteurMoins2m() throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		CommonMethods.testRenseignerReleveSurLaCarteAvecAjoutPhotoAvecHauteurMoins2m(driver);
		CommonMethods.SuprimeReleve1ere(driver);
	}
	
	@Test
	public void testReleveAjoutPhotoHauteur2m5m() throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		CommonMethods.testRenseignerReleveSurLaCarteAvecAjoutPhotoAvecHauteur2m5m(driver);
		CommonMethods.SuprimeReleve1ere(driver);
	}
	
	@Test
	public void testReleveAjoutPhotoHauteur5m10m() throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		CommonMethods.testRenseignerReleveSurLaCarteAvecAjoutPhotoAvecHauteur5m10m(driver);
		CommonMethods.SuprimeReleve1ere(driver);
	}
	
	@Test
	public void testReleveAjoutPhotoHauteurPlus10m() throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		CommonMethods.testRenseignerReleveSurLaCarteAvecAjoutPhotoAvecHauteurPlus10m(driver);
		CommonMethods.SuprimeReleve1ere(driver);
	}
	
	@Test
	public void testReleveSansPhotoHauteurMoins2m() throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		CommonMethods.testRenseignerReleveSurLaCarteAvecHauteurMoins2m(driver);
		CommonMethods.SuprimeReleve1ere(driver);
	}
	
	@Test
	public void testReleveSansPhotoHauteur2m5m() throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		CommonMethods.testRenseignerReleveSurLaCarteAvecHauteur2m5m(driver);
		CommonMethods.SuprimeReleve1ere(driver);
	}
	
	@Test
	public void testReleveSansPhotoHauteur5m10m() throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		CommonMethods.testRenseignerReleveSurLaCarteAvecHauteur5m10m(driver);
		CommonMethods.SuprimeReleve1ere(driver);
	}
	
	@Test
	public void testReleveSansPhotoHauteurPlus10m() throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		CommonMethods.testRenseignerReleveSurLaCarteAvecHauteurPlus10m(driver);
		CommonMethods.SuprimeReleve1ere(driver);
	}
	
	@After
	public static void teardown() {
		driver.quit();
	}

}
