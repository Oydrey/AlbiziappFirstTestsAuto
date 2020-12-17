package com.automation.selenium.salim;

import static org.junit.Assert.assertEquals;

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

public class CTRF102341_TestVoirHabitatArbre {

	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.chrome();

	private static final String SELENIUM_SERVER_URL = "http://127.0.0.1:4444/wd/hub";

	private static final String LOGIN_URL = "https://albiziapp.ozytis.fr/login";

	private WebDriver driver = null;

	private String email = "tqlgroupe1@gmail.com";

	private String password = "tqlgroupe1";

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
		CommonMethods.login(driver, email, password);	
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();//home
		driver.findElement(By.xpath("//span[contains(., 'Flore')]")).click();//flore
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/input")).sendKeys("chene vert");//recherche
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/div/div[1]")).click();//clique sur le chene vert	
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div/div/button[3]")).click();//habitat
		String habitatText = "Courant dans le sud de la France, il se d�veloppe dans les garrigues et les for�ts. Il est r�sistant � la chaleur, � la s�cheresse, au vent mais aussi au froid. Il pousse sans entretien � partir du moment qu?il se trouve au soleil. Il accepte tous les types de sols, m�me s?il a une pr�f�rence pour les sols calcaires, profonds et bien drain�s. Il s?enracine profond�ment pour subvenir � ses besoins en eau.";
		assertEquals(habitatText, driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/p[2]")).getText());
	}

	@After
	public void teardown() {
		driver.quit();
	}

}
