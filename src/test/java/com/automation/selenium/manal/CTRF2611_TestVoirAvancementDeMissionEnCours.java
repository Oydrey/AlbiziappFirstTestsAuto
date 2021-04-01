package com.automation.selenium.manal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF2611_TestVoirAvancementDeMissionEnCours {
	
	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		driver.findElement(By.cssSelector(".MuiIconButton-label > .MuiSvgIcon-root")).click();
	}
}



