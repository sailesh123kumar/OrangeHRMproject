package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.utils.Elementutil;

public class HomePage {
	
	WebDriver driver;
	Elementutil ele;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		ele = new Elementutil(driver);
	}
	
	private By admin = By.xpath("//span[text()='Admin']");
	private By leave = By.xpath("//span[text()='Leave']");
	
	public boolean checkMenuElementAvailability(String elementName) {
		By text = By.xpath("//span[text()='" + elementName + "']");
		boolean doIsDisplayed = ele.doIsDisplayed(text);
		return doIsDisplayed;

	}

	public boolean checkWidgetElementAvailability(String elementName) {
		By text = By.xpath("//p[text()='"+elementName+"']");
		boolean doIsDisplayed = ele.doIsDisplayed(text);
		return doIsDisplayed;

	}
	
	public AdminPage navigateToAdminPage() {
		ele.waitForElementToBevisible(driver, this.admin, 10);
		ele.doClick(admin);	
		return new AdminPage(driver);
		}
	
	public LeavePage navigateToLeavePage() {
		ele.waitForElementToBevisible(driver, this.admin, 10);
		ele.doClick(leave);	
		return new LeavePage(driver);
		}

}
