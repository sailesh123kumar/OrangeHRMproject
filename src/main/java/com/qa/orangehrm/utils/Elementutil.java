package com.qa.orangehrm.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Elementutil {
	
	WebDriver driver;
	
	public Elementutil(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	private void nullcheck(String value) {
		if (value == null) {
			throw new RuntimeException("VALUE IS NULL..." + value);
		}
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public void doClick(By locator,WebDriver driver,int time) {
		waitForElementToBevisible(driver, locator, time).click();
	}
	
	
	public void doClear(By locator) {
		getElement(locator).clear();
	}
	
	public void doSendkey(By locator , String value) {
		nullcheck(value);
		getElement(locator).sendKeys(value);
	}
	
	public void doSendkey(By locator , Keys value) {
		getElement(locator).sendKeys(value);
	}
	
	public void doSendkey(By locator , String value , int timeOut) {
		nullcheck(value);
		WebElement element = waitForElementToBevisible(driver, locator, timeOut);
		element.clear();
		element.sendKeys(value);
	}
	
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			if (text.length() != 0) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}
	
	public boolean doIsDisplayed(By locator) {
		try {
			boolean flag = getElement(locator).isDisplayed();
			System.out.println("element is displayed " + locator);
			return flag;
		} catch (NoSuchElementException e) {
			System.out.println("element with locator " + locator + " is not displayed");
			return false;
		}
		
	}
	
	
	
	
	public WebElement waitForElementToBevisible(WebDriver driver,By locator,int time) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}
	
	/**
	 * An expectation for checking that all elements present on the web page that match the locator are visible. 
	 * Visibility means that the elements are not only displayed but also have a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public List<WebElement> waitForVisibilityofElementsLocated(By locator,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}
		catch (TimeoutException e) {
			return List.of(); //Return Empty Array List
		}
	}
	
	

}
