package com.automation.selenium.manal;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.automation.selenium.Constantes;

public class AllTestsManal {

	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.chrome();

	private static WebDriver driver = null;

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
	
	//TODO Ajouter tests
	public void testCTRF10231x1Voirlesphotos() throws InterruptedException {
		CTRF10231x1Voirlesphotos.test(driver);
	}
	public void testCTRF10231x2Naviguerentrelesphotos() throws InterruptedException {
		CTRF10231x2Naviguerentrelesphotos.test(driver);
	}
	public void testCTRF10233x1Voirlusagedunarbre() throws InterruptedException {
		CTRF10233x1Voirlusagedunarbre.test(driver);
	}
	public void testCTRF1023x1Consulteruneespècedarbre() throws InterruptedException {
		CTRF1023x1Consulteruneespècedarbre.test(driver);
	}
	public void testCTRF121x1Voirsespointsdexploration() throws InterruptedException {
		CTRF121x1Voirsespointsdexploration.test(driver);
	}
	public void testCTRF1251Voirdétaildespointsdeconnaissanceacquis() throws InterruptedException {
		CTRF1251Voirdétaildespointsdeconnaissanceacquis.test(driver);
	}
	public void testCTRF1261Voirlamanièredobtenirdespointsdeconnaissance() throws InterruptedException {
		CTRF1261Voirlamanièredobtenirdespointsdeconnaissance.test(driver);
	}
	public void testCTRF127x1Voirsonnombredetrophées() throws InterruptedException {
		CTRF127x1Voirsonnombredetrophées.test(driver);
	}
	public void testCTRF14x1Reprendremissionencours() throws InterruptedException {
		CTRF14x1Reprendremissionencours.test(driver);
	}
	public void testCTRF18x1Accéderauxmissionsdepuislemenuprincipal() throws InterruptedException {
		CTRF18x1Accéderauxmissionsdepuislemenuprincipal.test(driver);
	}
	public void testCTRF261x1VoirAvancementDeMissionEnCours() throws InterruptedException {
		CTRF261x1VoirAvancementDeMissionEnCours.test(driver);
	}
	public void testCTRF2621_TestGriserUneMission() throws InterruptedException {
		CTRF2621_TestGriserUneMission.test(driver);
	}
	public void testCTRF271_TestNeRéaliserQuUneMissionALaFois() throws InterruptedException {
		CTRF271_TestNeRéaliserQuUneMissionALaFois.test(driver);
	}
	public void testCTRND019_TestNotificationDisparaitQuandOnCliqueDessus() throws InterruptedException {
		CTRND019_TestNotificationDisparaitQuandOnCliqueDessus.test(driver);
	}
	public void testCTRND01x3recevoirnotificationderelevéconfirmé () throws InterruptedException {
		CTRND01x3recevoirnotificationderelevéconfirmé.test(driver);
	}

	@After
	public void teardown() {
		driver.quit();
	}
	
}
