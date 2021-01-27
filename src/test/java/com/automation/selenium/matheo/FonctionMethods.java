package com.automation.selenium.matheo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.Actions;

import com.automation.selenium.CommonMethods;

public class FonctionMethods {

	public static void login(WebDriver driver, String email, String password) throws InterruptedException {
		CommonMethods.login(driver, email, password);
	}
		/*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
				
				WebElement vAccordAccessButton = driver.findElement(ByXPath.xpath("/html/body/div/div[2]/div/form/input[5]"));
				vAccordAccessButton.click();
			}
		}
		
		driver.switchTo().window(mainWindow);
	}*/
	// diver,x,y,commonGenusSelect,GenusSelect,commonSpeciesSelect,SpeciesSelect,hauter(- de 2m,2m a 5m,5m a 10m,+ de 10m)
	public static void testRenseignerReleveSurLaCarteSansPhoto(WebDriver driver,int x,int y,String commonGenusSelect,String GenusSelect,String commonSpeciesSelect,String SpeciesSelect,String hauter) throws InterruptedException {		
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
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[11]/button")).click();
	    driver.findElement(By.xpath("//div[3]/div/div[2]/button[2]/span")).click();
	}
	 
}
