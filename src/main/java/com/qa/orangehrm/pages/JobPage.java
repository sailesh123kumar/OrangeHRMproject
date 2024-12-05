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

	// (//div[@class='oxd-table-body']/div/div)//div[@role='cell'][2]

	private By validateJobTitle = By.xpath("//div[text()='Test Engineer']");
	private By editJobTitle = By
			.xpath("(//div[text()='Test Engineer']/following::div[@class='oxd-table-cell-actions']//button)[last()]");
	private By deleteJobTitle = By
			.xpath("(//div[text()='Test Engineer']/following::div[@class='oxd-table-cell-actions']//button)[last()-1]");
	private By yesdel = By.xpath("//button[normalize-space()='Yes, Delete']");

	public boolean headervalidation() {
		WebElement waitForElementToBevisible = ele.waitForElementToBevisible(driver, jobtitleheader, 15);
		return ele.doIsDisplayed(jobtitleheader);
	}

	public void fillJobDetails() {
		ele.doClick(add);
		ele.doSendkey(jobTitle, "Test Engineer", 15);
		ele.doSendkey(jobDescription, "SDET Engineer");
		ele.doSendkey(upload,
				"C:\\Users\\DELL\\eclipse-workspace\\OrangeHRM\\src\\test\\resources\\testdata\\paymentreceipt.pdf");
		ele.doSendkey(addNote, "Testing");
		ele.doClick(save);
	}

	public boolean validateJobTitleAvailabiliy(String jobTitleName) {
		ele.waitForVisibilityofElementsLocated(row, 10);
		List<WebElement> rows = ele.getElements(row);
		System.out.println(rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			String titlename = driver
					.findElement(
							By.xpath("((//div[@class='oxd-table-body']/div/div)//div[@role='cell'][2]/div)[" + i + "]"))
					.getText();
			//System.out.println(titlename);

			if (titlename.equals(jobTitleName)) {   //"Test Engineer"

				return true;
			}
		}
		return false;
	}

	public void deleteTitle() {
		ele.waitForVisibilityofElementsLocated(row, 10);
		List<WebElement> rows = ele.getElements(row);
		System.out.println(rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			String titlename = driver
					.findElement(
							By.xpath("((//div[@class='oxd-table-body']/div/div)//div[@role='cell'][2]/div)[" + i + "]"))
					.getText();
			//System.out.println(titlename);

			if (titlename.equals("SDET Test Engineer")) {

				driver.findElement(By.xpath("//div[text()='SDET Test Engineer']/../following-sibling::div[2]//button[last()-1]")).click();
				ele.doClick(yesdel,driver,10);
				break;
			}
		}

	}
	
	public void editJobtitle() {
		
		ele.waitForVisibilityofElementsLocated(row, 10);
		List<WebElement> rows = ele.getElements(row);
		System.out.println(rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			String titlename = driver
					.findElement(
							By.xpath("((//div[@class='oxd-table-body']/div/div)//div[@role='cell'][2]/div)[" + i + "]"))
					.getText();
			//System.out.println(titlename);

			if (titlename.equals("Test Engineer")) {

				driver.findElement(By.xpath("//div[text()='Test Engineer']/../following-sibling::div[2]//button[last()]")).click();
				WebElement jobTitl = ele.waitForElementToBevisible(driver, jobTitle, 10);
				ele.doClick(jobTitle);
				ele.doSendkey(jobTitle, Keys.CONTROL+"A");
				jobTitl.sendKeys(Keys.DELETE );    //Getting and deleting with webElement reference
				ele.doSendkey(jobTitle, "SDET Test Engineer");
				ele.doClick(save);
				break;
			}
		}

		
		
	}

}
