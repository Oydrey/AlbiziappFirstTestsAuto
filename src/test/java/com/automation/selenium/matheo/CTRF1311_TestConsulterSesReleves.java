package com.automation.selenium.matheo;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.CommonMethods;


public class CTRF1311_TestConsulterSesReleves {

	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver,"toxav87996@onmail3.com" , "azertyuiop");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[1]")).click();
		// diver,x,y,commonGenusSelect,GenusSelect,commonSpeciesSelect,SpeciesSelect,hauter(- de 2m,2m a 5m,5m a 10m,+ de 10m),niv(Faible,Moyen,Haute,rien)
		CommonMethods.testRenseignerReleveSurLaCarteSansPhoto(driver,100,100,"Bibacier","Eriobotrya","Bibacier du Japon","Eriobotrya Japonica","- de 2m","Moyen");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li")).isDisplayed());
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li")).click();
		assertTrue(driver.getCurrentUrl().matches("https://albiziapp.ozytis.fr/observation/.*"));
		CommonMethods.SuprimeReleve1ere(driver);
	}
}
