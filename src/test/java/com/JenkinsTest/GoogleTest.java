package com.JenkinsTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void setup() {

	    String browser = System.getProperty("Browser", "Chrome");

	    if(browser.equalsIgnoreCase("Chrome")) {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	    }
	    else if(browser.equalsIgnoreCase("Edge")) {
	        WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
	    }

	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
