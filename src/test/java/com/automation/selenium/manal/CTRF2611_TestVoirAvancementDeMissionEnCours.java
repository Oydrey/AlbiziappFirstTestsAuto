package com.automation.selenium.manal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF2611_TestVoirAvancementDeMissionEnCours {
	
	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		driver.findElement((ByXPath.xpath("//*[@id=\"root\"]/div/div[2]/button[2]/span/svg/path"))).click();
	}
}



