package com.mine.seleniumjava.heroku;

import org.testng.annotations.Test;
import org.testng.annotations.Ignore;

import com.mine.seleniumjava.Utility.SetupMainPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;


public class GridTest {
	URL hubUrl; 
	
	@Test
	public void gridTest() {
		System.out.println("inside GridTest::gridTest()");
		// 1. Define the hub URL pointing to localhost
		
		try { 
			hubUrl = new URL("http://localhost:4444");
		} catch (Exception e) { 
			System.out.println("not able to connect to grid"); 
		}


		// 2. Setup Chrome Options
		ChromeOptions chromeOptions = new ChromeOptions();

		// 3. Initialize RemoteWebDriver targeting the Docker hub
		WebDriver driver = new RemoteWebDriver(hubUrl, chromeOptions);

		try {
		    // 4. Run your test
		    driver.get("https://google.com");
		    System.out.println("Page Title is: " + driver.getTitle());
		} finally {
		    // 5. Always quit the session
		    driver.quit();
		} // end of try block 

	} // end of gridTest()
	
	
	@Test
	public void dummyTest() {
		System.out.println("inside Dummy Test"); 
	}

}
