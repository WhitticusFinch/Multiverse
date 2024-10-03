package com.automationexercise.pageobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.base.Base;

public class FirstProductPage extends Base{
	
	public void verifyProductDetails() {
		
		WebElement verifyPriceVisible = myLibrary.waitForElementVisibility(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span"));
		assertNotNull(verifyPriceVisible, "Product price is not visible.");
		
		WebElement verifyBrandVisible = myLibrary.waitForElementVisibility(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]/b"));
		assertNotNull(verifyBrandVisible, "Product brand is not visible.");
		
	}
	
	public void verifyWriteYourReview() {
		
		myLibrary.waitForElementVisibility(By.xpath("/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a"));
		String verifyWriteYourReview = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a")).getText();
		assertEquals(verifyWriteYourReview, "WRITE YOUR REVIEW");
		log.info(verifyWriteYourReview);
		
	}
	
	public void fillReviewForm() {
		
		myLibrary.enterText(By.xpath("//*[@id=\"name\"]"), "Ron Swanson");
		
		myLibrary.enterText(By.xpath("//*[@id=\"email\"]"), "moefoe@gmail.com");
		
		myLibrary.enterText(By.xpath("//*[@id=\"review\"]"), "This shirt is the tits!");
		
	}
	
	public void submitReview() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"button-review\"]"));
		
	}
	
	public void verifyThankYouReview() {
		
		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"review-section\"]/div/div/span"));
		String verifyThankYouReview = driver.findElement(By.xpath("//*[@id=\"review-section\"]/div/div/span")).getText();
		assertEquals(verifyThankYouReview, "Thank you for your review.");
		log.info(verifyThankYouReview);
		
	}

}
