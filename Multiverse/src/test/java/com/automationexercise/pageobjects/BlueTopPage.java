package com.automationexercise.pageobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.base.Base;

public class BlueTopPage extends Base{
	
	public void verifyBlueTopDetails() {
		
		myLibrary.waitForElementVisibility(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2"));
		String blueTopText = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")).getText();
		assertEquals(blueTopText, "Blue Top");
		log.info(blueTopText);
		
	}
	
	public void clearQuantity() {
	
		driver.findElement(By.xpath("//*[@id=\"quantity\"]")).clear();
		
	}
	
	public void enterQuantity() {
		
		myLibrary.enterText(By.xpath("//*[@id=\"quantity\"]"), "4");
		
	}
	
	public void addToCart() {
		
		myLibrary.clickButton(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button"));
		WebElement viewCartLink = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"));
		assertNotNull(viewCartLink, "View cart link is not visible.");
		myLibrary.clickButton(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"));
		
	}

}
