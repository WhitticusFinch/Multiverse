package com.automationexercise.pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import com.automation.base.Base;

public class MadameBrandProductsPage extends Base{
	
	public void verifyMadameProducts() {
		
		myLibrary.waitForElementVisibility(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2"));
		String madameProductsVisiblity = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2")).getText();
		assertEquals(madameProductsVisiblity, "BRAND - MADAME PRODUCTS");
		log.info(madameProductsVisiblity);
		
	}

}
