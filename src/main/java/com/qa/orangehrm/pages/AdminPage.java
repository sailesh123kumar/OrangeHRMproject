package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.utils.Elementutil;

public class AdminPage {
	
	WebDriver driver;
	Elementutil ele;
	
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		ele = new Elementutil(driver);
	}
	
	private By userManagement = By.xpath("//span[text()='User Management ']");
	private By add = By.xpath("//button[normalize-space()='Add']");
	private By userRole = By.xpath("(//div[contains(text(),'Select')])[last()-1]");
	private By ess = By.xpath("//span[text()='ESS']");
	private By employeeName = By.xpath("//input[contains(@placeholder,'Type for hints')]");
	private By status = By.xpath("(//div[contains(text(),'Select')])[last()]");
	private By disabled = By.xpath("//span[text()='Disabled']");
	private By userName = By.xpath("//label[text()='Username']/../following-sibling::div/input");
	private By password = By.xpath("(//input[@type='password'])[last()-1]");
	private By confirm = By.xpath("(//input[@type='password'])[last()]");
	private By save = By.xpath("//button[@type='submit']");
	private By systemuser = By.xpath("//h5[text()='System Users']");
	private By search = By.xpath("//button[normalize-space()='Search']");
	private By delCheckBox = By.xpath("(//input[@type='checkbox']/following-sibling::span)[last()]");
	private By delBtn = By.cssSelector(".oxd-icon.bi-trash");
	private By yesdel = By.xpath("//button[normalize-space()='Yes, Delete']");
	
	private By job = By.xpath("//span[.='Job ']");
	private By jobtitles = By.xpath("//a[.='Job Titles']");
	
		
	
	public boolean checkUserManagementElementAvailability() {
		ele.waitForElementToBevisible(driver, userManagement, 10);
		boolean doIsDisplayed = ele.doIsDisplayed(userManagement);
		return doIsDisplayed;
	}
	
	
	
	public String checkUserPresence(String userName) {
		By tablevalidation = By.xpath("//div[text()='"+userName+"']");
		ele.waitForElementToBevisible(driver, tablevalidation, 10);
		return ele.doGetText(tablevalidation);
	}
	
	
	private void clickaddbtn() {
		ele.doClick(add, driver, 5);
	}
	
	public void adduserdetails(String userName, String password , String employeeName) {
		By suggestlist = By.xpath("//span[text()='"+employeeName+"']");
		clickaddbtn();
		ele.doClick(userRole, driver, 5);
		ele.doClick(ess);
		ele.doSendkey(this.employeeName, employeeName);
		ele.doClick(suggestlist, driver, 10);
		ele.doClick(status);
		ele.doClick(disabled);
		ele.doSendkey(this.userName, userName);
		ele.doSendkey(this.password, password);
		ele.doSendkey(confirm, password);
		ele.doClick(save);
	}
	
	
	public void searchUser(String userName) {
		ele.waitForElementToBevisible(driver, systemuser, 10);
		ele.doSendkey(this.userName, userName);
		ele.doClick(search);
	}
	
	
	public void deleteUser() {
		ele.doClick(delCheckBox,driver,10);
		ele.doClick(delBtn);
		ele.doClick(yesdel,driver,10);
	}
	
	
	public JobPage navigateToJobTitle() {
		ele.doClick(job, driver, 10);
		ele.doClick(jobtitles, driver, 3);
		return new JobPage(driver);
	}
	
	
	
	
	

}
