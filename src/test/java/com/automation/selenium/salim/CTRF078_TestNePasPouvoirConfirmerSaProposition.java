package com.automation.selenium.salim;

import static org.junit.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF078_TestNePasPouvoirConfirmerSaProposition {

	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		
		CommonMethods.testRenseignerReleveSurLaCarteAvecAjoutPhotoAvecHauteur2m5m(driver);

		new WebDriverWait(driver, 5).until(ExpectedConditions.urlMatches("https://albiziapp.ozytis.fr/map"));
		
		CommonMethods.testSeDeconnecter(driver);
		
		CommonMethods.login(driver, Constantes.LOGIN_OYDREY_EMAIL, Constantes.LOGIN_OYDREY_PASSWORD);
		
		driver.findElement(By.xpath(Constantes.XPATH_MAP_BOUTON_CENTRER)).click();
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[1]")), 0, 0);
		builder.moveByOffset(200, 100).click().build().perform();
		
		driver.findElement(By.xpath(Constantes.XPATH_RELEVE_BOUTON_PROPOSITION)).click();
				
		WebElement GenreCommun = driver.findElement(By.id(Constantes.ID_GENRE_COMMUN));
		WebElement GenreLatin = driver.findElement(By.id("GenusSelect"));
		WebElement EspeceCommune = driver.findElement(By.id("commonSpeciesSelect"));
		WebElement EspeceLatine = driver.findElement(By.id("SpeciesSelect"));
		EspeceLatine.click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[4]/div/div/div/div/button[1]")).click();
		EspeceCommune.click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div/div/div/div/button[1]")).click();
		GenreLatin.click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div/div/div/div/button[1]")).click();
		GenreCommun.click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div/div/div/button[1]")).click();

		GenreCommun.sendKeys("Avocatier");
		driver.findElement(By.cssSelector(".MuiAutocomplete-popper")).click();
		GenreLatin.sendKeys("Persea");
		driver.findElement(By.cssSelector(".MuiAutocomplete-popper")).click();
		EspeceCommune.sendKeys("Avocatier commun");
		driver.findElement(By.cssSelector(".MuiAutocomplete-popper")).click();
		EspeceLatine.sendKeys("Persea Americana");
		driver.findElement(By.cssSelector(".MuiAutocomplete-popper")).click();
		
		driver.findElement(By.xpath(Constantes.XPATH_RELEVE_BOUTON_VALIDER)).click();
		
		//C'est cassé
		
		assertFalse(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/button")).isDisplayed());
		
	}

}
