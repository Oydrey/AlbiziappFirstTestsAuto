package com.automation.selenium.matheo;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;

import com.automation.selenium.CommonMethods;

import org.openqa.selenium.Dimension;

public class CTRF1321_TestSupprimerUnReleve {
	
	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver,"toxav87996@onmail3.com" , "azertyuiop");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[1]")).click();
		// diver,x,y,commonGenusSelect,GenusSelect,commonSpeciesSelect,SpeciesSelect,hauter(- de 2m,2m a 5m,5m a 10m,+ de 10m),niv(Faible,Moyen,Haute,rien)
		CommonMethods.testRenseignerReleveSurLaCarteSansPhoto(driver,100,100,"Bibacier","Eriobotrya","Bibacier du Japon","Eriobotrya Japonica","2m a 5m","Moyen");
		CommonMethods.SuprimeReleve1ere(driver);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();
		//test si le releve a bien etait suprimer
		assertFalse(driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]")).size() > 0);
	}
}
