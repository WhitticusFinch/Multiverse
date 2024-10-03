package com.automationexercise.pageobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automation.base.Base;

public class ProductsPage extends Base{
	
	public void verifyPage() {
		
		WebElement productsPage = myLibrary.waitForElementVisibility(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/h2"));
		assertNotNull(productsPage, "User was was not sent to Products page.");
		
	}
	
	public void clickFirstProduct() {
		
		myLibrary.clickButton(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[2]/ul/li/a"));
		
	}
	
	public void searchProduct() {
		
		myLibrary.enterText(By.xpath("//*[@id=\"search_product\"]"), "Premium Polo");
		
		myLibrary.clickButton(By.xpath("//*[@id=\"submit_search\"]"));
		
	}
	
	public void verifySearchedProducts() {
		
		WebElement searchedProducts = myLibrary.waitForElementVisibility(By.xpath("/html/body/section[2]/div/div/div[2]/div/h2"));
		assertNotNull(searchedProducts, "Searched Products text is not visible.");
		
	}
	
	public void firstProductMouseOverAddToCart() {
		
		WebElement overlay = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(overlay).perform();
		
		myLibrary.clickButton(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a"));
		
	}
	
	public void continueShopping() {
		
		WebElement continueShoppingButton = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button"));
		assertNotNull(continueShoppingButton, "Continue shopping button is not visible.");
		
		myLibrary.clickButton(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button"));
		
	}
	
	public void secondProductMouseOverAddToCart() {
		
		WebElement overlay = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[3]/div/div[1]/div[2]"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(overlay).perform();
		
		myLibrary.clickButton(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a"));
		
	}
	
	public void goToCart() {
		
		WebElement viewCartLink = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"));
		assertNotNull(viewCartLink, "View cart link is not visible.");
		
		myLibrary.clickButton(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"));
		
	}
	
	public void verifyBrandsVisibility() {
		
		myLibrary.waitForElementVisibility(By.xpath("/html/body/section[2]/div[1]/div/div[1]/div/div[2]/h2"));
		String brandsVisiblity = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[1]/div/div[2]/h2")).getText();
		assertEquals(brandsVisiblity, "BRANDS");
		log.info(brandsVisiblity);
		
	}
	
	public void clickPoloBrand() {
		
		myLibrary.waitForElementVisibility(By.xpath("/html/body/section[2]/div[1]/div/div[1]/div/div[2]/div/ul/li[1]/a"));
		
		myLibrary.clickButton(By.xpath("/html/body/section[2]/div[1]/div/div[1]/div/div[2]/div/ul/li[1]/a"));
		
	}
	
	public void premiumPoloSearchFirstItemMouseOverAddToCart() {
		
		WebElement overlay = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(overlay).perform();
		
		myLibrary.clickButton(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a"));
		
	}

}
