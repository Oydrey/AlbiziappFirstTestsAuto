package com.automation.selenium.matheo;

import org.junit.Assert;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class CTRF301_TestVoirSesReleves {
	
	public static void test(WebDriver driver) throws InterruptedException {
		driver.manage().window().setSize(new Dimension(785, 625));
		FonctionMethods.login(driver,"toxav87996@onmail3.com" , "azertyuiop");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[1]")).click();
		// diver,x,y,commonGenusSelect,GenusSelect,commonSpeciesSelect,SpeciesSelect,niveuaxdeconfiant
		FonctionMethods.testRenseignerReleveSurLaCarteSansPhoto(driver,100,100,"Bibacier","Eriobotrya","Bibacier du Japon","Eriobotrya Japonica","Confiant");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]/div[1]/p")).click();
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]/div/span")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div/button[1]/span[1]")).isDisplayed());
		WebElement non = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]/div/p"));
		Assert.assertEquals(non.getText(),"duzahfiuazh");//verif le non de l'auteur du releve
		FonctionMethods.SuprimeReleve1ere(driver);
	}
}
