package com.automation.selenium.matheo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

/**
 * 
 * @author Oydrey
 * Classe qui permet de tester un test en particulier, il y a juste a changer le nom du test
 *
 */
public class TestMatheo {
	
	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.chrome();

	private WebDriver driver = null;

	@Before
	public void setup() throws MalformedURLException, InterruptedException {
		// Create a new instance of the driver
		driver = new RemoteWebDriver(new URL(Constantes.SELENIUM_SERVER_URL), CAPABILITY);

		// And now use this to open base url
		driver.navigate().to(Constantes.LOGIN_URL);

		// Ask to the driver to wait for 10s when an element is not found
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(785, 625));//ne pas envelle surper inportant pour me test
	}
		@Test
		public void test() throws InterruptedException {
	//CTRF101_TestSeDeconnecter.test(driver);
	//CTRF101_TestVoirMenu.test(driver);
	//CTRF1021_TestConsulterOngletFlore.test(driver);	
	//CTRF10211_TestConsulterLesDifferentsArbres.test(driver);
	//CTRF121_TestAccederScore.test(driver);
	//CTRF1272_TestGagnerUnTrophee.test(driver);
	//CTRF1281_TestVoirSonStatut.test(driver);
	//CTRF1291_TestVoirTousLesStatuts.test(driver);
	//CTRF131_TestAccederReleveBarreDeNavigation.test(driver);
	//CTRF1321_TestSupprimerUnReleve.test(driver);
	//CTRF1331_TestModifierPropositionInitialReleveMenu.test(driver);
	//CTRF211_TestVoirSonNomDansMenu.test(driver);
	//CTRF301_TestVoirSesReleves.test(driver);
	//CTRF1311_TestConsulterSesReleves.test(driver);
	//CTRF311_TestAjouterUnCommentaireSonReleve.test(driver);
	//CTRF313_AjoutePlusieursCommentaires.test(driver);
	//CTRF32_TestAnnulerunCommentairePasEncorePoste.test(driver);
		
	//CTRF312_TestAjouterCommentaireSurAutreReleve.test(driver);//HH
	//CTRF1341_TestAccederAuxLieuxCarte.test(driver);//HH
		
	}

	@After
	public void teardown() {
		driver.quit();
	}

}
