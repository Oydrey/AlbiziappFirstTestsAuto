package com.automation.selenium.matheo;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.selenium.CommonMethods;

import org.openqa.selenium.Dimension;

public class CTRF32_TestAnnulerunCommentairePasEncorePoste {

	public static void test(WebDriver driver) throws InterruptedException {
		driver.manage().window().setSize(new Dimension(785, 625));
		CommonMethods.login(driver,"toxav87996@onmail3.com" , "azertyuiop");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[1]")).click();
		// diver,x,y,commonGenusSelect,GenusSelect,commonSpeciesSelect,SpeciesSelect,hauter(- de 2m,2m a 5m,5m a 10m,+ de 10m)
		CommonMethods.testRenseignerReleveSurLaCarteSansPhoto(driver,100,100,"Albizzia","Albizia","Albizzia commun","Albizia Julibrissin","2m a 5m");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();	  
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]/div[1]/p")).click();
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[2]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/textarea")).sendKeys("test");
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[3]/button/span[1]")).click();
		Thread.sleep(1000);
		
		//verif que la case "text" ne plus la 
		assertFalse(driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/textarea")).size() > 0);
		
		WebElement increment = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[1]"));
		assertEquals(increment.getText(),"Commentaires (0)");
		
		CommonMethods.SuprimeReleve1ere(driver);
	}
}
