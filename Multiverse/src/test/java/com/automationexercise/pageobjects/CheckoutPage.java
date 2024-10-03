package com.automationexercise.pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import com.automation.base.Base;

public class CheckoutPage extends Base {

	public void verifyDeliveryAddress() {

		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"address_delivery\"]/li[1]/h3"));
		String deliveryAddress = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[1]/h3")).getText();
		assertEquals(deliveryAddress, "YOUR DELIVERY ADDRESS");
		log.info(deliveryAddress);
		
	}
	
	public void verifyBillingAddress() {
		
		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"address_invoice\"]/li[1]/h3"));
		String billingAddress = driver.findElement(By.xpath("//*[@id=\"address_invoice\"]/li[1]/h3")).getText();
		assertEquals(billingAddress, "YOUR BILLING ADDRESS");
		log.info(billingAddress);
		
	}
	
	public void enterComment() {
		
		myLibrary.enterText(By.xpath("//*[@id=\"ordermsg\"]/textarea"), "Weebles wobble but they don't fall down.");
		
	}
	
	public void clickPlaceOrderButton() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a"));
		
	}
	
	public void deleteAccount() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
		
	}

}
