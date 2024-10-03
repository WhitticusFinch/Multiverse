package com.automationexercise.pageobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.base.Base;

public class CartPage extends Base {

	public void verifySubscriptionText() {

		WebElement subscriptionText = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2"));
		assertNotNull(subscriptionText, "The SUBSCRIPTION text is not visible.");

	}

	public void subscribe() {

		myLibrary.enterText(By.xpath("//*[@id=\"susbscribe_email\"]"), "moefoe@gmail.com");

		myLibrary.clickButton(By.xpath("//*[@id=\"subscribe\"]/i"));

		WebElement subscriptionSuccessNotification = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"success-subscribe\"]/div"));
		assertNotNull(subscriptionSuccessNotification, "Subscription success notification is not visible.");

	}
	
	public void verifyBlueTop() {
		
		myLibrary.waitForElementVisibility(By.cssSelector("#product-1 > td.cart_description > h4 > a"));
		String blueTopText = driver.findElement(By.cssSelector("#product-1 > td.cart_description > h4 > a")).getText();
		assertEquals(blueTopText, "Blue Top");
		log.info(blueTopText);
		
		myLibrary.waitForElementVisibility(By.cssSelector("#product-1 > td.cart_price > p"));
		String blueTopPrice = driver.findElement(By.cssSelector("#product-1 > td.cart_price > p")).getText();
		assertEquals(blueTopPrice, "Rs. 500");
		log.info(blueTopPrice);
		
		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"product-1\"]/td[5]/p"));
		String blueTopTotalPrice = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[5]/p")).getText();
		assertEquals(blueTopTotalPrice, "Rs. 500");
		log.info(blueTopTotalPrice);
		
	}
	
	public void verifyMenTshirt() {
		
		myLibrary.waitForElementVisibility(By.cssSelector("#product-2 > td.cart_description > h4 > a"));
		String menTshirtText = driver.findElement(By.cssSelector("#product-2 > td.cart_description > h4 > a")).getText();
		assertEquals(menTshirtText, "Men Tshirt");
		log.info(menTshirtText);
		
		myLibrary.waitForElementVisibility(By.cssSelector("#product-2 > td.cart_price > p"));
		String menTshirtPrice = driver.findElement(By.cssSelector("#product-2 > td.cart_price > p")).getText();
		assertEquals(menTshirtPrice, "Rs. 400");
		log.info(menTshirtPrice);
		
		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"product-2\"]/td[5]/p"));
		String menTshirtTotalPrice = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[5]/p")).getText();
		assertEquals(menTshirtTotalPrice, "Rs. 400");
		log.info(menTshirtTotalPrice);
		
	}
	
	public void verifyBlueTopQuantity() {
		
		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"product-1\"]/td[4]/button"));
		String blueTopQuantity = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[4]/button")).getText();
		assertEquals(blueTopQuantity, "4");
		log.info(blueTopQuantity);
		
	}
	
	public void verifyCartPage() {
		
		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]"));
		String shoppingCartLabel = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]")).getText();
		assertEquals(shoppingCartLabel, "Shopping Cart");
		log.info(shoppingCartLabel);
		
	}
	
	public void proceedToCheckout() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a"));
		
	}
	
	public void registerLoginAfterCheckoutClick() {
		
		WebElement registerLogin = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u"));
		assertNotNull(registerLogin, "Register / Login text is not visible.");
		
		myLibrary.clickButton(By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u"));
		
	}
	
	public void removeItem() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"product-1\"]/td[6]/a"));
		
	}
	
	public void verifyEmptyCart() {
		
		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"empty_cart\"]/p/b"));
		String emptyCartMessage = driver.findElement(By.xpath("//*[@id=\"empty_cart\"]/p/b")).getText();
		assertEquals(emptyCartMessage, "Cart is empty!");
		log.info(emptyCartMessage);
		
	}
	
	public void verifyPremiumPolo() {
		
		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"product-30\"]/td[2]/h4/a"));
		String verifyPremiumPolo = driver.findElement(By.xpath("//*[@id=\"product-30\"]/td[2]/h4/a")).getText();
		assertEquals(verifyPremiumPolo, "Premium Polo T-Shirts");
		log.info(verifyPremiumPolo);
		
	}
	
	public void clickSignupLogin() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
		
	}
	
	public void clickRegisterLoginPopup() {
		
		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u"));
		myLibrary.clickButton(By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u"));
		
	}

}
