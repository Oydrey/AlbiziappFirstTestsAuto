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
		String habitatText = "Courant dans le sud de la France, il se développe dans les garrigues et les forêts. Il est résistant à la chaleur, à la sécheresse, au vent mais aussi au froid. Il pousse sans entretien à partir du moment qu?il se trouve au soleil. Il accepte tous les types de sols, même s?il a une préférence pour les sols calcaires, profonds et bien drainés. Il s?enracine profondément pour subvenir à ses besoins en eau.";
		assertEquals(habitatText, driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/p[2]")).getText());
	}

}
