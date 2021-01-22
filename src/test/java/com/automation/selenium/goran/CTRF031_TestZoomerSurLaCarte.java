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

public class CTRF031_TestZoomerSurLaCarte {

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
		String style = driver.findElement(By.xpath(Constantes.XPATH_MAP_STYLE_SCALE)).getAttribute("style");
		String[] tbl = style.split(Constantes.REGEX_CTRF031);
		for (String string : tbl) {
			System.out.println(string);
		}
		int scale = Integer.valueOf(style.split(Constantes.REGEX_CTRF031)[1]);
		driver.findElement(By.xpath(Constantes.XPATH_MAP_BOUTON_ZOOM)).click();
		style = driver.findElement(By.xpath(Constantes.XPATH_MAP_STYLE_SCALE)).getAttribute("style");
		int scaleAfterZoom = Integer.valueOf(style.split(Constantes.REGEX_CTRF031)[1]);
		System.out.println(style.split(Constantes.REGEX_CTRF031)[1]);
		assertTrue((scale*2)==scaleAfterZoom);
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
}
