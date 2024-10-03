package com.automationexercise.pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.base.Base;

public class WomenDressProductsPage extends Base{
	
	public void verifyWomenDressProductsText() {
		
		myLibrary.waitForElementVisibility(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2"));
		String womenDressProductsText = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2")).getText();
		assertEquals(womenDressProductsText, "WOMEN - DRESS PRODUCTS");
		log.info(womenDressProductsText);
		
	}
	
	public void expandMenCategory() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a/span/i"));
		
	}
	
	public void clickMenJeansCategory() {
		
		WebElement jeansCategory = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"Men\"]/div/ul/li[2]/a"));
		
		myLibrary.clickButton(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/ul/li[2]/a"));
		
	}

}
