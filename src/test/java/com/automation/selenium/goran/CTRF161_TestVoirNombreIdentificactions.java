package com.automation.selenium.goran;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.automation.selenium.CommonMethods;

public class CTRF161_TestVoirNombreIdentificactions {

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
		driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[2]/button[4]/span/span[1]")).click();
		String text = driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[4]/button/div[2]/p")).getText();
		int nombreIdentificationAvantReleve = Integer.valueOf(text.split(" ")[3]);
		driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[2]/button[1]")).click();
		CommonMethods.testRenseignerReleveSurLaCarteAvecAjoutPhoto(driver);
		driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[2]/button[4]/span/span[1]")).click();
		text = driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[4]/button/div[2]/p")).getText();
		int nombreIdentificationApresReleve = Integer.valueOf(text.split(" ")[3]);
		assertTrue((nombreIdentificationAvantReleve + 1)==nombreIdentificationApresReleve);
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
}
