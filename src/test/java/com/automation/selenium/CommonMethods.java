package com.automation.selenium;

import static org.junit.Assert.assertEquals;

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

	public static void login(WebDriver driver, String email, String password) {
		WebElement vSignInButton = driver.findElement(ByXPath.xpath("/html/body/div[1]/div/div/div/div/button"));
		vSignInButton.click();
		
		String mainWindow = driver.getWindowHandle();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		
		while(iterator.hasNext()) {
			String childWindow = iterator.next();
			
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				
				WebElement emailField = driver.findElement(By.name("username"));
				emailField.sendKeys(email);
				
				WebElement passwordField = driver.findElement(By.name("password"));
				passwordField.sendKeys(password);
				
				WebElement vSignButton = driver.findElement(By.name("commit"));
				vSignButton.click();
				
				new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/form/input[5]")));
				WebElement vAccordAccessButton = driver.findElement(ByXPath.xpath("/html/body/div/div[2]/div/form/input[5]"));
				
				vAccordAccessButton.click();
			}
		}
		
		driver.switchTo().window(mainWindow);
	}
	
	public static void testRenseignerReleveSurLaCarteAvecAjoutPhoto(WebDriver driver) throws InterruptedException {		
		Thread.sleep(5000);
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[1]")), 0, 0);
		builder.moveByOffset(100, 100).click().build().perform();
		
		WebElement vCreatePlan = driver.findElement(ByXPath.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]"));
		vCreatePlan.click();
		
		WebElement genreCommun = driver.findElement(By.id("commonGenusSelect"));
		WebElement genreLatin = driver.findElement(By.id("GenusSelect"));
		WebElement especeCommune = driver.findElement(By.id("commonSpeciesSelect"));
		WebElement especeLatine = driver.findElement(By.id("SpeciesSelect"));
		
		genreCommun.sendKeys("Albizzia" + Keys.DOWN + Keys.ENTER);
		genreLatin.sendKeys("Albizia" + Keys.DOWN + Keys.ENTER);
		especeCommune.sendKeys("Albizzia commun" + Keys.DOWN + Keys.ENTER);
		especeLatine.sendKeys("Albizia Julibrissin" + Keys.DOWN + Keys.ENTER);	
		
		WebElement confiant = driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[5]/label[3]/span[1]"));
		confiant.click();
		
		WebElement inputPicture = driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[6]/div/div/input"));
		inputPicture.sendKeys("C:/Users/Oydrey/Pictures/arbre.jpg");

		WebElement valider = driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/button[1]"));
		valider.click();
		
		WebElement confirmValider = driver.findElement(ByXPath.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]"));
		confirmValider.click();
	}
	
}
