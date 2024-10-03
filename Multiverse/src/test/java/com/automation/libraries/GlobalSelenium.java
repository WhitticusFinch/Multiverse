package com.automation.libraries;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalSelenium {
	public static final Logger log = LogManager.getLogger(GlobalSelenium.class);

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriver startAChromeBrowser() {
		try {
			driver = new ChromeDriver();
			delay(5);
			driver.manage().window().maximize();
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return driver;
	}

	public void cleanUpAfterEachTest() {
		try {
			delay(2);
			// close the browser
			driver.close();
			// kill the driver object or process
			driver.quit();
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void gotoWebsite(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public String getWebsiteTitle() {
		String title = null;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return title;
	}

	public void enterText(By by, String textValue) {
		try {
			WebElement element = driver.findElement(by);
			element.clear();
			element.sendKeys(textValue);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void enterText(WebElement element, String textValue) {
		try {
			element.clear();
			element.sendKeys(textValue);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void selectDropDown(By by, String visibleTextOption) {
		try {
			WebElement element = driver.findElement(by);
			Select select = new Select(element);
			select.selectByVisibleText(visibleTextOption);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void clickButton(By by) {
		try {
			WebElement element = driver.findElement(by);
			element.click();
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void clickButton(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void delay(double inSeconds) {
		try {
			long millisec = (long) (inSeconds * 1000);
			Thread.sleep(millisec);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void scrollToElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void scrollIntoView(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.scrollToElement(element);
			actions.build().perform();
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void fileUpload(By by, String uploadFilePath) {
		try {
			WebElement uploadElem = driver.findElement(by);
			scrollIntoView(uploadElem);
			// delay(3);
			String abPath = getAbsuluteFilePath(uploadFilePath);
			uploadElem.sendKeys(abPath);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void handleCheckBox(By by, boolean isUserCheckBox) {
		try {
			WebElement checkBoxElement;
			// user wants to check the box
			if (isUserCheckBox == true) {
				checkBoxElement = driver.findElement(by);
				// get checkbox state
				boolean checkboxState = checkBoxElement.isSelected();
				if (checkboxState == true) {
					// do nothing
					log.debug("1) user wants to checkbox, box is already checked, selenium do nothing.");
				} else {
					checkBoxElement.click();
					log.debug("2) user wants to checkbox, box is Not checked, selenium do click.");
				}
			} else {
				checkBoxElement = driver.findElement(by);
				// get checkbox state
				boolean checkboxState = checkBoxElement.isSelected();
				if (checkboxState == true) {
					checkBoxElement.click();
					log.debug("3) user wants to uncheck box, box is already checked, selenium do click.");
				} else {
					// do nothing
					log.debug("4) user wants to uncheck box, box is Not checked, selenium do nothing.");
				}
			}
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	// explicit wait
	public WebElement waitForElementVisibility(By by) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			if (element == null) {
				log.info("Element is not visible within 30 seconds.");
			}
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return element;
	}

	public void highlightElement(WebElement element) {
		try {
			for (int i = 1; i < 4; i++) {
				WrapsDriver wrappedElement = (WrapsDriver) element;
				JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
						"color: red; border: 2px solid yellow");
				delay(0.5);
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
				delay(0.5);
			}
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void highlightElement(By by) {
		try {
			WebElement element = driver.findElement(by);
			highlightElement(element);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void clickHiddenElement(By by) {
		try {
			WebElement element = driver.findElement(by);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void clickHiddenElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public WebDriver swtichToBrowserWindowByIndex(int index) {
		int totalBrowsers = 0;
		try {
			Set<String> setAllBrowsers = driver.getWindowHandles();
			totalBrowsers = setAllBrowsers.size();
			if (index < totalBrowsers) {
				List<String> listBrowsers = new ArrayList<String>();
				for (String browser : setAllBrowsers) {
					listBrowsers.add(browser);
				}
				String windowName = listBrowsers.get(index);
				driver = driver.switchTo().window(windowName);
			} else {
				int tempBrowser = index + 1;
				System.err.println("There are only [" + totalBrowsers + "] open browser availabe,"
						+ "can't switch to browser number [" + tempBrowser + "], that doesn't exist!");
			}
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return driver;
	}

	public void moveToElement(By by) {
		try {
			WebElement element = driver.findElement(by);
			highlightElement(element);
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			delay(0.5);			
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void moveToElement(WebElement fromElem, WebElement toElem) {
		try {
			highlightElement(fromElem);
			Actions action1 = new Actions(driver);
			Actions action2 = action1.moveToElement(fromElem);
			delay(2);
			highlightElement(toElem);
			action2.moveToElement(toElem).build().perform();			
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	////////////////////// this is java utility methods///
	//////////// temporarily we will have them here //////

	public String getAbsuluteFilePath(String relativePath) {
		String finalPath = null;
		try {
			File file = new File(relativePath);
			finalPath = file.getAbsolutePath();
			log.info("file full path: " + finalPath);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return finalPath;
	}

	public String getCurrentTime() {
		String finalTimeStamp = null;
		try {
			Date date = new Date();
			String tempTime = new Timestamp(date.getTime()).toString();
			finalTimeStamp = tempTime.replace('-', '_').replace(':', '_').replace('.', '_').replace(' ', '_')
					.replaceAll("_", "");
			// System.out.println("current time: " + tempTime);
			log.info("timestamp: " + finalTimeStamp);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return finalTimeStamp;
	}

//	
//	public static void main(String[] args) {
//		getCurrentTime();
//
//	}

}
