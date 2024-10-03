package com.automationexercise.tests;

import org.testng.annotations.Test;
import com.automation.base.Base;
import com.automationexercise.pageobjects.AccountAddressInfoPage;
import com.automationexercise.pageobjects.AccountCreatedPage;
import com.automationexercise.pageobjects.AccountDeletedPage;
import com.automationexercise.pageobjects.BlueTopPage;
import com.automationexercise.pageobjects.CartPage;
import com.automationexercise.pageobjects.CheckoutPage;
import com.automationexercise.pageobjects.ContactUsPage;
import com.automationexercise.pageobjects.FirstProductPage;
import com.automationexercise.pageobjects.HomePage;
import com.automationexercise.pageobjects.MadameBrandProductsPage;
import com.automationexercise.pageobjects.MenJeansProductsPage;
import com.automationexercise.pageobjects.PaymentPage;
import com.automationexercise.pageobjects.PoloBrandProductsPage;
import com.automationexercise.pageobjects.ProductsPage;
import com.automationexercise.pageobjects.SignupLoginPage;
import com.automationexercise.pageobjects.TestCasesPage;
import com.automationexercise.pageobjects.WomenDressProductsPage;

public class AutomationExerciseTests extends Base{
	
	HomePage homePage = new HomePage();
	SignupLoginPage signupLoginPage = new SignupLoginPage();
	AccountAddressInfoPage accountAddressInfo = new AccountAddressInfoPage();
	AccountCreatedPage accountCreatedPage = new AccountCreatedPage();
	AccountDeletedPage accountDeletedPage = new AccountDeletedPage();
	ContactUsPage contactUsPage = new ContactUsPage();
	TestCasesPage testCasesPage = new TestCasesPage();
	ProductsPage productsPage = new ProductsPage();
	FirstProductPage firstProductPage = new FirstProductPage();
	CartPage cartPage = new CartPage();
	BlueTopPage blueTopPage = new BlueTopPage();
	CheckoutPage checkoutPage = new CheckoutPage();
	PaymentPage paymentPage = new PaymentPage();
	WomenDressProductsPage womenDressProductsPage = new WomenDressProductsPage();
	MenJeansProductsPage menJeansProductsPage = new MenJeansProductsPage();
	PoloBrandProductsPage poloBrandProductsPage = new PoloBrandProductsPage();
	MadameBrandProductsPage madameBrandProductsPage = new MadameBrandProductsPage();
	
	// Register User
	@Test (priority = 1)
	public void testCase1() {
		
		homePage.goToAutomationExerciseSite();
		homePage.clickSignupLogin();
		
		signupLoginPage.newUserSignup();
		
		accountAddressInfo.enterAccountInfo();
		accountAddressInfo.enterAddressInfo();
		
		accountCreatedPage.clickContinue();
		
		homePage.verifyUsername();
		homePage.deleteAccount();
		
		accountDeletedPage.accountDeleted();
	}
	
	// Login User with correct email and password
	@Test (priority = 2)
	public void testCase2() {
		
		homePage.goToAutomationExerciseSite();
		homePage.clickSignupLogin();
		
		signupLoginPage.loginToValidAccount();
		
		homePage.verifyUsername();
		
		//Test case states to delete account as last step. Unsure why.
		
	}
	
	// Login User with incorrect email and password
	@Test (priority = 3)
	public void testCase3() {
		
		homePage.goToAutomationExerciseSite();
		homePage.clickSignupLogin();
		
		signupLoginPage.loginToInvalidAccount();
		
	}
		
	// Logout User
	@Test (priority = 4)
	public void testCase4() {
		
		homePage.goToAutomationExerciseSite();
		homePage.clickSignupLogin();
		
		signupLoginPage.loginToValidAccount();
		
		homePage.verifyUsername();
		homePage.logoutOfAccount();
		
		signupLoginPage.verifyLoginPage();
		
	}
	
	// Register User with existing email
	@Test (priority = 5)
	public void testCase5() {
		
		homePage.goToAutomationExerciseSite();
		homePage.clickSignupLogin();
		
		signupLoginPage.signupPriorRegisteredUser();
		
	}
	
	// Contact Us Form
	@Test (priority = 6)
	public void testCase6() {
		
		homePage.goToAutomationExerciseSite();
		homePage.clickContactUs();
		
		contactUsPage.getInTouch();
		contactUsPage.goToHomePage();
		
	}
	
	@Test (priority = 7)
	public void testCase7() {
		
		homePage.goToAutomationExerciseSite();
		homePage.clickTestCases();
		
		testCasesPage.verifyPage();
		
	}
	
	@Test (priority = 8)
	public void testCase8() {
		
		homePage.goToAutomationExerciseSite();
		homePage.clickProducts();
		
		productsPage.verifyPage();
		productsPage.clickFirstProduct();
		
		firstProductPage.verifyProductDetails();
		
	}
	
	@Test (priority = 9)
	public void testCase9() {
		
		homePage.goToAutomationExerciseSite();
		homePage.clickProducts();
		
		productsPage.verifyPage();
		productsPage.searchProduct();
		productsPage.verifySearchedProducts();
		
	}
	
	@Test (priority = 10)
	public void testCase10() {
		
		homePage.goToAutomationExerciseSite();
		homePage.scrollToSubscription();
		homePage.subscribe();
		
	}
	
	@Test (priority = 11)
	public void testCase11() {
		
		homePage.goToAutomationExerciseSite();
		homePage.clickCart();
		
		cartPage.verifySubscriptionText();
		cartPage.subscribe();
		
	}
	
	@Test (priority = 12)
	public void testCase12() {
		
		homePage.goToAutomationExerciseSite();
		homePage.clickProducts();
		
		productsPage.firstProductMouseOverAddToCart();
		productsPage.continueShopping();
		productsPage.secondProductMouseOverAddToCart();
		productsPage.goToCart();
		
		cartPage.verifyBlueTop();
		cartPage.verifyMenTshirt();
		
	}
	
	@Test (priority = 13)
	public void testCase13() {
		
		homePage.goToAutomationExerciseSite();
		homePage.viewFirstProduct();
		
		blueTopPage.verifyBlueTopDetails();
		blueTopPage.clearQuantity();
		blueTopPage.enterQuantity();
		blueTopPage.addToCart();

		cartPage.verifyBlueTopQuantity();
		
	}
	
	@Test (priority = 14)
	public void testCase14() {
		
		homePage.goToAutomationExerciseSite();
		myLibrary.delay(0.5); //For some reason, this test consistently fails without the explicit wait.
		homePage.firstProductMouseOverAddToCart();
		homePage.clickViewCart();
		
		cartPage.verifyCartPage();
		cartPage.proceedToCheckout();
		cartPage.registerLoginAfterCheckoutClick();
		
		signupLoginPage.newUserSignup();
		
		accountAddressInfo.enterAccountInfo();
		accountAddressInfo.enterAddressInfo();
		
		accountCreatedPage.clickContinue();
		
		homePage.verifyUsername();
		homePage.clickCart();
		
		cartPage.proceedToCheckout();
		
		checkoutPage.verifyDeliveryAddress();
		checkoutPage.verifyBillingAddress();
		checkoutPage.enterComment();
		checkoutPage.clickPlaceOrderButton();
		
		paymentPage.paymentDetails();
		paymentPage.clickPayAndConfirmOrderButton();
		paymentPage.verifyOrderPlaced();
		paymentPage.deleteAccount();
		
		accountDeletedPage.continueButton();
		
	}
	
	@Test (priority = 15)
	public void testCase15() {
		
		homePage.goToAutomationExerciseSite();
		homePage.clickSignupLogin();
		
		signupLoginPage.newUserSignup();
		
		accountAddressInfo.enterAccountInfo();
		accountAddressInfo.enterAddressInfo();
		
		accountCreatedPage.clickContinue();
		
		homePage.verifyUsername();
		myLibrary.delay(0.5);
		homePage.firstProductMouseOverAddToCart();
		homePage.clickViewCart();
		
		cartPage.verifyCartPage();
		cartPage.proceedToCheckout();
		
		checkoutPage.verifyDeliveryAddress();
		checkoutPage.verifyBillingAddress();
		checkoutPage.enterComment();
		checkoutPage.clickPlaceOrderButton();
		
		paymentPage.paymentDetails();
		paymentPage.clickPayAndConfirmOrderButton();
		paymentPage.verifyOrderPlaced();
		paymentPage.deleteAccount();
		
		accountDeletedPage.continueButton();
		
	}
	
	@Test (priority = 16)
	public void testCase16() {
		
		homePage.goToAutomationExerciseSite();
		homePage.clickSignupLogin();
		
		signupLoginPage.loginToValidAccount();
		
		homePage.verifyUsername();
		myLibrary.delay(0.5);
		homePage.firstProductMouseOverAddToCart();
		homePage.clickViewCart();
		
		cartPage.verifyCartPage();
		cartPage.proceedToCheckout();
		
		checkoutPage.verifyDeliveryAddress();
		checkoutPage.verifyBillingAddress();
		checkoutPage.enterComment();
		checkoutPage.clickPlaceOrderButton();
		
		paymentPage.paymentDetails();
		paymentPage.clickPayAndConfirmOrderButton();
		paymentPage.verifyOrderPlaced();
		
		//Test case wants account deleted afterward, but that doesn't seem realistic. Plus, I want to use the same info in other cases.
		
	}
	
	@Test (priority = 17)
	public void testCase17() {
		
		homePage.goToAutomationExerciseSite();
		myLibrary.delay(0.5); //For some reason, this test consistently fails without the explicit wait.
		homePage.firstProductMouseOverAddToCart();
		homePage.clickViewCart();
		
		cartPage.verifyCartPage();
		cartPage.removeItem();
		cartPage.verifyEmptyCart();
		
	}
	
	@Test (priority = 18)
	public void testCase18() {
		
		homePage.goToAutomationExerciseSite();
		homePage.verifyCategories();
		homePage.clickWomenCategory();
		homePage.clickDressWomenCategory();
		
		womenDressProductsPage.verifyWomenDressProductsText();
		womenDressProductsPage.expandMenCategory();
		womenDressProductsPage.clickMenJeansCategory();
		
		menJeansProductsPage.verifyMenJeansProductsText();
		
	}
	
	@Test (priority = 19)
	public void testCase19() {
		
		homePage.goToAutomationExerciseSite();
		homePage.clickProducts();
		
		productsPage.verifyBrandsVisibility(); //
		productsPage.clickPoloBrand();
		
		poloBrandProductsPage.verifyPoloProducts();
		poloBrandProductsPage.clickMadameBrand();
		
		madameBrandProductsPage.verifyMadameProducts();
		
	}
	
	@Test (priority = 20)
	public void testCase20() {
		
		homePage.goToAutomationExerciseSite();
		homePage.clickProducts();
		
		productsPage.verifyPage();
		productsPage.searchProduct();
		productsPage.verifySearchedProducts();
		productsPage.premiumPoloSearchFirstItemMouseOverAddToCart();
		productsPage.goToCart();
		
		cartPage.verifyPremiumPolo();
		cartPage.clickSignupLogin();
		
		signupLoginPage.loginToValidAccount();
		
		homePage.clickCart();
		
		cartPage.verifyPremiumPolo();
		
	}
	
	@Test (priority = 21)
	public void testCase21() {
		
		homePage.goToAutomationExerciseSite();
		homePage.clickProducts();
		
		productsPage.verifyPage();
		productsPage.clickFirstProduct();
		
		firstProductPage.verifyWriteYourReview();
		firstProductPage.fillReviewForm();
		firstProductPage.submitReview();
		firstProductPage.verifyThankYouReview();
		
	}
	
	@Test (priority = 22)
	public void testCase22() {
		
		homePage.goToAutomationExerciseSite();
		homePage.scrollToRecommendedItems();
		homePage.addBlueTopFromRecommendedItems();
		homePage.clickViewCart();
		
		cartPage.verifyBlueTop();
		
	}
	
	@Test (priority = 23)
	public void testCase23() {
		
		homePage.goToAutomationExerciseSite();
		homePage.clickSignupLogin();
		
		signupLoginPage.newUserSignup();
		
		accountAddressInfo.enterAccountInfo();
		accountAddressInfo.enterAddressInfo();
		
		accountCreatedPage.clickContinue();
		
		homePage.verifyUsername();
		homePage.firstProductMouseOverAddToCart();
		homePage.clickViewCart();
		
		cartPage.proceedToCheckout();
		
		checkoutPage.verifyDeliveryAddress();
		checkoutPage.verifyBillingAddress();
		//Test case asks to verify the address is the same as the one used to register the account. There's no way to see what address was used
		//to register the account. 
		checkoutPage.deleteAccount();
		
		accountDeletedPage.accountDeleted();
		
	}
	
	@Test (priority = 24)
	public void testCase24() {
		
		homePage.goToAutomationExerciseSite();
		homePage.firstProductMouseOverAddToCart();
		homePage.clickViewCart();
		
		cartPage.verifyCartPage();
		cartPage.proceedToCheckout();
		cartPage.clickRegisterLoginPopup();
		
		signupLoginPage.newUserSignup();
		
		accountAddressInfo.enterAccountInfo();
		accountAddressInfo.enterAddressInfo();
		
		accountCreatedPage.clickContinue();

		homePage.verifyUsername();
		homePage.clickCart();
		
		cartPage.proceedToCheckout();
		
		checkoutPage.verifyDeliveryAddress();
		checkoutPage.verifyBillingAddress();
		checkoutPage.enterComment();
		checkoutPage.clickPlaceOrderButton();
		
		paymentPage.paymentDetails();
		paymentPage.clickPayAndConfirmOrderButton();
		paymentPage.verifyOrderPlaced();
		paymentPage.downloadInvoice();
		paymentPage.clickContinueButton();
		//Still need to figure out how to verify download
		
		homePage.deleteAccount();
		
		accountDeletedPage.accountDeleted();
		
	}
	
	@Test (priority = 25)
	public void testCase25() {
		
		homePage.goToAutomationExerciseSite();
		homePage.scrollToVeryBottom();
		myLibrary.delay(0.5);
		homePage.clickArrowToGoTopPage();
		homePage.verifyFullFledgedText();
		
	}
	
	@Test (priority = 26)
	public void testCase26() {
		
		homePage.goToAutomationExerciseSite();
		homePage.scrollToVeryBottom();
		homePage.verifySubscriptionText();
		myLibrary.delay(1);
		homePage.scrollToVeryTop();
		
	}

}
