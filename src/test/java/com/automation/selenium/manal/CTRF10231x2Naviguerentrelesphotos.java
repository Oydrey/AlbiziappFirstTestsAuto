package com.automation.selenium.manal;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
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

import com.automation.selenium.CommonMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class CTRF10231x2Naviguerentrelesphotos {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  private String email = "tqlgroupe1@gmail.com";
  private String password = "tqlgroupe1";
  @Before
  public void setUp() throws MalformedURLException {
    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void test48() throws InterruptedException{
    driver.get("https://albiziapp.ozytis.fr/");
    CommonMethods.login(driver, email, password);
    driver.manage().window().setSize(new Dimension(1050, 670));
    driver.findElement(By.cssSelector(".MuiIconButton-label > .MuiSvgIcon-root")).click();
    driver.findElement(By.cssSelector(".MuiButtonBase-root:nth-child(2) .MuiTypography-root")).click();
    Thread.sleep(5000);
    driver.findElement(By.cssSelector(".MuiInputBase-input")).click();
    driver.findElement(By.cssSelector(".MuiInputBase-input")).sendKeys("chene vert");
    driver.findElement(By.cssSelector(".MuiListItemText-primary")).click();
    Thread.sleep(5000);
  }
}

