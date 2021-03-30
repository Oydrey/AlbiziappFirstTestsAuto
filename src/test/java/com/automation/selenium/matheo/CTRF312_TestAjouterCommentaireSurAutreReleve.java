package com.automation.selenium.matheo;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.Actions;

import com.automation.selenium.CommonMethods;

import org.openqa.selenium.Dimension;

public class CTRF312_TestAjouterCommentaireSurAutreReleve {

	public static void test(WebDriver driver) throws InterruptedException {
		//user 1
		CommonMethods.login(driver,"toxav87996@onmail3.com" , "azertyuiop");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[1]")).click();
		// diver,x,y,commonGenusSelect,GenusSelect,commonSpeciesSelect,SpeciesSelect,hauter(- de 2m,2m a 5m,5m a 10m,+ de 10m),niv(Faible,Moyen,Haute,rien)
		CommonMethods.testRenseignerReleveSurLaCarteSansPhoto(driver,1,1,"Albizzia","Albizia","Albizzia commun","Albizia Julibrissin","2m a 5m","Faible");
		Thread.sleep(2000);
		CommonMethods.testSeDeconnecter(driver);
		//user 2
		CommonMethods.login(driver,"tqlgroupe1@gmail.com" , "tqlgroupe1");
		//zoome
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div[2]/div[1]/div/a[1]")).click();
		Thread.sleep(1000);
		//clic
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[1]")), 0, 0).click();
		builder.moveByOffset(1,1).click().build().perform();
		//commantaire ajout
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[2]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/textarea")).sendKeys("test");
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[2]/button/span[1]")).click();
		Date date = new Date(); //get date
		//format
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
		sdf.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
		WebElement increment = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[1]"));
		assertEquals(increment.getText(),"Commentaires (1)");
		WebElement elementnondate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[2]/div[1]"));
		assertEquals(elementnondate.getText(),"TestGroupe1, le "+sdf.format(date));
		WebElement text = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[2]/div[2]"));
		assertEquals(text.getText(),"test");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[1]")).click();
		
		CommonMethods.SupprimerToutLesReleves(driver);
	}
}
