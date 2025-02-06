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
			
			//System.setProperty("weddriver.chrome.driver", "/home/vagrant/INFO/SeleniumJava/drivers/chromedriver");
			// Run in background 
			ChromeOptions options = new ChromeOptions(); 
			//options.setBinary("/opt/google/chrome/chrome");
			if (headless.equals("true")) { 
				options.addArguments("headless"); 
			}
			
			//options.AddArgument("--user-data-dir=/tmp/1"); 
			//options.AddArgument("--profile-directory=Default"); 
			//options.AddArgument("--disable-extensions"); 
			if (runMode.equals("grid")) { 
				// hub setup 
				//options.setCapability("browserVersion", "131.0");
				options.setCapability("platformName", "linux"); 
				options.setCapability("browserName", "chrome"); 
								
				try { 
					driver = new RemoteWebDriver(new URL(gridHost), options);
				} catch (Exception e) { 
					System.out.println("ERRRRRRRRR for chrome: caught exception " + e);
				}
			} else {
				driver = new ChromeDriver(options);
			}
			 
			driver.get(mainURL);
			driver.manage().window().maximize();
		}
		
		
		public void SetupMainPages() {
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
