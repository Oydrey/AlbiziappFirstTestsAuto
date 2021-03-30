package com.automation.selenium.matheo;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

import org.openqa.selenium.Dimension;

public class CTRF1331_TestModifierPropositionInitialReleveMenu {
	
	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL , Constantes.LOGIN_TQL_PASSWORD);
		// diver,x,y,commonGenusSelect,GenusSelect,commonSpeciesSelect,SpeciesSelect,hauter(- de 2m,2m a 5m,5m a 10m,+ de 10m),niv(Faible,Moyen,Haute,rien)
		CommonMethods.testRenseignerReleveSurLaCarteSansPhoto(driver,100,100,"Bibacier","Eriobotrya","Bibacier du Japon","Eriobotrya Japonica","- de 2m","Faible");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();
		//mis sur le 1 eme releve de la list
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]/div[1]/p")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div[2]/span/span")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/button[1]")).click();
		String vCurrentURL = driver.getCurrentUrl();
		assertTrue(vCurrentURL.matches("https://albiziapp.ozytis.fr/edit-observation/.*"));
		
		assertTrue(driver.findElement(By.xpath("//*[@id=\"commonGenusSelect\"]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//*[@id=\"genusSelect\"]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//*[@id=\"speciesCommonNameSelect\"]")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//*[@id=\"speciesNameSelect\"]")).isDisplayed());
		CommonMethods.SupprimerToutLesReleves(driver);
	}
}
