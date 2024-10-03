package com.automationexercise.pageobjects;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.base.Base;

public class AccountDeletedPage extends Base{
	
	public void accountDeleted() {
		
		WebElement accountDeleted = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
		assertNotNull(accountDeleted, "Account deleted message is not visible.");
		
		myLibrary.clickButton(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
		
	}
	
	public void continueButton() {
		
		myLibrary.clickButton(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
		
	}

}
