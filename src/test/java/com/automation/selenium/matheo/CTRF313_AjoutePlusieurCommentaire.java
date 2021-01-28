package com.automation.selenium.matheo;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.selenium.CommonMethods;

import org.openqa.selenium.Dimension;

import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;

public class CTRF313_AjoutePlusieurCommentaire {

	public static void test(WebDriver driver) throws InterruptedException {
		driver.manage().window().setSize(new Dimension(785, 625));
		CommonMethods.login(driver,"toxav87996@onmail3.com" , "azertyuiop");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[1]")).click();
		// diver,x,y,commonGenusSelect,GenusSelect,commonSpeciesSelect,SpeciesSelect,hauter(- de 2m,2m a 5m,5m a 10m,+ de 10m)
		CommonMethods.testRenseignerReleveSurLaCarteSansPhoto(driver,100,100,"Albizzia","Albizia","Albizzia commun","Albizia Julibrissin","2m a 5m");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();	  
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]/div[1]/p")).click();
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[2]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/textarea")).sendKeys("$&_b");
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[2]/button/span[1]")).click();
		Date date = new Date(); //get date
		//format
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
		sdf.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
		Thread.sleep(1000);
		
		//verif que la case ne plus la
		assertFalse(driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/textarea")).size() > 0);
		
		WebElement increment = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[1]"));
		assertEquals(increment.getText(),"Commentaires (1)");
		WebElement elementnondate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[2]/div[1]"));
		// ceci est normal "duzahfiuazh" c est le non de compte qui est utilise pour se test
		assertEquals(elementnondate.getText(),"duzahfiuazh, le "+sdf.format(date));
		WebElement text = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[2]/div[2]"));
		assertEquals(text.getText(),"$&_b");
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/textarea")).sendKeys("bonjour");
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[3]/button/span[1]")).click();  
		Thread.sleep(1000);
		
		//verif que la case ne plus la
		assertFalse(driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/textarea")).size() > 0);
				
		WebElement increment2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[1]"));
		assertEquals(increment2.getText(),"Commentaires (2)");
		WebElement elementnondate2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[3]/div[1]"));
		assertEquals(elementnondate2.getText(),"duzahfiuazh, le "+sdf.format(date));
		WebElement text2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[12]/div[3]/div[2]"));
		assertEquals(text2.getText(),"bonjour");
		
		CommonMethods.SuprimeReleve1ere(driver);
	}
}
