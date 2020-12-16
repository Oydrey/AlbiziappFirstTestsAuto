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
public class CTRF14x1Reprendremissionencours {
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
public void test45() {
 driver.get("https://albiziapp.ozytis.fr/");
 driver.manage().window().setSize(new Dimension(1050, 670));
 driver.findElement(By.cssSelector(".MuiIconButton-label path")).click();
 {
   WebElement element = driver.findElement(By.cssSelector(".MuiIconButton-label path"));
   Actions builder = new Actions(driver);
   builder.moveToElement(element).perform();
 }
 {
   WebElement element = driver.findElement(By.tagName("body"));
   Actions builder = new Actions(driver);
   builder.moveToElement(element, 0, 0).perform();
 }
 driver.findElement(By.cssSelector(".MuiButtonBase-root:nth-child(2) > .MuiListItemIcon-root")).click();
 driver.findElement(By.cssSelector(".MuiInputBase-input")).click();
 driver.findElement(By.cssSelector(".MuiInputBase-input")).sendKeys("ulex");
 driver.findElement(By.cssSelector(".MuiListItemText-primary")).click();
 driver.findElement(By.cssSelector(".material-icons:nth-child(2)")).click();
 driver.findElement(By.cssSelector(".material-icons:nth-child(3)")).click();
 driver.findElement(By.cssSelector(".material-icons:nth-child(4)")).click();
 driver.findElement(By.cssSelector(".material-icons:nth-child(5)")).click();
}
}