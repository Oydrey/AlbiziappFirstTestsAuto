package com.automation.selenium.manal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF10231_TestConsulterUneEspeceDArbre {
	
  public static void test(WebDriver driver) throws InterruptedException {
    CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
    driver.manage().window().setSize(new Dimension(1050, 670));
    driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
    driver.findElement(By.xpath("//span[contains(., 'Flore')]")).click();
    driver.findElement(By.cssSelector(".MuiInputBase-input")).sendKeys("chene vert");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/div/div[1]")).click();
    Thread.sleep(5000);
  }
  
}

