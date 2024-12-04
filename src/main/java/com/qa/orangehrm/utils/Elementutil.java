package com.qa.orangehrm.utils;

import java.time.Duration;

import javax.swing.text.html.parser.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Elementutil {
	
	WebDriver driver;
	
	public Elementutil(WebDriver driver) {
		this.driver=driver;
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
	
	public void doSendkey(By locator , String value) {
		nullcheck(value);
		getElement(locator).sendKeys(value);
	}
	
	public void doSendkey(By locator , String value , int timeOut) {
		nullcheck(value);
		WebElement element = waitForElementToBevisible(driver, locator, timeOut);
		element.sendKeys(value);
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
	
	

}
