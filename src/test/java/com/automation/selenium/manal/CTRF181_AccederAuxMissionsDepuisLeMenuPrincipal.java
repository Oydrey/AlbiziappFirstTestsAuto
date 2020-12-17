package com.automation.selenium.manal;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;

import com.automation.selenium.CommonMethods;

import java.net.MalformedURLException;
import java.net.URL;

public class CTRF181_AccederAuxMissionsDepuisLeMenuPrincipal {
  private WebDriver driver;
  private String email = "tqlgroupe1@gmail.com";
  private String password = "tqlgroupe1";
  
  @Before
  public void setUp() throws MalformedURLException {
    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
  }
  
  @After
  public void tearDown() {
    driver.quit();
  }
  
  @Test
  public void test() throws InterruptedException {
    driver.get("https://albiziapp.ozytis.fr/");
    CommonMethods.login(driver, email, password);
    driver.manage().window().setSize(new Dimension(1050, 670));
    Thread.sleep(5000);
  }
}

