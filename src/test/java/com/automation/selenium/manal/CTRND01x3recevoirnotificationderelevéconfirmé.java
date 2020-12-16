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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class CTRND01x3recevoirnotificationderelevéconfirmé {
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
  public void CTRND01x3recevoirnotificationderelevéconfirmé() {
    driver.get("https://albiziapp.ozytis.fr/");
    driver.manage().window().setSize(new Dimension(1050, 670));
    driver.findElement(By.cssSelector(".MuiButtonBase-root:nth-child(1) > .MuiBottomNavigationAction-wrapper > .MuiSvgIcon-root")).click();
    driver.findElement(By.cssSelector(".jss31")).click();
    driver.findElement(By.cssSelector(".MuiButton-textPrimary > .MuiButton-label")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".MuiFormControl-root:nth-child(2) .MuiButtonBase-root:nth-child(2) .MuiSvgIcon-root"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".MuiFormControl-root:nth-child(2) .MuiButtonBase-root:nth-child(2) .MuiSvgIcon-root")).click();
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.id("commonGenusSelect-option-0")).click();
    driver.findElement(By.id("GenusSelect")).click();
    driver.findElement(By.id("GenusSelect-option-0")).click();
    driver.findElement(By.id("commonSpeciesSelect")).click();
    driver.findElement(By.id("commonSpeciesSelect-option-3")).click();
    driver.findElement(By.id("SpeciesSelect")).click();
    driver.findElement(By.id("SpeciesSelect-option-3")).click();
    driver.findElement(By.name("mui-49925")).click();
    driver.findElement(By.cssSelector(".MuiButton-containedPrimary > .MuiButton-label")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".MuiButton-textPrimary > .MuiButton-label"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".MuiButton-textPrimary > .MuiButton-label")).click();
  }
}


