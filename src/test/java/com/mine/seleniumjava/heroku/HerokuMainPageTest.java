package com.mine.seleniumjava.heroku;

import org.testng.annotations.Test;

import com.mine.seleniumjava.Utility.SetupMainPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class HerokuMainPageTest {
	
	SetupMainPage mainPage; 
	WebDriver driver; 
	
	@Test
	@Parameters("titleExpected")
	public void titleTest(String titleExpected) {
		System.out.println("inside HerokuMainPageTest::titleTest()");
		mainPage.gotoMainPage(); 
		System.out.println( "Current URL: "+ driver.getCurrentUrl()); 
		
		String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        assertEquals(titleExpected, actualTitle);
	}
	  
	@Parameters("ablink")
	@Test
	public void abTest(String ablink) {
		System.out.println("inside HerokuMainPageTest::abTest()");
		mainPage.gotoMainPage(); 
		System.out.println( "inside abTest, Current URL: "+ driver.getCurrentUrl()); 
		
		WebElement element = driver.findElement(By.linkText("A/B Testing"));
        element.click();
        assertEquals(ablink, driver.getCurrentUrl());
	}
	
	@Parameters("checkboxlink")
	@Test
	public void checkboxesTest(String checkboxlink) {
		System.out.println("inside HerokuMainPageTest::checkboxlinkTest()");
		mainPage.gotoMainPage(); 
		System.out.println( "inside abTest, Current URL: "+ driver.getCurrentUrl()); 
		
		WebElement element = driver.findElement(By.linkText("Checkboxes"));
        element.click();
        assertEquals(checkboxlink, driver.getCurrentUrl());
	}
	
	@Test
	public void integerCheckTest() {
		System.out.println("inside HerokuMainPageTest::integerCheckTest()");
		assertEquals(1,1);
		if (128 == 128) {
			System.out.println(1 == 1);
			assertEquals(128,128); 
		}
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("inside HerokuMainPageTest::beforeTest() ...... ");
		mainPage = new SetupMainPage(); 
		driver = mainPage.getDriver(); 
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("...... inside HerokuMainPageTest::afterTest()");
		// Wait for 2 seconds before closing 
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.close();
	}

}
