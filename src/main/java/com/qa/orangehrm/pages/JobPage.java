package com.qa.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.utils.Elementutil;

public class JobPage {

	WebDriver driver;
	Elementutil ele;

	public JobPage(WebDriver driver) {
		this.driver = driver;
		ele = new Elementutil(driver);
	}

	private By jobtitleheader = By.xpath("//h6[text()='Job Titles']");
	private By add = By.xpath("//button[normalize-space()='Add']");
	private By jobTitle = By.xpath("//label[text()='Job Title']/../following-sibling::div/input");
	private By jobDescription = By.xpath("//textarea[@placeholder='Type description here']");
	private By upload = By.cssSelector("input.oxd-file-input");
	private By addNote = By.xpath("//textarea[@placeholder='Add note']");
	private By save = By.xpath("//button[@type='submit']");
	private By row = By.xpath("(//div[@class='oxd-table-body']/div/div)");
	
	private By jobtitlecolumn =By.xpath("//div[@class='oxd-table-body']//div[@role='row']//div[@role='cell'][2]/div");
	private By editButton = By.xpath("//div[text()='Test Engineer']/../following-sibling::div[2]//button[last()]");
	private By deleteButton = By.xpath("//div[text()='SDET Test Engineer']/../following-sibling::div[2]//button[last()-1]");
	private By yesdel = By.xpath("//button[normalize-space()='Yes, Delete']");

	public boolean headervalidation() {
		WebElement waitForElementToBevisible = ele.waitForElementToBevisible(driver, jobtitleheader, 15);
		return ele.doIsDisplayed(jobtitleheader);
	}

	public void fillJobDetails(String jobTitle, String jobDescription, String filePath,String notes) {
		ele.doClick(add, driver, 10);
		ele.doSendkey(this.jobTitle, jobTitle, 15);
		ele.doSendkey(this.jobDescription, jobDescription);
		ele.doSendkey(upload, filePath);
		ele.doSendkey(addNote, notes);
		ele.doClick(save);
	}
	
	
	public boolean validateJobTitleAvailability(String jobTitleName) {
		List<WebElement> jobTitleElements = ele.waitForVisibilityofElementsLocated(jobtitlecolumn, 10);
	    for (WebElement element : jobTitleElements) {
	        String titlename = element.getText();
	        if (titlename.equals(jobTitleName)) {
	            return true;
	        }
	    }
	    return false;
	}



	public void deleteTitle(String jobTitleName) {
		List<WebElement> jobTitleElements = ele.waitForVisibilityofElementsLocated(jobtitlecolumn, 10);
		for (WebElement jobTitleElement : jobTitleElements) {
			String currentTitle = jobTitleElement.getText();
			if (currentTitle.equals(jobTitleName)) {
				ele.doClick(deleteButton);
				ele.doClick(yesdel,driver,10);
				break;
			}
		}
	}
	
	public void editJobtitle(String jobTitle) {
		List<WebElement> jobTitleElements = ele.waitForVisibilityofElementsLocated(jobtitlecolumn, 10);

	    for (WebElement jobTitleElement : jobTitleElements) {
	        String currentTitle = jobTitleElement.getText();

	        if (currentTitle.equals(jobTitle)) {
	            ele.doClick(editButton);
	            WebElement jobTitlField = ele.waitForElementToBevisible(driver, this.jobTitle, 10);
	            ele.doClick(this.jobTitle);
	            ele.doSendkey(this.jobTitle, Keys.CONTROL + "A"); // Select all text
	            jobTitlField.sendKeys(Keys.DELETE); // Delete the existing text
	            ele.doSendkey(this.jobTitle, "SDET Test Engineer");
	            ele.doClick(save);
	            break;
	        }
	    }
	}

	
	


		
		
	}


