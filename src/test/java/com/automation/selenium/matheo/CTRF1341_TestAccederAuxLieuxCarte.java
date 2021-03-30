package com.automation.selenium.matheo;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.Actions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CTRF1341_TestAccederAuxLieuxCarte {
	
	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL , Constantes.LOGIN_TQL_PASSWORD);
		// diver,x,y,commonGenusSelect,GenusSelect,commonSpeciesSelect,SpeciesSelect,hauter(- de 2m,2m a 5m,5m a 10m,+ de 10m),niv(Faible,Moyen,Haute,rien)
		CommonMethods.testRenseignerReleveSurLaCarteSansPhoto(driver,100,100,"Bibacier","Eriobotrya","Bibacier du Japon","Eriobotrya Japonica","5m a 10m","Haute");			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();	
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]/div[1]/p")).click();
			//regex pour recuper l'id du releve dan l'url 
			final String regex = "https://albiziapp.ozytis.fr/observation/(.*)";
			final String string = driver.getCurrentUrl();
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher m = pattern.matcher(string);
			if (m.find()) System.out.println("id oservation (releve) :"+m.group(1));
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[10]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div[2]/div[1]/div/a[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div[2]/div[1]/div/a[1]")).click();
			Thread.sleep(2000);
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[1]")), 0, 0).click();
			builder.moveByOffset(1,1).click().build().perform();
			assertEquals("https://albiziapp.ozytis.fr/observation/"+m.group(1),driver.getCurrentUrl());
			CommonMethods.SupprimerToutLesReleves(driver);
	}
}
