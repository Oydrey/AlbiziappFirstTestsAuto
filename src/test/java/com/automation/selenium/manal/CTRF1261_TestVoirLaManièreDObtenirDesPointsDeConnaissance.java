package com.automation.selenium.manal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.By.ByXPath;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF1261_TestVoirLaManièreDObtenirDesPointsDeConnaissance {
	
	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		driver.manage().window().setSize(new Dimension(1050, 670));
		driver.findElement(ByXPath.xpath("//*[@id=\"root\"]/div/div[2]/button[3]/span/span[1]")).click();
		//driver.findElement(By.cssSelector(".MuiListItem-root:nth-child(2) .MuiListItemText-secondary")).click();
	}
}

