package com.automation.selenium.matheo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;



public class CTRF1281VoirSonStatutTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  	
  @Before
  public void setUp() throws MalformedURLException {
    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), DesiredCapabilities.chrome());
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void cTRF1281VoirSonStatut() throws InterruptedException {
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://albiziapp.ozytis.fr/");
    driver.manage().window().setSize(new Dimension(1382, 744));
    FonctionMethods.login(driver,"tqlgroupe1@gmail.com" , "tqlgroupe1");
    driver.findElement(By.xpath("//div[@id=\'root\']/div/div[2]/button[3]/span/span")).click();
    driver.findElement(By.xpath("//div[@id=\'root\']/div/div/ul/li[4]/div/span")).click();
    assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul")).isDisplayed());
    assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]")).isDisplayed());
    WebElement classe  = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[1]"));
    Assert.assertEquals(classe.getAttribute("class"),"MuiListItem-root MuiListItem-gutters");
  }
}
