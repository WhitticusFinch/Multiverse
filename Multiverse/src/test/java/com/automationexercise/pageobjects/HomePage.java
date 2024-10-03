package com.automationexercise.pageobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automation.base.Base;

public class HomePage extends Base{
	
	public void goToAutomationExerciseSite() {
		
		myLibrary.gotoWebsite("https://automationexercise.com/");
		
	}
	
	public SignupLoginPage clickSignupLogin() {
		
		WebElement signupLoginButton = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
		assertNotNull(signupLoginButton, "Signup / Login button is not visible.");
		
		myLibrary.clickButton(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
		
		SignupLoginPage signupLoginPage = new SignupLoginPage();
		return signupLoginPage;
		
	}
	
	public void verifyUsername() {
		
		WebElement verifyUsername = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b"));
		assertNotNull(verifyUsername, "Username is not displayed.");
		
	}
	
	public void deleteAccount() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
		
	}
	
	public void logoutOfAccount() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
		
	}
	
	public void clickContactUs() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a"));
		
	}
	
	public void clickTestCases() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
		
	}
	
	public void clickProducts() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
		
	}
	
	public void scrollToSubscription() {
		
		WebElement subscription = driver.findElement(By.xpath("//*[@id=\"susbscribe_email\"]"));
		
		myLibrary.scrollToElement(subscription);
		
		WebElement subscriptionText = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2"));
		assertNotNull(subscriptionText, "The SUBSCRIPTION text is not visible.");
		
	}
		
	public void subscribe() {
		
		myLibrary.enterText(By.xpath("//*[@id=\"susbscribe_email\"]"), "moefoe@gmail.com");
		
		myLibrary.clickButton(By.xpath("//*[@id=\"subscribe\"]/i"));
		
		WebElement subscriptionSuccessNotification = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"success-subscribe\"]/div"));
		assertNotNull(subscriptionSuccessNotification, "Subscription success notification is not visible.");
		
	}
	
	public void clickCart() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a"));
		
	}
	
	public void viewFirstProduct() {
		
		myLibrary.clickButton(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a"));
		
	}
	
	public void firstProductMouseOverAddToCart() {
		
		WebElement overlay = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(overlay).perform();
		
		myLibrary.clickButton(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a"));
		
		WebElement continueShoppingButton = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button"));
		assertNotNull(continueShoppingButton, "Continue shopping button is not visible.");
		
	}
	
	public void clickViewCart() {
		
		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"));
		String categoryVisiblity = driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")).getText();
		assertEquals(categoryVisiblity, "View Cart");
		log.info(categoryVisiblity);
		
		myLibrary.clickButton(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"));
		
	}
	
	public void verifyCategories() {
		
		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a"));
		String categoryVisiblity = driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a")).getText();
		assertEquals(categoryVisiblity, "WOMEN");
		log.info(categoryVisiblity);
		
	}
	
	public void clickWomenCategory() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a/span/i"));
		
	}
	
	public void clickDressWomenCategory() {
		
		myLibrary.waitForElementVisibility(By.xpath("/html/body/section[2]/div[1]/div/div[1]/div/div[1]/div[1]/div[2]/div/ul/li[1]/a"));
		
		myLibrary.clickButton(By.xpath("/html/body/section[2]/div[1]/div/div[1]/div/div[1]/div[1]/div[2]/div/ul/li[1]/a"));
		
	}
	
	public void scrollToRecommendedItems() {
		
		WebElement recommendedItems = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[2]/h2"));
		
		myLibrary.scrollToElement(recommendedItems);
		
	}
	
	public void addBlueTopFromRecommendedItems() {
		
		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[1]/div[1]/div/div/div/p"));
		String blueTop = driver.findElement(By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[1]/div[1]/div/div/div/p")).getText();
		assertEquals(blueTop, "Blue Top");
		log.info(blueTop);
		
		myLibrary.clickButton(By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[1]/div[1]/div/div/div/a"));
		
	}
	
	public void scrollToVeryBottom() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	public void hideFooterAd() {
		
		myLibrary.clickButton(By.xpath("/html/body/ins[2]/div[1]//ins/span/svg/path"));
		
	}
	
	public void clickArrowToGoTopPage() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"scrollUp\"]/i"));
		
	}
	
	public void verifyFullFledgedText() {
		
		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"slider-carousel\"]/div/div[1]/div[1]/h2"));
		String fullFledged = driver.findElement(By.xpath("//*[@id=\"slider-carousel\"]/div/div[1]/div[1]/h2")).getText();
		assertEquals(fullFledged, "Full-Fledged practice website for Automation Engineers");
		log.info(fullFledged);
		
	}
	
	public void verifySubscriptionText() {
		
		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2"));
		String subscriptionText = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")).getText();
		assertEquals(subscriptionText, "SUBSCRIPTION");
		log.info(subscriptionText);
		
	}
	
	public void scrollToVeryTop() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		
	}

}
