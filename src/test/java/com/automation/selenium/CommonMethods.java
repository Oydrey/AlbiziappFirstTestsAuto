package com.automation.selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

	public static void login(WebDriver driver, String email, String password) throws InterruptedException {
		
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		driver.switchTo().window(iterator.next());
		String mainWindow = driver.getWindowHandle();
		
		//Juste pour moi faite pas attention - Salim
		if(iterator.hasNext())
		{
			driver.switchTo().window(iterator.next());
			driver.close();
			driver.switchTo().window(mainWindow);
		}
		//fin			
		
		WebElement vSignInButton = driver.findElement(ByXPath.xpath(Constantes.XPATH_LOGIN_SIGN_IN_BOUTON));
		vSignInButton.click();	
		
		windows = driver.getWindowHandles();
		iterator = windows.iterator();
		
		while(iterator.hasNext()) {
			String childWindow = iterator.next();
			
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				
				WebElement emailField = driver.findElement(By.name(Constantes.NAME_LOGIN_EMAIL_FIELD));
				emailField.sendKeys(email);
				
				WebElement passwordField = driver.findElement(By.name(Constantes.NAME_LOGIN_PASSWORD_FIELD));
				passwordField.sendKeys(password);
				
				WebElement vSignButton = driver.findElement(By.name(Constantes.NAME_LOGIN_COMMIT_BOUTON));
				vSignButton.click();
				
				WebElement vAccordAccessButton = driver.findElement(ByXPath.xpath(Constantes.XPATH_LOGIN_ACCORD_ACCESS_BOUTON));
				Thread.sleep(2000);
				vAccordAccessButton.click();
			}
		}
		
		driver.switchTo().window(mainWindow);
		new WebDriverWait(driver, 5).until(ExpectedConditions.urlMatches(Constantes.URL_ALBIZIAPP_MAP));

		
	}
	
	public static void testSeDeconnecter(WebDriver driver) {
		driver.findElement(By.xpath(Constantes.XPATH_MENU_BOUTON_FEUILLE)).click();
		driver.findElement(By.xpath(Constantes.XPATH_MENU_DECONNEXION_BOUTON)).click();
		
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		driver.switchTo().window(iterator.next());
		
		//Juste pour moi faite pas attention - Salim
		if(iterator.hasNext())
		{
			driver.switchTo().window(iterator.next());
			driver.close();
			driver.switchTo().window(mainWindow);
		}
		//fin			
		
		WebElement vSignInButton = driver.findElement(ByXPath.xpath(Constantes.XPATH_LOGIN_SIGN_IN_BOUTON));
		vSignInButton.click();	
		
		windows = driver.getWindowHandles();
		iterator = windows.iterator();
		
		while(iterator.hasNext()) {
			String childWindow = iterator.next();
			
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				
				driver.findElement(By.xpath(Constantes.XPATH_OSM_MENU_ICONE)).click();
				driver.findElement(By.xpath(Constantes.XPATH_OSM_MENU_PROFIL_BOUTON)).click();
				driver.findElement(By.xpath(Constantes.XPATH_OSM_SE_DECONNECTER_BOUTON)).click();
				driver.close();
				
			}
		}
		
		driver.switchTo().window(mainWindow);
	}
	
	public static void testRenseignerReleveSurLaCarteAvecAjoutPhotoAvecHauteurMoins2m(WebDriver driver) throws InterruptedException {		
		
		driver.findElement(By.xpath(Constantes.XPATH_MAP_BOUTON_CENTRER)).click();
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(ByXPath.xpath(Constantes.XPATH_MAP)), 0, 0);
		builder.moveByOffset(200, 100).click().build().perform();
		
		WebElement vCreatePlan = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_MAP_CLICK_ON_MAP));

		vCreatePlan.click();
		
		WebElement genreCommun = driver.findElement(By.id(Constantes.ID_GENRE_COMMUN));
		
		genreCommun.sendKeys("Albizzia" + Keys.DOWN + Keys.ENTER);
		//genre latin & espece commune & espece latine selectionnes auto
		
		driver.findElement(ByXPath.xpath(Constantes.XPATH_HAUTEUR_MOINS_2M)).click();
		
		WebElement inputPicture = driver.findElement(ByXPath.xpath(Constantes.XPATH_RELEVE_PHOTO_INPUT));
		inputPicture.sendKeys("C:\\Image\\5.jpg");

		WebElement valider = driver.findElement(ByXPath.xpath(Constantes.XPATH_RELEVE_BOUTON_VALIDER));
		valider.click();
		
		Thread.sleep(2000);
		
		WebElement confirmValider = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_RELEVE_BOUTON_CONFIMER_VALIDATION));
		confirmValider.click();
	}
	
	public static void testRenseignerReleveSurLaCarteAvecAjoutPhotoAvecHauteur2m5m(WebDriver driver) throws InterruptedException {		
		
		driver.findElement(By.xpath(Constantes.XPATH_MAP_BOUTON_CENTRER)).click();
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(ByXPath.xpath(Constantes.XPATH_MAP)), 0, 0);
		builder.moveByOffset(200, 100).click().build().perform();
		
		WebElement vCreatePlan = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_MAP_CLICK_ON_MAP));

		vCreatePlan.click();
		
		WebElement genreCommun = driver.findElement(By.id(Constantes.ID_GENRE_COMMUN));
		
		genreCommun.sendKeys("Albizzia" + Keys.DOWN + Keys.ENTER);
		//genre latin & espece commune & espece latine selectionnes auto
		
		driver.findElement(ByXPath.xpath(Constantes.XPATH_HAUTEUR_2M_5M)).click();
		
		WebElement inputPicture = driver.findElement(ByXPath.xpath(Constantes.XPATH_RELEVE_PHOTO_INPUT));
		inputPicture.sendKeys("C:\\Image\\5.jpg");

		WebElement valider = driver.findElement(ByXPath.xpath(Constantes.XPATH_RELEVE_BOUTON_VALIDER));
		valider.click();
		
		Thread.sleep(2000);
		
		WebElement confirmValider = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_RELEVE_BOUTON_CONFIMER_VALIDATION));
		confirmValider.click();
	}
	
	public static void testRenseignerReleveSurLaCarteAvecAjoutPhotoAvecHauteur5m10m(WebDriver driver) throws InterruptedException {		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(ByXPath.xpath(Constantes.XPATH_MAP)), 0, 0);
		builder.moveByOffset(200, 100).click().build().perform();
		
		WebElement vCreatePlan = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_MAP_CLICK_ON_MAP));

		vCreatePlan.click();
		
		WebElement genreCommun = driver.findElement(By.id(Constantes.ID_GENRE_COMMUN));
		
		genreCommun.sendKeys("Albizzia" + Keys.DOWN + Keys.ENTER);
		//genre latin & espece commune & espece latine selectionnes auto
		
		driver.findElement(ByXPath.xpath(Constantes.XPATH_HAUTEUR_5M_10M)).click();
		
		WebElement inputPicture = driver.findElement(ByXPath.xpath(Constantes.XPATH_RELEVE_PHOTO_INPUT));
		inputPicture.sendKeys("C:\\Image\\5.jpg");

		WebElement valider = driver.findElement(ByXPath.xpath(Constantes.XPATH_RELEVE_BOUTON_VALIDER));
		valider.click();
		
		Thread.sleep(2000);
		
		WebElement confirmValider = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_RELEVE_BOUTON_CONFIMER_VALIDATION));
		confirmValider.click();
	}
	
	public static void testRenseignerReleveSurLaCarteAvecAjoutPhotoAvecHauteurPlus10m(WebDriver driver) throws InterruptedException {	
		
		driver.findElement(By.xpath(Constantes.XPATH_MAP_BOUTON_CENTRER)).click();
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(ByXPath.xpath(Constantes.XPATH_MAP)), 0, 0);
		builder.moveByOffset(200, 100).click().build().perform();
		
		WebElement vCreatePlan = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_MAP_CLICK_ON_MAP));

		vCreatePlan.click();
		
		WebElement genreCommun = driver.findElement(By.id(Constantes.ID_GENRE_COMMUN));
		
		genreCommun.sendKeys("Albizzia" + Keys.DOWN + Keys.ENTER);
		//genre latin & espece commune & espece latine selectionnes auto
		
		driver.findElement(ByXPath.xpath(Constantes.XPATH_HAUTEUR_PLUS_10M)).click();
		
		WebElement inputPicture = driver.findElement(ByXPath.xpath(Constantes.XPATH_RELEVE_PHOTO_INPUT));
		inputPicture.sendKeys("C:\\Image\\5.jpg");

		WebElement valider = driver.findElement(ByXPath.xpath(Constantes.XPATH_RELEVE_BOUTON_VALIDER));
		valider.click();
		
		Thread.sleep(2000);
		
		WebElement confirmValider = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_RELEVE_BOUTON_CONFIMER_VALIDATION));
		confirmValider.click();
	}
	
	public static void testRenseignerReleveSurLaCarteAvecHauteurMoins2m(WebDriver driver) throws InterruptedException {		
		
		driver.findElement(By.xpath(Constantes.XPATH_MAP_BOUTON_CENTRER)).click();
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(ByXPath.xpath(Constantes.XPATH_MAP)), 0, 0);
		builder.moveByOffset(200, 100).click().build().perform();
		
		WebElement vCreatePlan = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_MAP_CLICK_ON_MAP));

		vCreatePlan.click();
		
		WebElement genreCommun = driver.findElement(By.id(Constantes.ID_GENRE_COMMUN));
		
		genreCommun.sendKeys("Albizzia" + Keys.DOWN + Keys.ENTER);
		//genre latin & espece commune & espece latine selectionnes auto
		
		driver.findElement(ByXPath.xpath(Constantes.XPATH_HAUTEUR_MOINS_2M)).click();

		WebElement valider = driver.findElement(ByXPath.xpath(Constantes.XPATH_RELEVE_BOUTON_VALIDER));
		valider.click();
		
		Thread.sleep(2000);
		
		WebElement confirmValider = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_RELEVE_BOUTON_CONFIMER_VALIDATION));
		confirmValider.click();
	}
	
	public static void testRenseignerReleveSurLaCarteAvecHauteur2m5m(WebDriver driver) throws InterruptedException {		
		
		driver.findElement(By.xpath(Constantes.XPATH_MAP_BOUTON_CENTRER)).click();
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(ByXPath.xpath(Constantes.XPATH_MAP)), 0, 0);
		builder.moveByOffset(200, 100).click().build().perform();
		
		WebElement vCreatePlan = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_MAP_CLICK_ON_MAP));

		vCreatePlan.click();
		
		WebElement genreCommun = driver.findElement(By.id(Constantes.ID_GENRE_COMMUN));
		
		genreCommun.sendKeys("Albizzia" + Keys.DOWN + Keys.ENTER);
		//genre latin & espece commune & espece latine selectionnes auto
		
		driver.findElement(ByXPath.xpath(Constantes.XPATH_HAUTEUR_2M_5M)).click();

		WebElement valider = driver.findElement(ByXPath.xpath(Constantes.XPATH_RELEVE_BOUTON_VALIDER));
		valider.click();
		
		Thread.sleep(2000);
		
		WebElement confirmValider = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_RELEVE_BOUTON_CONFIMER_VALIDATION));
		confirmValider.click();
	}
	
	public static void testRenseignerReleveSurLaCarteAvecHauteur5m10m(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.xpath(Constantes.XPATH_MAP_BOUTON_CENTRER)).click();
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(ByXPath.xpath(Constantes.XPATH_MAP)), 0, 0);
		builder.moveByOffset(200, 100).click().build().perform();
		
		WebElement vCreatePlan = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_MAP_CLICK_ON_MAP));

		vCreatePlan.click();
		
		WebElement genreCommun = driver.findElement(By.id(Constantes.ID_GENRE_COMMUN));
		
		genreCommun.sendKeys("Albizzia" + Keys.DOWN + Keys.ENTER);
		//genre latin & espece commune & espece latine selectionnes auto
		
		driver.findElement(ByXPath.xpath(Constantes.XPATH_HAUTEUR_5M_10M)).click();

		WebElement valider = driver.findElement(ByXPath.xpath(Constantes.XPATH_RELEVE_BOUTON_VALIDER));
		valider.click();
		
		Thread.sleep(2000);
		
		WebElement confirmValider = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_RELEVE_BOUTON_CONFIMER_VALIDATION));
		confirmValider.click();
	}
	
	public static void testRenseignerReleveSurLaCarteAvecHauteurPlus10m(WebDriver driver) throws InterruptedException {		
		
		driver.findElement(By.xpath(Constantes.XPATH_MAP_BOUTON_CENTRER)).click();
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(ByXPath.xpath(Constantes.XPATH_MAP)), 0, 0);
		builder.moveByOffset(200, 100).click().build().perform();
		
		WebElement vCreatePlan = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_MAP_CLICK_ON_MAP));

		vCreatePlan.click();
		
		WebElement genreCommun = driver.findElement(By.id(Constantes.ID_GENRE_COMMUN));
		
		genreCommun.sendKeys("Albizzia" + Keys.DOWN + Keys.ENTER);
		//genre latin & espece commune & espece latine selectionnes auto
		
		driver.findElement(ByXPath.xpath(Constantes.XPATH_HAUTEUR_PLUS_10M)).click();

		WebElement valider = driver.findElement(ByXPath.xpath(Constantes.XPATH_RELEVE_BOUTON_VALIDER));
		valider.click();
		
		Thread.sleep(2000);
		
		WebElement confirmValider = driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_RELEVE_BOUTON_CONFIMER_VALIDATION));
		confirmValider.click();
	}
	
	
	
}
