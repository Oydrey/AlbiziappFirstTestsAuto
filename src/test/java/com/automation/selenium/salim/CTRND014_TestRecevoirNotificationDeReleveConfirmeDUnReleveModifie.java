package com.automation.selenium.salim;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRND014_TestRecevoirNotificationDeReleveConfirmeDUnReleveModifie {
	
	
	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);

		CommonMethods.testRenseignerReleveSurLaCarteAvecAjoutPhotoAvecHauteur2m5m(driver);

		new WebDriverWait(driver, 5).until(ExpectedConditions.urlMatches("https://albiziapp.ozytis.fr/map"));
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Constantes.XPATH_MAP_BOUTON_CENTRER)).click();

		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[1]")), 0, 0);
		builder.moveByOffset(200, 100).click().build().perform();
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div[2]/span/span")).click(); //clique sur le "1"
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/button[1]")).click(); //clique sur le bt modifier
		
		WebElement GenreCommun = driver.findElement(By.id(Constantes.ID_GENRE_COMMUN));
		WebElement GenreLatin = driver.findElement(By.id(Constantes.ID_GENRE_LATIN));
		WebElement EspeceCommune = driver.findElement(By.id(Constantes.ID_ESPECE_COMMUNE));
		WebElement EspeceLatine = driver.findElement(By.id(Constantes.ID_ESPECE_LATINE));
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

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/button[1]")).click();
		driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-textPrimary")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[1]")).click();

		builder.moveToElement(driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[1]")), 0, 0);
		builder.moveByOffset(200, 100).click().build().perform();

		assertEquals("Avocatier", driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/table/tbody/tr[2]/td[4]")).getText());
		assertEquals("Avocatier commun", driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/table/tbody/tr[2]/td[5]")).getText());

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div[1]/table/tbody/tr/td[2]")).click();
		
		assertEquals("Persea", driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/table/tbody/tr[2]/td[4]")).getText());
		assertEquals("Persea Americana", driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/table/tbody/tr[2]/td[5]")).getText());
	
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
		
		Thread.sleep(2000);
		
		CommonMethods.testSeDeconnecter(driver);
		
		CommonMethods.login(driver, Constantes.LOGIN_OYDREY_EMAIL, Constantes.LOGIN_OYDREY_PASSWORD);
		
		driver.findElement(By.xpath(Constantes.XPATH_MAP_BOUTON_CENTRER)).click();

		builder.moveToElement(driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[1]")), 0, 0);
		builder.moveByOffset(200, 100).click().build().perform();
			
		driver.findElement(By.xpath(Constantes.XPATH_RELEVE_BOUTON_CONFIRMER)).click(); //clique sur le bt confirmer
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/table/tbody/tr/td[3]")).click(); //clique sur moyen
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/table/tbody/tr[2]/td[6]")).click(); 
		
		driver.findElement(By.xpath(Constantes.XPATH_RELEVE_BOUTON_CONFIRMER)).click(); //clique sur le bt confirmer
		
		//Il manque la verification des notification
		
		
		Thread.sleep(2000);

		
		
	}

}
