package webdriver;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_02_Xpath_Exercises {
	WebDriver driver;
	
	String Firstname;
	String Lastname;
	String EmailAdress;
	Random rand;
	String Fullname;
	
//	Check Log In Functionality
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
		Firstname = "Dong";
		Lastname = "Tran";
		rand = new Random();
		EmailAdress = "Dong" + rand.nextInt(9999) + "@yahoo.com";
		Fullname = Firstname + " " + Lastname;
		
		
	//	driver.findElement(By.xpath("//div[@id = 'header-account']//a[@title = 'My Account']")).click();
	//	This element is not displayed.

	}

	@Test
	public void TC_01_Empty_Email_And_Password() {
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("pass")).sendKeys("");
		driver.findElement(By.id("send2")).click();
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
	}
	
	@Test
	public void TC_02_Invalid_Email() {
		driver.findElement(By.id("email")).sendKeys("123@123.123");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.id("send2")).click();
		Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
		
	}
	
	@Test
	public void TC_03_Invalid_Password() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("email")).sendKeys("minh@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("!@#");
		driver.findElement(By.id("send2")).click();
		Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
		
	}
	
	@Test
	public void TC_04_Incorrect_Password() {
		driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
		driver.findElement(By.id("email")).sendKeys("minh@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.id("send2")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class = 'error-msg']//span")).getText(), "Invalid login or password.");
		
	}

	@Test
	public void TC_05_Create_New_Account() {
		driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
		driver.findElement(By.xpath("//a[@title = 'Create an Account']")).click();
		
	// Input values into mandatory fields
		driver.findElement(By.id("firstname")).sendKeys(Firstname);
		driver.findElement(By.id("lastname")).sendKeys(Lastname);
		driver.findElement(By.id("email_address")).sendKeys(EmailAdress);
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("confirmation")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@title = 'Register']")).click();
		
	// Verify display of Success Massage
		String SuccessMess = driver.findElement(By.xpath("//li[@class = 'success-msg']//span")).getText();
		Assert.assertEquals(SuccessMess, "Thank you for registering with Main Website Store.");
		
	// Verify display of first name, last name and email
		String ContactInfo = driver.findElement(By.xpath("//h3[text() = 'Contact Information']/parent::div/following-sibling::div[@class = 'box-content']/p")).getText();		
		Assert.assertTrue(ContactInfo.contains(Fullname));
		Assert.assertTrue(ContactInfo.contains(EmailAdress));	
		
	// Verify log-out feature
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper'] //span[text() = 'Account']")).click();
		driver.findElement(By.xpath("//a[@title = 'Log Out']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("img[src $= 'logo.png']")).isDisplayed());		
		
	}

	@Test
	public void TC_06_Valid_Email_And_Password() {
		driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();
		driver.findElement(By.id("email")).sendKeys(EmailAdress);
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.id("send2")).click();
		String WelcomeMess = "Hello, " + Fullname + "!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText(), "MY DASHBOARD");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'welcome-msg']//strong")).getText(), WelcomeMess);
		
		
	}



	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
