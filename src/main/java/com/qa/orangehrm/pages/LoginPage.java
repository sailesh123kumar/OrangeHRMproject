package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.utils.Elementutil;

public class LoginPage {

	WebDriver driver;
	Elementutil ele;
	private By userName = By.name("username");
	private By password = By.name("password");
	private By submit = By.xpath("//button[@type='submit']");

	private By admin = By.xpath("//span[text()='Admin']");
	private By leave = By.xpath("//span[text()='Leave']");
	

	private By userImg = By.xpath("//img[@alt='profile picture']/following-sibling::p");
	private By logout = By.xpath("//a[text()='Logout']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		ele = new Elementutil(driver);
	}

	public void doLogin(String userName, String password) {

		ele.doSendkey(this.userName, userName, 10);
		ele.doSendkey(this.password, password);
		ele.doClick(submit);
		WebElement adminele = ele.waitForElementToBevisible(driver, this.admin, 10);
	}

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
		WebElement adminele = ele.waitForElementToBevisible(driver, this.admin, 10);
		ele.doClick(admin);	
		return new AdminPage(driver);
		}
	
	
	public LeavePage navigateToLeavePage() {
		WebElement adminele = ele.waitForElementToBevisible(driver, this.admin, 10);
		ele.doClick(leave);	
		return new LeavePage(driver);
		}
	
	public void logout() {
		ele.doClick(userImg);
		ele.doClick(logout);
		
	}

}
