package com.automationexercise.pageobjects;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.Base;

public class ContactUsPage extends Base{
	
	public void getInTouch() {
		
		WebElement getInTouchText = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2"));
		assertNotNull(getInTouchText, "Get In Touch text is not visible.");
		
		myLibrary.enterText(By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input"), "Jerry Seinfeld");
		myLibrary.enterText(By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input"), "littlejerry1234567890@gmail.com");
		myLibrary.enterText(By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input"), "I Dislike You");
		myLibrary.enterText(By.xpath("//*[@id=\"message\"]"), "I do not wish to do business with you any longer.");
		
		driver.findElement(By.name("upload_file")).sendKeys("C:\\Users\\Eric\\Pictures\\MSI Wallpaper\\MSI_MPG.jpg");
		
		myLibrary.clickButton(By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input"));
		
		driver.switchTo().alert().accept();
		
		WebElement successMessage = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]"));
		assertNotNull(successMessage, "Success message is not visible.");
		
	}
	
	public void goToHomePage() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
		
	}

}
