package com.automationexercise.pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import com.automation.base.Base;

public class MenJeansProductsPage extends Base{
	
public void verifyMenJeansProductsText() {
		
		myLibrary.waitForElementVisibility(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2"));
		String menJeansProductsText = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2")).getText();
		assertEquals(menJeansProductsText, "MEN - JEANS PRODUCTS");
		log.info(menJeansProductsText);
		
	}

}
