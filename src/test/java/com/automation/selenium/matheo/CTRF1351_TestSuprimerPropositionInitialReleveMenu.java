package com.automation.selenium.matheo;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

import org.openqa.selenium.Dimension;

public class CTRF1351_TestSuprimerPropositionInitialReleveMenu {
	
	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL , Constantes.LOGIN_TQL_PASSWORD);
		// diver,x,y,commonGenusSelect,GenusSelect,commonSpeciesSelect,SpeciesSelect,hauter(- de 2m,2m a 5m,5m a 10m,+ de 10m,rien),niv(Faible,Moyen,Haute)
		CommonMethods.testRenseignerReleveSurLaCarteSansPhoto(driver,100,100,"Bibacier","Eriobotrya","Bibacier du Japon","Eriobotrya Japonica","- de 2m","Moyen");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();
		//mis sur le 1 eme releve de la list
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]/div[1]/p")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div[2]/span/span")).click();
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/button[2]")).isDisplayed());
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/button[2]")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/button[2]")).click();
		//verif que quand la proposition initaila est suprimer le releve ne contien pas d'autre proposition il se suprime
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();
		assertFalse(driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]")).size() > 0);
	}
}
