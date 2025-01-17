package com.qa.orangehrm.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.utils.Elementutil;

public class LeavePage {

	WebDriver driver;
	Elementutil ele;
	
	public LeavePage(WebDriver driver) {
		this.driver = driver;
		ele = new Elementutil(driver);
	}
	
	private By apply = By.linkText("Apply");
	private By applyleave = By.xpath("//h6[text()='Apply Leave']");
	private By select = By.xpath("(//div[contains(text(),'Select')])");
	private By fmla = By.xpath("//span[text()='CAN - FMLA']");
	private By personal = By.xpath("//span[text()='CAN - Personal']");
	private By fromDate = By.xpath("(//div[@class='oxd-date-input']/input)[last()-1]");
	private By toDate = By.xpath("(//div[@class='oxd-date-input']/input)[last()]");
	private By comments = By.xpath("//textarea");
	private By applybtn = By.xpath("//button[normalize-space()='Apply']");
	private By myLeave = By.linkText("My Leave");
	private By cell = By.xpath("(((//div[@class='oxd-table-card']/div))//div[@role='cell'][8])");
	private By row = By.xpath("//div[@class='oxd-table-card']/div");
	
	private By allDays = By.xpath("//span[text()='All Days']");
	private By halfDayMorning = By.xpath("//span[text()='Half Day - Morning']");
	private By labelLeaveBalance = By.xpath("//label[text()='Leave Balance']");
	private By cancelledText = By.xpath("(//div[text()='Testing sick leave']/../preceding-sibling::div)[last()]");
	
	
	public void clickApply() {
		ele.doClick(apply, driver, 10);
	}
	
	public boolean headerValidation() {
		ele.waitForElementToBevisible(driver, applyleave, 10);
		return ele.doIsDisplayed(applyleave);
	}
	
	public void enterLeaveDetails() {
		ele.doClick(select);
		ele.doClick(personal, driver, 6);
		ele.doSendkey(fromDate, getTodayDate());
		WebElement toDatefield = ele.waitForElementToBevisible(driver, toDate, 3);
		ele.doSendkey(toDate, Keys.CONTROL+"a");
		toDatefield.sendKeys(Keys.DELETE);
		ele.doSendkey(toDate, getFutureDate(5));
		ele.doClick(labelLeaveBalance);
		ele.doClick(select, driver, 6);
		ele.doClick(allDays, driver, 6);
		ele.doClick(select, driver, 6);
		ele.doClick(halfDayMorning, driver, 6);
		ele.doSendkey(comments, "Testing sick leave");
		ele.doClick(applybtn);
	}
	
	public void cancelMyLeave(String comment) {
		ele.doClick(myLeave, driver, 20);
		List<WebElement> rows = ele.waitForVisibilityofElementsLocated(cell, 15);

		for (WebElement row : rows) {
			String text = row.getText(); // Get the 8th cell
			if (text.equals(comment)) {
				By cancel = By.xpath("(//div[text()='"+comment+"']/following::button[normalize-space()='Cancel'])[1]");
				WebElement cancelButton = row.findElement(cancel);
				cancelButton.click();
				break; // Exit loop once the cancel action is performed
			}
		}
	}

	

	public String verifycancelLeavestatus(String comment) {
		ele.doClick(myLeave, driver, 20);
		List<WebElement> rows = ele.waitForVisibilityofElementsLocated(cell, 15);
		
		for (WebElement row : rows) {
			String text= row.getText();
			if (text.equals(comment)) {
			    String cancelled= ele.doGetText(cancelledText);
			    return cancelled;
			}
		}
		
		
		return null;
	}
	
	public String getTodayDate() {
		LocalDate dt = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String format = dt.format(dtf);
		return format;
	}
	
	public String getFutureDate(int daystoAdd) {
		LocalDate dt = LocalDate.now();
		LocalDate futuredate = dt.plusDays(daystoAdd);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return futuredate.format(dtf);
	}
	

}
