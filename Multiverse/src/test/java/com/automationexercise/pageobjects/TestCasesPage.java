package com.automationexercise.pageobjects;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.base.Base;

public class TestCasesPage extends Base{
	
	public void verifyPage() {
		
		WebElement testCasesPage = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2/b"));
		assertNotNull(testCasesPage, "User was was not sent to Test Cases page.");
		
	}

}
