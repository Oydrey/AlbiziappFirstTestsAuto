package com.automation.selenium.matheo;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;

public class CTRF1321_TestSupprimerUnReleve {
	
	public static void test(WebDriver driver) throws InterruptedException {
		driver.manage().window().setSize(new Dimension(785, 625));
		FonctionMethods.login(driver,"toxav87996@onmail3.com" , "azertyuiop");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[1]")).click();
		// diver,x,y,commonGenusSelect,GenusSelect,commonSpeciesSelect,SpeciesSelect,niveuaxdeconfiant
		FonctionMethods.testRenseignerReleveSurLaCarteSansPhoto(driver,10,10,"Bibacier","Eriobotrya","Bibacier du Japon","Eriobotrya Japonica","Confiant");
		FonctionMethods.SuprimeReleve1ere(driver);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();
		assertFalse(driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]")).size() > 0);
	}
}
