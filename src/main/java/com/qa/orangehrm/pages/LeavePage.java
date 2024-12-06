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
	private By bereavement = By.xpath("//span[text()='CAN - Bereavement']");
	
	private By fromDate = By.xpath("(//div[@class='oxd-date-input']/input)[last()-1]");
	private By toDate = By.xpath("(//div[@class='oxd-date-input']/input)[last()]");
	
	
	
	private By comments = By.xpath("//textarea");
	private By applybtn = By.xpath("//button[normalize-space()='Apply']");
	
	private By myLeave = By.linkText("My Leave");
	
	public void clickApply() {
		ele.doClick(apply, driver, 10);
	}
	
	public boolean headerValidation() {
		ele.waitForElementToBevisible(driver, applyleave, 10);
		return ele.doIsDisplayed(applyleave);
	}
	
	public void enterLeaveDetails() {
		ele.doClick(select);
		ele.doClick(fmla, driver, 6);
		ele.doSendkey(fromDate, getTodayDate());
		WebElement toDatefield = ele.waitForElementToBevisible(driver, toDate, 3);
		ele.doSendkey(toDate, Keys.CONTROL+"a");
		toDatefield.sendKeys(Keys.DELETE);
		ele.doSendkey(toDate, getTodayDate());
		ele.doSendkey(comments, "Testing sick leave");
		ele.doClick(applybtn);
	}
	
	public void cancelMyLeave() {
		ele.doClick(myLeave, driver, 20);
		ele.waitForVisibilityofElementsLocated(By.cssSelector(".oxd-table-card"), 15);
		List<WebElement> rows = ele.getElements(By.cssSelector(".oxd-table-card"));
		
		for (int i = 1; i <=rows.size(); i++) {
			
			String text = driver.findElement(By.xpath("((//div[@class='oxd-table-card']//div[@role='row'])["+i+"]//div[@role='cell'])[8]")).getText();
			
			if(text.equals("Testing sick leave")) {
				driver.findElement(By.xpath("(//div[@class='oxd-table-card']//div[@role='row'])["+i+"]//div[text()='Testing sick leave']/following::button[normalize-space()='Cancel']")).click();
				break;
			}
			
		}
	}
	
	//Cancelled (1.00)
	
	public void verifycancelLeavestatus() {
		ele.doClick(myLeave, driver, 20);
		ele.waitForVisibilityofElementsLocated(By.cssSelector(".oxd-table-card"), 15);
		List<WebElement> rows = ele.getElements(By.cssSelector(".oxd-table-card"));
		
		for (int i = 1; i <=rows.size(); i++) {
			
			String text = driver.findElement(By.xpath("((//div[@class='oxd-table-card']//div[@role='row'])["+i+"]//div[@role='cell'])[7]")).getText();
			
			if(text.equals("Cancelled (1.00)")) {
				System.out.println("Leave Cancellation Successful");
				break;
			}
			
		}
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
