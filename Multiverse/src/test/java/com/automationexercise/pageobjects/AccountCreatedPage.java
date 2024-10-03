package com.automationexercise.pageobjects;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.base.Base;

public class AccountCreatedPage extends Base{
	
	public void clickContinue() {
		
		WebElement accountCreated = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
		assertNotNull(accountCreated, "Account created message is not visible.");
		
		myLibrary.clickButton(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
		
	}

}
