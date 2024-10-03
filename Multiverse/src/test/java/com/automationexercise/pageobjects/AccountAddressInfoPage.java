package com.automationexercise.pageobjects;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.base.Base;

public class AccountAddressInfoPage extends Base {

	public void enterAccountInfo() {
		
		WebElement accountInfo = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"name\"]"));
		assertNotNull(accountInfo, "Account Information is not visible.");
		
		myLibrary.clickButton(By.xpath("//*[@id=\"id_gender1\"]"));
		
		String password = "hello" + Math.random();
		
		myLibrary.enterText(By.xpath("//*[@id=\"password\"]"), password);
		
		myLibrary.selectDropDown(By.xpath("//*[@id=\"days\"]"), "16");
		
		myLibrary.selectDropDown(By.xpath("//*[@id=\"months\"]"), "July");
		
		myLibrary.selectDropDown(By.xpath("//*[@id=\"years\"]"), "1985");
		
		myLibrary.clickButton(By.xpath("//*[@id=\"newsletter\"]"));
		
		myLibrary.clickButton(By.xpath("//*[@id=\"optin\"]"));
		
	}
	
	public void enterAddressInfo() {
		
		myLibrary.enterText(By.xpath("//*[@id=\"first_name\"]"), "Ron");
		
		myLibrary.enterText(By.xpath("//*[@id=\"last_name\"]"), "Swanson");
		
		myLibrary.enterText(By.xpath("//*[@id=\"company\"]"), "Gandhi Stadium");
		
		myLibrary.enterText(By.xpath("//*[@id=\"address1\"]"), "Kachahari Road");
		
		myLibrary.selectDropDown(By.xpath("//*[@id=\"country\"]"), "India");
		
		myLibrary.enterText(By.xpath("//*[@id=\"state\"]"), "Bihar");
		
		myLibrary.enterText(By.xpath("//*[@id=\"city\"]"), "Begusarai");
		
		myLibrary.enterText(By.xpath("//*[@id=\"zipcode\"]"), "851101");
		
		myLibrary.enterText(By.xpath("//*[@id=\"mobile_number\"]"), "501-205-0978");
		
		myLibrary.clickButton(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
		
	}

}
