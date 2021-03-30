package com.automation.selenium.matheo;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import com.automation.selenium.CommonMethods;

public class CTRF301_TestVoirSesReleves {
	
	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver,"toxav87996@onmail3.com" , "azertyuiop");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[1]")).click();
		Date date = new Date(); //get date
		// diver,x,y,commonGenusSelect,GenusSelect,commonSpeciesSelect,SpeciesSelect,hauter(- de 2m,2m a 5m,5m a 10m,+ de 10m),niv(Faible,Moyen,Haute,rien)
		CommonMethods.testRenseignerReleveSurLaCarteSansPhoto(driver,100,100,"Bibacier","Eriobotrya","Bibacier du Japon","Eriobotrya Japonica","2m a 5m","Faible");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();
		//format etc
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
		sdf.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
		WebElement elementtextdate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]/div[1]/p"));
		assertTrue(elementtextdate.getText().matches(sdf.format(date)+".*")); // verif la date du releve
		CommonMethods.SuprimeReleve1ere(driver);
	}
}
