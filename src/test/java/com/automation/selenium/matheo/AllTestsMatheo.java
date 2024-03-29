package com.automation.selenium.matheo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.automation.selenium.Constantes;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AllTestsMatheo {

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
	//ici les AAAA c'est pur qu'il fait toujour en primere
	//ici c est un clean
	@Test
	public void AAAAclean() throws InterruptedException {
		NO_test_JUSTE_clean.test(driver);
	}
		
	
	@Test
	public void testCTRF101TestSeDeconnecter() throws InterruptedException {
		CTRF101_TestSeDeconnecter.test(driver);
	}
	
	@Test
	public void testCTRF101TestVoirMenu() throws InterruptedException {
		CTRF101_TestVoirMenu.test(driver);
	}
	
	@Test
	public void testCTRF1021TestConsulterOngletFlore() throws InterruptedException {
		CTRF1021_TestConsulterOngletFlore.test(driver);
	}
	
	@Test
	public void testCTRF10211TestConsulterLesDifferentsArbres() throws InterruptedException {
		CTRF10211_TestConsulterLesDifferentsArbres.test(driver);
	}
	
	@Test
	public void testCTRF121TestAccederScore() throws InterruptedException {
		CTRF121_TestAccederScore.test(driver);
	}
			
	@Test
	public void testCTRF1272TestGagnerUnTrophee() throws InterruptedException {
		CTRF1272_TestGagnerUnTrophee.test(driver);
	}
	
	@Test
	public void testCTRF1281TestVoirSonStatut() throws InterruptedException {
		CTRF1281_TestVoirSonStatut.test(driver);
	}
	
	@Test
	public void testCTRF1291TestVoirTousLesStatus() throws InterruptedException {
		CTRF1291_TestVoirTousLesStatuts.test(driver);
	}
	
	@Test
	public void testCTRF131TestAccederReleveBarreDeNavigation() throws InterruptedException {
		CTRF131_TestAccederReleveBarreDeNavigation.test(driver);
	}
	
	@Test
	public void testCTRF1321TestSupprimerUnReleve() throws InterruptedException {
		CTRF1321_TestSupprimerUnReleve.test(driver);
	}

	
	@Test
	public void testCTRF1331TestModifierPropositionInitialeReleveMenu() throws InterruptedException {
		CTRF1331_TestModifierPropositionInitialReleveMenu.test(driver);
	}
	
	@Test
	public void testCTRF211TestVoirSonNomDansMenu() throws InterruptedException {
		CTRF211_TestVoirSonNomDansMenu.test(driver);
	}
	
	@Test
	public void testCTRF301TestVoirSesReleves() throws InterruptedException {
		CTRF301_TestVoirSesReleves.test(driver);
	}
	
	@Test
	public void testCTRF1311TestConsulterSesReleves() throws InterruptedException {
		CTRF1311_TestConsulterSesReleves.test(driver);
	}
	
	@Test
	public void testCTRF311TestAjouterUnCommentaireSonReleve() throws InterruptedException {
		CTRF311_TestAjouterUnCommentaireSonReleve.test(driver);
	}
	
	@Test
	public void testCTRF313TestAjoutePlusieursCommentaires() throws InterruptedException {
		CTRF313_AjoutePlusieursCommentaires.test(driver);
	}
	
	@Test
	public void testCTRF32TestAnnulerUnCommentairePasEncorePoste() throws InterruptedException {
		CTRF32_TestAnnulerunCommentairePasEncorePoste.test(driver);
	}
	
	@Test
	public void testCTRF1351TestSuprimerPropositionInitialReleveMenu() throws InterruptedException {
		CTRF1351_TestSuprimerPropositionInitialReleveMenu.test(driver);
	}
	
	@Test
	public void testCTRF1231VoirManuereObtenirPointExploration() throws InterruptedException {
		CTRF1231_VoirManuereObtenirPointExploration.test(driver);
	}
	
	/*
	@Test
	public void testCTRF312TestAjouterCommentaireSurAutreReleve() throws InterruptedException {
		CTRF312_TestAjouterCommentaireSurAutreReleve.test(driver);
	}
	
	@Test
	public void testCTRF1341TestAccederAuxLieuxCarte() throws InterruptedException {
		CTRF1341_TestAccederAuxLieuxCarte.test(driver);
	}
	*/
	//ici les zzzz c'est pur qu'il fait toujour en dernier
	//ici c est un clean
	@Test
	public void zzzzclean() throws InterruptedException {
		NO_test_JUSTE_clean.test(driver);
	}
	@After
	public void teardown() {
		driver.quit();
	}
	
}
