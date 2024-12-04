package com.qa.orangehrm.driverfactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	WebDriver driver;
	Properties prop;
	
	public WebDriver initBrowser(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		String url= prop.getProperty("url");
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		default:
			throw new RuntimeException("Please pass the right browser...");
		}
		
		
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
		
	}
	
	
	public Properties initProperties() {
		prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\configfile\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
