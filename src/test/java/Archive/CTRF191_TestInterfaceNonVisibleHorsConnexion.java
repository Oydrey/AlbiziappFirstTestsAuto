package Archive;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;

public class CTRF191_TestInterfaceNonVisibleHorsConnexion {
	
	public static void test(WebDriver driver) {
		driver.manage().window().setSize(new Dimension(785, 625));
		String vCurrentURL = driver.getCurrentUrl();
		assertEquals(vCurrentURL,"https://albiziapp.ozytis.fr/login");
		assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div")).isDisplayed());
	}
}
