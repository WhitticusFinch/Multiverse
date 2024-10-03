package com.automationexercise.pageobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.base.Base;

public class SignupLoginPage extends Base {

	public AccountAddressInfoPage newUserSignup() {

		WebElement newUserSignup = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
		assertNotNull(newUserSignup, "New User Signup text boxes are not visible.");

		WebElement accountLogin = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"));
		assertNotNull(accountLogin, "Account login is not visible.");

		String name = "johndoe" + Math.random();
		String email = "doe" + Math.random() + "@gmail.com";

		myLibrary.enterText(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"), name);

		myLibrary.enterText(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"), email);

		myLibrary.clickButton(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));

		AccountAddressInfoPage accountAddressInfo = new AccountAddressInfoPage();
		return accountAddressInfo;

	}

	public void loginToValidAccount() {

		WebElement loginToAccount = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"));
		assertNotNull(loginToAccount, "Login to account text is not visible.");

		myLibrary.enterText(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"), "moefoe@gmail.com");

		myLibrary.enterText(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"), "dog1");

		myLibrary.clickButton(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));

	}

	public void loginToInvalidAccount() {

		WebElement loginToAccount = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"));
		assertNotNull(loginToAccount, "Login to account text is not visible.");

		myLibrary.enterText(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"), "meepmorp@gmail.com");

		myLibrary.enterText(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"), "stank");

		myLibrary.clickButton(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
		
		WebElement emailOrPasswordIncorrect = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p"));
		assertNotNull(emailOrPasswordIncorrect, "Your email or password is incorrect alert is not visible.");

	}
	
	public void signupPriorRegisteredUser() {
		
		WebElement newUserSignup = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
		assertNotNull(newUserSignup, "New User Signup text boxes are not visible.");
		
		myLibrary.enterText(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"), "Moe Foe");
		
		myLibrary.enterText(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"), "moefoe@gmail.com");
		
		myLibrary.clickButton(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
		
		WebElement addressAlreadyExists = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p"));
		assertNotNull(addressAlreadyExists, "New User Signup text boxes are not visible.");
		
	}
	
	public void verifyLoginPage() {
		
		myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
		String loginText = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2")).getText();
		assertEquals(loginText, "Login to your account");
		log.info(loginText);
		
	}

}
