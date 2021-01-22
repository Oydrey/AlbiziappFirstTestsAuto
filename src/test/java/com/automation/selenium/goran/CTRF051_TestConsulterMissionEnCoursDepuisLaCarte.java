package com.automation.selenium.goran;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF051_TestConsulterMissionEnCoursDepuisLaCarte {

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
		assertTrue(driver.findElement(By.xpath(Constantes.XPATH_MAP_MISSION_EN_COURS)).isDisplayed());
		String nomMission = driver.findElement(By.xpath(Constantes.XPATH_MAP_MISSION_EN_COURS)).getText();
		driver.findElement(By.xpath(Constantes.XPATH_MENU_BAS_MISSION_BOUTON)).click();
		//verifier mission
		boolean isPresent = false;
		List <WebElement> parentElements = driver.findElements(ByXPath.xpath(Constantes.XPATH_MISSIONS_LISTE_MISSIONS));
		for (WebElement element : parentElements) {
			if ((element.findElement(By.xpath(Constantes.XPATH_lISTE_MISSIONS_NOM_MISSION_SELECT)).getText()).equals(nomMission)) {
				isPresent = element.findElement(By.xpath(Constantes.XPATH_LISTE_MISSIONS_BARRE_PROGRESSION_MISSION_SELECT)).isDisplayed();
			}
		}
		assertTrue(isPresent);
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
}
