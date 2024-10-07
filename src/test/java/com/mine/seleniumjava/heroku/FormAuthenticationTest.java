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

public class FormAuthenticationTest {
	
	SetupMainPage mainPage; 
	WebDriver driver; 
	
	@Parameters({"formauthlink", "username", "passwd", "formLoggednLink"})
	@Test
	public void formAuthenticationTest(String formauthlink, String userName, String passwd, String formLoggednLink) {
		System.out.println("inside FormAuthenticationTest::checkboxlinkTest()");
		mainPage.gotoMainPage(); 
		System.out.println( "inside abTest, Current URL: "+ driver.getCurrentUrl()); 
		
		WebElement element = driver.findElement(By.linkText("Form Authentication"));
        element.click();
        assertEquals(formauthlink, driver.getCurrentUrl());
        
        // now login and validate 
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(passwd);
        
        // click "login" button 
        driver.findElement(By.className("radius")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        // verify the login 
        System.out.println( "inside abTest, Current URL: "+ driver.getCurrentUrl()); 
        assertEquals(formLoggednLink, driver.getCurrentUrl());
        
        // logout by clicking "logout" button 
        driver.findElement(By.linkText("Logout")).click();
        assertEquals(formauthlink, driver.getCurrentUrl());        
	}
	
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("inside FormAuthenticationTest::beforeTest() ...... ");
		mainPage = new SetupMainPage(); 
		driver = mainPage.getDriver(); 
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("...... inside FormAuthenticationTest::afterTest()");
		// Wait for 2 seconds before closing 
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.close();
	}

}
