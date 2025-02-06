package com.mine.seleniumjava.Utility;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SetupMainPageFirefox {

		WebDriver driver; 
		String mainURL; 
		String driverPath; 
		String headless; 
		String gridHost; 
		String runMode; 
		
		public SetupMainPageFirefox() {
			// get values from properties file 
			mainURL = LoadProperties.getInstance().getMainURL();
			driverPath = LoadProperties.getInstance().getDriverPath();
			headless = LoadProperties.getInstance().getHeadless();
			gridHost = LoadProperties.getInstance().getGridHost();
			runMode = LoadProperties.getInstance().getRunMode();
			
			System.setProperty("weddriver.firefox.driver", driverPath); 
			
			// Run in background 
			FirefoxOptions options = new FirefoxOptions(); 
			options.setBinary("/opt/firefox/firefox"); 
			
			// options.setPageLoadTimeout(new Duration(3000); 
			if (headless.equals("true")) { 
				options.addArguments("headless"); 
			}
			
			if (runMode.equals("grid")) { 
				// hub setup 
				//options.setCapability("browserVersion", "132.0");
				options.setCapability("platformName", "linux"); 
				options.setCapability("browserName", "firefox"); 
								
				try { 
					driver = new RemoteWebDriver(new URL(gridHost), options);
					driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS); 
				} catch (Exception e) { 
					System.out.println("ERRRRRRRROR for Firefox: caught exception " + e);
				}
			} else {
				driver = new FirefoxDriver(options);
			}
			 
			
			driver.get(mainURL);
			driver.manage().window().maximize();
		}
		
		
		public WebDriver gotoMainPage() { 
			// make sure driver is setup
			if (driver == null) {
				driver = new FirefoxDriver();
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
