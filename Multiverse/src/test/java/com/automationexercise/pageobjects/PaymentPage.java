package com.automationexercise.pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import com.automation.base.Base;

public class PaymentPage extends Base{
	
	public void paymentDetails() {
		
		myLibrary.enterText(By.xpath("//*[@id=\"payment-form\"]/div[1]/div/input"), "Ron Swanson");
		
		myLibrary.enterText(By.xpath("//*[@id=\"payment-form\"]/div[2]/div/input"), "1234567812345678");
		
		myLibrary.enterText(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[1]/input"), "123");
		
		myLibrary.enterText(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[2]/input"), "12");
		
		myLibrary.enterText(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[3]/input"), "2029");
		
	}
	
	public void clickPayAndConfirmOrderButton() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"submit\"]"));
		
	}
	
	public void verifyOrderPlaced() {
		
		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
		String orderPlacedMessage = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText();
		assertEquals(orderPlacedMessage, "ORDER PLACED!");
		log.info(orderPlacedMessage);
		
	}
	
	public void deleteAccount() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
		
		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
		String accountDeletedMessage = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText();
		assertEquals(accountDeletedMessage, "ACCOUNT DELETED!");
		log.info(accountDeletedMessage);
		
	}
	
	public void downloadInvoice() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"form\"]/div/div/div/a"));
		
	}
	
	public void clickContinueButton() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
		
	}

}
