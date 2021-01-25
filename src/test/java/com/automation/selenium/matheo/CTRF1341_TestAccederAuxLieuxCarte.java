package com.automation.selenium.matheo;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.Constantes;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.Actions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CTRF1341_TestAccederAuxLieuxCarte {
	
	public static void test(WebDriver driver) throws InterruptedException {
		driver.manage().window().setSize(new Dimension(785, 625));
		FonctionMethods.login(driver, Constantes.LOGIN_TQL_EMAIL , Constantes.LOGIN_TQL_PASSWORD);
		
		for (int i = 1 ; i < 3; i++) {
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[5]")).click();	
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li["+i+"]/div[1]/p")).click();
			//regex pour recuper l'id du releve dan l'url 
			final String regex = "https://albiziapp.ozytis.fr/observation/(.*)";
			final String string = driver.getCurrentUrl();
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher m = pattern.matcher(string);
			if (m.find()) System.out.println("id oservation (releve) :"+m.group(1));
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[9]/button")).click();
			Actions builder = new Actions(driver);
			builder.moveToElement(driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[1]")), 0, 0).click();
			builder.moveByOffset(1,1).click().build().perform();
			assertEquals("https://albiziapp.ozytis.fr/observation/"+m.group(1),driver.getCurrentUrl());
		}
	}
}
