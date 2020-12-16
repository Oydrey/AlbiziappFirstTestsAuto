package com.automation.selenium.matheo;

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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
public class CTRF10211ConsultelesDifArbes {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
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
  public void cTRF121() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://albiziapp.ozytis.fr/");
	    driver.manage().window().setSize(new Dimension(785, 625));
	    FonctionMethods.login(driver,"tqlgroupe1@gmail.com" , "tqlgroupe1");
	    driver.findElement(By.cssSelector(".MuiIconButton-label > .MuiSvgIcon-root")).click();
	    driver.findElement(By.xpath("/html/body/div[6]/div[3]/ul/div[1]")).click();
	    assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul")).isDisplayed());
		for(int i = 1 ; i < 10; i++) { //on regarde si la lite de arbe s'afiche ici je test que 10
			assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li["+i+"]")).isDisplayed());
			assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/div["+i+"]")).isDisplayed());
		}
  }
}