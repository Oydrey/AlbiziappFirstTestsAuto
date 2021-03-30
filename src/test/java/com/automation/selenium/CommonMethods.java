package com.automation.selenium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		
		windows = driver.getWindowHandles();
		iterator = windows.iterator();
		driver.switchTo().window(iterator.next());
		String mainWindow = driver.getWindowHandle();
			
		
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
		driver.navigate().refresh();
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
	
	public static void testRenseignerReleveSurLaCarteSansPhoto(WebDriver driver,int x,int y,String commonGenusSelect,String GenusSelect,String commonSpeciesSelect,String SpeciesSelect,String hauter,String niv) throws InterruptedException {		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[1]")), 0, 0).click();
		builder.moveByOffset(x,y).click().build().perform();
		
		WebElement vCreatePlan = driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-textPrimary"));
		vCreatePlan.click();
		
		WebElement genreCommun = driver.findElement(By.id("commonGenusSelect"));
		WebElement genreLatin = driver.findElement(By.id("GenusSelect"));
		WebElement especeCommune = driver.findElement(By.id("commonSpeciesSelect"));
		WebElement especeLatine = driver.findElement(By.id("SpeciesSelect"));
		
		genreCommun.sendKeys(commonGenusSelect + Keys.DOWN + Keys.ENTER);
		genreLatin.sendKeys(GenusSelect + Keys.DOWN + Keys.ENTER);
		especeCommune.sendKeys(commonSpeciesSelect + Keys.DOWN + Keys.ENTER);
		//especeLatine.sendKeys(SpeciesSelect + Keys.DOWN + Keys.ENTER);	
		if (hauter == "- de 2m") {
			driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[5]/table/tbody/tr/td[2]")).click();
		}else if (hauter == "2m a 5m") {
			driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[5]/table/tbody/tr/td[3]")).click();
		} else if (hauter == "5m a 10m") {
			driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[5]/table/tbody/tr/td[4]")).click();
		} else if (hauter == "+ de 10m") {
			driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[5]/table/tbody/tr/td[5]")).click();
		}else {
			System.out.println("aucun hauter (mis ou selectionais ou ecrit) par defaut : - de 2m ");
			driver.findElement(ByXPath.xpath("//*[@id=\\\"root\\\"]/div/div[1]/div[5]/table/tbody/tr/td[2]")).click();
		}
		if (niv == "Faible") {
			driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[7]/table/tbody/tr/td[2]")).click();
		}else if (niv == "Moyen") {
			driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[7]/table/tbody/tr/td[3]")).click();
		} else if (niv == "Haute") {
			driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[7]/table/tbody/tr/td[4]")).click();
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/button[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/button[2]")));
		/*
		//verif info :
		Thread.sleep(4000);
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[1]")), 0, 0).click();
		builder1.moveByOffset(x,y).click().build().perform();
		WebElement Genre = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[2]/div/p"));
		Assert.assertEquals(Genre.getText(),GenusSelect);
		WebElement Genrevernaculaire =driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[3]/div/p"));
		Assert.assertEquals(Genrevernaculaire.getText(),commonGenusSelect);
		WebElement Espèce = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[4]/div/p"));
		Assert.assertEquals(Espèce.getText(),SpeciesSelect);
		WebElement Nomvernaculaire =driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[5]/div/p"));
		Assert.assertEquals(Nomvernaculaire.getText(),commonSpeciesSelect);
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[6]/div/p")).getText(),niveuaxdeconfiant);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[1]"));
		*/
	}
	
	public static void SuprimeReleve1ere(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();	  
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]/div[1]/p")).click();
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/button")).click();
	    driver.findElement(By.xpath("//div[3]/div/div[2]/button[2]/span")).click();
	}
	public static void SupprimerToutLesReleves(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[1]")).click();
		driver.navigate().refresh();
		driver.findElement(By.xpath(Constantes.XPATH_MENU_BOUTON_FEUILLE)).click();
		driver.findElement(By.xpath(Constantes.XPATH_MENU_SUPPRESSION_BOUTON)).click();
		driver.findElement(By.cssSelector(Constantes.CSS_SELECTOR_RELEVE_BOUTON_CONFIMER_VALIDATION)).click();	
	}
	
}
