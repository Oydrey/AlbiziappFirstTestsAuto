package com.automation.selenium.salim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRND016_TestRecevoirNotificationPoints {
	
	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		CommonMethods.testRenseignerReleveSurLaCarteAvecAjoutPhotoAvecHauteurMoins2m(driver);
		//Pas de notif
		driver.findElement(By.xpath("//div[@class='Toastify__toast-body' and contains(.,'12')]"));
	}

}
