package com.mine.magento;

import org.testng.annotations.Test;

import com.mine.seleniumjava.Utility.SetupMainPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class CreateNewAccount {
	
	SetupMainPage mainPage; 
	WebDriver driver; 
	
	//@Parameters({"formauthlink", "username", "passwd", "formLoggednLink"})
	@Test
	//public void createNewAccount(String formauthlink, String userName, String passwd, String formLoggednLink) {
	public void createNewAccount() {
		String DuplicateError = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account."; 
		System.out.println("inside FormAuthenticationTest::checkboxlinkTest()");
		driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("firstname")).sendKeys("Test1");
		driver.findElement(By.id("lastname")).sendKeys("atest1");
		driver.findElement(By.id("email_address")).sendKeys("atest1a@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test@123");

		driver.findElement(By.name("password_confirmation")).sendKeys("Test@123");
		  
		sleep(); 
		System.out.println("about to click");
		driver.findElement(By.xpath("//button[@class='action submit primary']")).click();
	    
		sleep(); 
		System.out.println("about to validate");

		assertEquals(driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[2]/div/div/div")).getText(), DuplicateError);      
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
	
	public void sleep() { 
		try{
			Thread.sleep(5000);
		}
		catch(InterruptedException ie){			
		}
	}
}
