package com.automation.selenium.salim;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF102321_TestVoirLaDescription {

	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);	
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();//home
		driver.findElement(By.xpath("//span[contains(., 'Flore')]")).click();//flore
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/input")).sendKeys("chene vert");//recherche
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/div/div[1]")).click();//clique sur le chene vert	
		String DescriptionText = "Le chêne vert se caractérise par :";
		assertEquals(DescriptionText, driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/p[4]")).getText());
	}

}
