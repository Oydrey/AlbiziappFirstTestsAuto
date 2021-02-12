package com.automation.selenium.salim;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.automation.selenium.CommonMethods;
import com.automation.selenium.Constantes;

public class CTRF102341_TestVoirHabitatArbre {
	
	
	public static void test(WebDriver driver) throws InterruptedException {
		CommonMethods.login(driver, Constantes.LOGIN_TQL_EMAIL, Constantes.LOGIN_TQL_PASSWORD);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();//home
		driver.findElement(By.xpath("//span[contains(., 'Flore')]")).click();//flore
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/input")).sendKeys("chene vert");//recherche
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/div/div[1]")).click();//clique sur le chene vert	
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div/div/button[3]")).click();//habitat
		String habitatText = "Courant dans le sud de la France, il se d�veloppe dans les garrigues et les for�ts. Il est r�sistant � la chaleur, � la s�cheresse, au vent mais aussi au froid. Il pousse sans entretien � partir du moment qu?il se trouve au soleil. Il accepte tous les types de sols, m�me s?il a une pr�f�rence pour les sols calcaires, profonds et bien drain�s. Il s?enracine profond�ment pour subvenir � ses besoins en eau.";
		assertEquals(habitatText, driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/p[2]")).getText());
	}

}
