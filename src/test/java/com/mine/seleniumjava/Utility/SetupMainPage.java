package com.mine.seleniumjava.Utility;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SetupMainPage {

		WebDriver driver; 
		String mainURL; 
		String driverPath; 
		String headless; 
		String gridHost; 
		String runMode; 
		
		public SetupMainPage() {
			// get values from properties file 
			mainURL = LoadProperties.getInstance().getMainURL();
			driverPath = LoadProperties.getInstance().getDriverPath();
			headless = LoadProperties.getInstance().getHeadless();
			gridHost = LoadProperties.getInstance().getGridHost();
			runMode = LoadProperties.getInstance().getRunMode();
			
			// Run in background 
			ChromeOptions options = new ChromeOptions(); 
			if (headless.equals("true")) { 
				options.addArguments("headless"); 
			}
			
			if (runMode.equals("grid")) { 
				// hub setup 
				options.setCapability("browserVersion", "132.0");
				options.setCapability("platformName", "linux"); 
				options.setCapability("browserName", "chrome"); 
				
				try { 
					driver = new RemoteWebDriver(new URL(gridHost), options);
				} catch (Exception e) { 
					System.out.println("caught exception " + e);
				}
			} else {
				driver = new ChromeDriver(options);
			}
			 
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
		
		public String getRunMode() {
			return runMode;
		}
}
