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

public class CTRF051_TestConsulterMissionEnCoursDepuisLaCarte {

	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.chrome();

	private static final String SELENIUM_SERVER_URL = "http://127.0.0.1:4444/wd/hub";

	private static final String LOGIN_URL = "https://albiziapp.ozytis.fr/login";
	
	private WebDriver driver = null;
	
	private String email = "goran.sarr@gmail.com";
	
	private String password = "*Oxana36*";
	
	@Before
	public void setup() throws MalformedURLException, InterruptedException {
		// Create a new instance of the driver
		driver = new RemoteWebDriver(new URL(SELENIUM_SERVER_URL), CAPABILITY);
		
		// And now use this to open base url
		driver.navigate().to(LOGIN_URL);

		// Ask to the driver to wait for 3s when an element is not found
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws InterruptedException {
		CommonMethods.login(driver, email, password);
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]")).isDisplayed());
		String nomMission = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]")).getText();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[2]")).click();
		//verifier mission
		boolean isPresent = false;
		List <WebElement> parentElements = driver.findElements(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]//*"));
		for (WebElement element : parentElements) {
			if ((element.findElement(By.xpath(".//div/div/div[2]/h2")).getText()).equals(nomMission)) {
				isPresent = element.findElement(By.xpath(".//div/div/div[2]/div/div[1]/div")).isDisplayed();
			}
		}
		assertTrue(isPresent);
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
}
