package com.automation.base;

import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.automation.libraries.GlobalSelenium;

public class Base {
	public static final Logger log = LogManager.getLogger(Base.class);

	public static WebDriver driver;
	public static GlobalSelenium myLibrary;
	
	@BeforeMethod
	public void beforeEachTest() {
		log.info("Before each test...");
		
		myLibrary = new GlobalSelenium();
		driver = myLibrary.startAChromeBrowser();
	}

	@AfterMethod
	public void afterEachTest() {
		log.info("After each test...");
		myLibrary.cleanUpAfterEachTest();
	}
	
	// this method will only runs one-time before all the tests start
	@BeforeClass
	public void beforeClass() {
		log.info("Before class ...");		
		// 1) prepare test data, by insert into database using SQL queries
		// read from database using SQL queries
	}
	
	
	// this method will only runs one-time after all the tests are done
	@AfterClass
	public void afterClass() {
		log.info("After class...");
		// 1) delete test data, after test data was used by the automation
		// scripts, using SQL queries
		// 2) send custom email with test result reports.
	}
}





















