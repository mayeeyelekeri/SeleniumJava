package com.mine.seleniumjava.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupMainPage {

		WebDriver driver; 
		String mainURL; 
		String driverPath; 
		String runMode; 
		
		public SetupMainPage() {
			// get values from properties file 
			mainURL = LoadProperties.getInstance().getMainURL();
			driverPath = LoadProperties.getInstance().getDriverPath();
			runMode = LoadProperties.getInstance().getRunMode();
			// Run in background 
			ChromeOptions options = new ChromeOptions(); 
			if (runMode.equals("headless")) { 
				options.addArguments("headless"); 
			}
			
			driver = new ChromeDriver(options);
			driver.get(mainURL);
			driver.manage().window().maximize();
		}
		
		public WebDriver gotoMainPage() { 
			// make sure driver is setup
			if (driver == null) {
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
			
			// always point to main page (mainURL)
			driver.get(mainURL);
			
			return driver; 
		}
		
		public WebDriver getDriver() { 
			return driver; 
		}
}
