package com.automationexercise.pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import com.automation.base.Base;

public class PoloBrandProductsPage extends Base{
	
	public void verifyPoloProducts() {
		
		myLibrary.waitForElementVisibility(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2"));
		String poloProductsVisiblity = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2")).getText();
		assertEquals(poloProductsVisiblity, "BRAND - POLO PRODUCTS", "BRAND  - POLO PRODUCTS");
		log.info(poloProductsVisiblity);
		
	}
	
	public void clickMadameBrand() {
		
		myLibrary.clickButton(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[3]/a"));
		
	}

}
