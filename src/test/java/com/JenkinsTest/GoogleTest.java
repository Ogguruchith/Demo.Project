package com.JenkinsTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void  setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@Test
	public void login()
	{
		driver.get("https://www.google.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("APjFqb"))).sendKeys("Facebook" , Keys.ENTER);
		System.out.println("Sucessfully moved to facebook");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
