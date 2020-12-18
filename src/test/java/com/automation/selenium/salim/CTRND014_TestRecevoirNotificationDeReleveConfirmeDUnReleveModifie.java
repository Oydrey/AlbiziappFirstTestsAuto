package com.automation.selenium.salim;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.selenium.CommonMethods;

public class CTRND014_TestRecevoirNotificationDeReleveConfirmeDUnReleveModifie {

	private static final DesiredCapabilities CAPABILITY = DesiredCapabilities.chrome();

	private static final String SELENIUM_SERVER_URL = "http://127.0.0.1:4444/wd/hub";

	private static final String LOGIN_URL = "https://albiziapp.ozytis.fr/login";

	private WebDriver driver = null;

	private String email = "tqlgroupe1@gmail.com";

	private String password = "tqlgroupe1";

	@Before
	public void setup() throws MalformedURLException, InterruptedException {
		// Create a new instance of the driver
		driver = new RemoteWebDriver(new URL(SELENIUM_SERVER_URL), CAPABILITY);

		// And now use this to open base url
		driver.navigate().to(LOGIN_URL);

		// Ask to the driver to wait for 3s when an element is not found
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws InterruptedException {
		CommonMethods.login(driver, email, password);

		CommonMethods.testRenseignerReleveSurLaCarteAvecPeuConfiant(driver);

		new WebDriverWait(driver, 5).until(ExpectedConditions.urlMatches("https://albiziapp.ozytis.fr/map"));
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/button[1]")).click();

		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[1]")), 0, 0);
		builder.moveByOffset(100, 100).click().build().perform();

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/button")).click();
		WebElement GenreCommun = driver.findElement(By.xpath("//*[@id=\"commonGenusSelect\"]"));
		WebElement GenreLatin = driver.findElement(By.xpath("//*[@id=\"genusSelect\"]"));
		WebElement EspeceCommune = driver.findElement(By.xpath("//*[@id=\"speciesCommonNameSelect\"]"));
		WebElement EspeceLatine = driver.findElement(By.xpath("//*[@id=\"speciesNameSelect\"]"));
		EspeceLatine.click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[4]/div/div/div/div/button[1]")).click();
		EspeceCommune.click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div/div/div/div/button[1]")).click();
		GenreLatin.click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div/div/div/div/button[1]")).click();
		GenreCommun.click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div/div/div/button[1]")).click();

		GenreCommun.sendKeys("Avocatier");
		driver.findElement(By.cssSelector(".MuiAutocomplete-popper")).click();
		GenreLatin.sendKeys("Persea");
		driver.findElement(By.cssSelector(".MuiAutocomplete-popper")).click();
		EspeceCommune.sendKeys("Avocatier commun");
		driver.findElement(By.cssSelector(".MuiAutocomplete-popper")).click();
		EspeceLatine.sendKeys("Persea Americana");
		driver.findElement(By.cssSelector(".MuiAutocomplete-popper")).click();

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/button[1]")).click();
		driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-textPrimary")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button[1]")).click();

		builder.moveToElement(driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[1]/div[1]")), 0, 0);
		builder.moveByOffset(100, 100).click().build().perform();

		assertEquals("Persea", driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[2]/div/p")).getText());
		assertEquals("Avocatier", driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[3]/div/p")).getText());
		assertEquals("Persea Americana", driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[4]/div/p")).getText());
		assertEquals("Avocatier commun", driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li[5]/div/p")).getText());

	}

	@After
	public void teardown() {

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[5]/button")).click();
		driver.findElement(By.cssSelector(".MuiButtonBase-root.MuiButton-textPrimary")).click();
		driver.quit();
	}

}