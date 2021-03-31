package com.automation.selenium.manal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

import static org.junit.Assert.assertEquals;

public class CTRF102331_TestVoirLUsageDUnArbre {

	 public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		driver.manage().window().setSize(new Dimension(1050, 670));
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
		driver.findElement(By.xpath("//span[contains(., 'Flore')]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/input")).sendKeys("chene vert");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/div/div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div/div/button[2]/span[1]")).click();
    		Thread.sleep(5000);
	    	String usageText = "L'écorce se caractérise par une forte richesse en tanins. Elle était récoltée pour la tannerie. Le chêne vert a été une source de bois de chauffage depuis l'Antiquité.\r\n"
	    		+ "\r\n"
	    		+ "Ses fuits, les glands, servent également de nourriture pour le bétail en élevage extensif.";
		assertEquals(usageText, driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/p[2]")).getText());
    }
	 
}

