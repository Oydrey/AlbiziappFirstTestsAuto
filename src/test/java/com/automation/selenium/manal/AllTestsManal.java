package com.automation.selenium.manal;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
	
	@Test
	public void CTRF102311_TestVoirLesPhotos() throws InterruptedException {
		CTRF102311_TestVoirLesPhotos.test(driver);
	}
	
	@Test
	public void CTRF102312_TestNaviguerEntreLesPhotos() throws InterruptedException {
		CTRF102312_TestNaviguerEntreLesPhotos.test(driver);
	}
	
	@Test
	public void CTRF102331_TestVoirLUsageDUnArbre() throws InterruptedException {
		CTRF102331_TestVoirLUsageDUnArbre.test(driver);
	}
	
	@Test
	public void CTRF10231_TestConsulterUneEspeceDArbre() throws InterruptedException {
		CTRF10231_TestConsulterUneEspeceDArbre.test(driver);
	}
	
	@Test
	public void CTRF1211_TestVoirSesPointsDExploration() throws InterruptedException {
		CTRF1211_TestVoirSesPointsDExploration.test(driver);
	}
	
	@Test
	public void CTRF1251_TestVoirDetailDesPointsDeConnaissanceAcquis() throws InterruptedException {
		CTRF1251_TestVoirDetailDesPointsDeConnaissanceAcquis.test(driver);
	}
	
	@Test
	public void CTRF1261_TestVoirLaManièreDObtenirDesPointsDeConnaissance() throws InterruptedException {
		CTRF1261_TestVoirLaManièreDObtenirDesPointsDeConnaissance.test(driver);
	}
	
	@Test
	public void CTRF1271_TestVoirSonNombreDeTrophees() throws InterruptedException {
		CTRF1271_TestVoirSonNombreDeTrophees.test(driver);
	}
	
	@Test
	public void CTRF141_TestReprendreMissionEnCours() throws InterruptedException {
		CTRF141_TestReprendreMissionEnCours.test(driver);
	}
	
	@Test
	public void CTRF181_TestAccederAuxMissionsDepuisLeMenuPrincipal() throws InterruptedException {
		CTRF181_TestAccederAuxMissionsDepuisLeMenuPrincipal.test(driver);
	}
	
	@Test
	public void CTRF2611_TestVoirAvancementDeMissionEnCours() throws InterruptedException {
		CTRF2611_TestVoirAvancementDeMissionEnCours.test(driver);
	}
	//public void testCTRF2621_TestGriserUneMission() throws InterruptedException {    /!\ Problème avec ton test
	//	CTRF2621_TestGriserUneMission.test(driver);
	//}
	
	//public void CTRF271_TestNeRéaliserQuUneMissionALaFois() throws InterruptedException {  /!\ Problème avec ton test
	//	CTRF271_TestNeRéaliserQuUneMissionALaFois.test(driver);
	//}
	
	//public void testCTRND019_TestNotificationDisparaitQuandOnCliqueDessus() throws InterruptedException {  /!\  Ton test existe pas
	//	CTRND019_TestNotificationDisparaitQuandOnCliqueDessus.test(driver);
	//}
	public void CTRND013_TestRecevoirNotificationDeReleveConfirme() throws InterruptedException {
		CTRND013_TestRecevoirNotificationDeReleveConfirme.test(driver);
	}

	@After
	public void teardown() {
		driver.quit();
	}
	
}
