package com.ntt.cmt.poc;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestSampleApplicationWithFirefox {

	private static FirefoxDriver driver;
	WebElement element;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testWelcomeScreen() throws InterruptedException {
		System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		driver.get("http://localhost:8088/SampleApplication-1.0-SNAPSHOT/");
		
		assertEquals("Continuous delivery and Integration - Demo", driver.getTitle());
		
		Thread.sleep(1500);
		
		driver.findElement(By.id("login")).click();
		
		assertEquals("Continuous delivery and Integration - Login", driver.getTitle());
		
		Thread.sleep(1500);
		
		System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());

	}
	
	
	@Test
	public void testlogin() throws InterruptedException {
		
		
		System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		driver.get("http://localhost:8088/SampleApplication-1.0-SNAPSHOT/");
		
		assertEquals("Continuous delivery and Integration - Demo", driver.getTitle());
		
		Thread.sleep(1500);
		
		driver.findElement(By.id("login")).click();		
		assertEquals("Continuous delivery and Integration - Login", driver.getTitle());
		driver.findElement(By.name("username")).sendKeys("Test");
		driver.findElement(By.name("password")).sendKeys("Test");
		driver.findElement(By.name("submit")).click();
		
		assertTrue(driver.getPageSource().contains("Welcome back"));
		
		Thread.sleep(1500);
		
		System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
	

	
	}
	
	
	@Test
	public void testSignupRegistrationScreen() throws InterruptedException {
		
		
		System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		driver.get("http://localhost:8088/SampleApplication-1.0-SNAPSHOT/");
		
		assertEquals("Continuous delivery and Integration - Demo", driver.getTitle());
		
		Thread.sleep(1500);
		
		driver.findElement(By.id("signup")).click();		
		assertEquals("Continuous delivery and Integration - Signup", driver.getTitle());
		
		assertTrue(driver.getPageSource().contains("Registration"));
		Thread.sleep(1500);
		
		System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
	

	
	}
	
	@Test
	public void testNewUserSignup() throws InterruptedException {
		
		int userId = 1 + (int)(Math.random()*9999); 
		System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		driver.get("http://localhost:8088/SampleApplication-1.0-SNAPSHOT/");
		
		assertEquals("Continuous delivery and Integration - Demo", driver.getTitle());
		
		Thread.sleep(1500);
		
		driver.findElement(By.id("signup")).click();		
		assertEquals("Continuous delivery and Integration - Signup", driver.getTitle());
		
		assertTrue(driver.getPageSource().contains("Registration"));
		
		driver.findElement(By.name("firstname")).sendKeys("TestUser"+userId);
		driver.findElement(By.name("lastname")).sendKeys("TestUser"+userId);
		driver.findElement(By.name("username")).sendKeys("Test"+userId);
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("emailid")).sendKeys("Test@nttdata.com");
		driver.findElement(By.name("submit")).click();
		
		assertEquals("Continuous delivery and Integration - User", driver.getTitle());
		assertTrue(driver.getPageSource().contains("Welcome to our blog"));
		
		Thread.sleep(1500);
		System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
	}
	
	@Test
	public void testSignupUserExists() throws InterruptedException {
		
		
		System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		driver.get("http://localhost:8088/SampleApplication-1.0-SNAPSHOT/");
		
		assertEquals("Continuous delivery and Integration - Demo", driver.getTitle());
		
		Thread.sleep(1500);
		
		driver.findElement(By.id("signup")).click();		
		assertEquals("Continuous delivery and Integration - Signup", driver.getTitle());
		
		assertTrue(driver.getPageSource().contains("Registration"));
		
		driver.findElement(By.name("firstname")).sendKeys("TestUser");
		driver.findElement(By.name("lastname")).sendKeys("TestUser");
		driver.findElement(By.name("username")).sendKeys("Test");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("emailid")).sendKeys("Test@nttdata.com");
		driver.findElement(By.name("submit")).click();
		
		System.out.println("User already Exists ");
		assertEquals("Continuous delivery and Integration - Signup", driver.getTitle());
		
		Thread.sleep(1500);
		System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
	}
	
	@Test
	public void testHomeLink() throws InterruptedException {
		
		
		System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		driver.get("http://localhost:8088/SampleApplication-1.0-SNAPSHOT/");
		
		assertEquals("Continuous delivery and Integration - Demo", driver.getTitle());
		
		Thread.sleep(1500);
		
		driver.findElement(By.id("login")).click();		
		assertEquals("Continuous delivery and Integration - Login", driver.getTitle());
		driver.findElement(By.name("username")).sendKeys("Test");
		driver.findElement(By.name("password")).sendKeys("Test");
		driver.findElement(By.name("submit")).click();
		
		assertNotNull(driver.findElement(By.xpath("/html/body/div/nav/ul/li/a")));
				
		
		Thread.sleep(1500);
		
		System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
	}
	
	@Test
	public void testInvalidLogin() throws InterruptedException {
		
		
		System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		driver.get("http://localhost:8088/SampleApplication-1.0-SNAPSHOT/");
		
		assertEquals("Continuous delivery and Integration - Demo", driver.getTitle());
		
		Thread.sleep(1500);
		
		driver.findElement(By.id("login")).click();		
		assertEquals("Continuous delivery and Integration - Login", driver.getTitle());
		driver.findElement(By.name("username")).sendKeys("InvalidUser");
		driver.findElement(By.name("password")).sendKeys("InvalidUser");
		driver.findElement(By.name("submit")).click();		
		
		assertTrue(driver.getPageSource().contains("Invalid credential"));		
		Thread.sleep(1500);
		
		System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
	}
	
	@Test
	public void testInvalidInputOnSignup() throws InterruptedException {
		
		int userId = 1 + (int)(Math.random()*9999); 
		System.out.println("Start test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
		driver.get("http://localhost:8088/SampleApplication-1.0-SNAPSHOT/");
		
		assertEquals("Continuous delivery and Integration - Demo", driver.getTitle());
		
		Thread.sleep(1500);
		
		driver.findElement(By.id("signup")).click();		
		assertEquals("Continuous delivery and Integration - Signup", driver.getTitle());
		
		assertTrue(driver.getPageSource().contains("Registration"));
		
		driver.findElement(By.name("firstname")).sendKeys("TestUser@*");
		driver.findElement(By.name("lastname")).sendKeys("TestUser"+userId);
		driver.findElement(By.name("username")).sendKeys("Test"+userId);
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("emailid")).sendKeys("Test");
		driver.findElement(By.name("submit")).click();
		
		assertTrue(driver.getPageSource().contains("Invalid Email ID"));
		
		Thread.sleep(1500);
		System.out.println("End test " + new Object(){}.getClass().getEnclosingMethod().getName());
	
	}
	
	
		
}
