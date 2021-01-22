package com.automation.selenium.manal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF181_TestAccederAuxMissionsDepuisLeMenuPrincipal {
	
  public static void test(WebDriver driver) throws InterruptedException {
	CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
    driver.manage().window().setSize(new Dimension(1050, 670));
    Thread.sleep(5000);
  }
}

