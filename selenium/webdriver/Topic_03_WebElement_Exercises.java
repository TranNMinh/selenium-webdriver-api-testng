package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_03_WebElement_Exercises {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Verify_Function_IsDisplayed() throws InterruptedException {
		driver.get("https://automationfc.github.io/basic-form/index.html");

		Assert.assertTrue(driver.findElement(By.id("mail")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("under_18")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("edu")).isDisplayed());

		if (driver.findElement(By.id("mail")).isDisplayed() == true) {
			driver.findElement(By.id("mail")).sendKeys("minh@ymail.com");
			System.out.println("Email is displayed on this page");
			Thread.sleep(3000);

		} else {
			System.out.println("Email is not displayed on this page");
		}
		
		if (driver.findElement(By.id("under_18")).isDisplayed() == true) {
			driver.findElement(By.id("under_18")).click();
			System.out.println("Radio button is displayed on this page");
			Thread.sleep(3000);

		} else {
			System.out.println("Radio button is not displayed on this page");
		}

		
		if (driver.findElement(By.id("edu")).isDisplayed() == true) {
			driver.findElement(By.id("edu")).sendKeys("Education field");
			System.out.println("Education is displayed on this page");
			Thread.sleep(3000);

		} else {
			System.out.println("Education is not displayed on this page");
		}


	}
	
	@Test
	public void TC_02_Verify_Function_IsEnabled() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		IsElementEnabled(By.id("mail"), "email");
		IsElementEnabled(By.id("under_18"), "Age 'Under 18'");
		IsElementEnabled(By.id("edu"), "Education");
		IsElementEnabled(By.id("job1"), "Job Role 01");
		IsElementEnabled(By.id("job2"), "Job Role 02");
		IsElementEnabled(By.id("development"), "development");
		IsElementEnabled(By.id("slider-1"), "Slider 1");
		
		IsElementEnabled(By.id("password"), "Password");
		IsElementEnabled(By.id("radio-disabled"), "Radio");
		IsElementEnabled(By.id("bio"), "Biography");
		IsElementEnabled(By.id("job3"), "Job Role 3");
		IsElementEnabled(By.id("check-disbaled"), "Checkbox");
		IsElementEnabled(By.id("slider-2"), "Slider 2");
		
	}
	
	@Test
	public void TC_03_Verify_Function_IsSelected() throws InterruptedException {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.id("under_18")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("java")).click();
		Thread.sleep(3000);
		IsElementSelected(By.id("under_18"), "Radio button");
		IsElementSelected(By.id("java"), "Checkbox");
		driver.findElement(By.id("java")).click();
		Thread.sleep(3000);
		IsElementSelected(By.id("java"), "Checkbox");
		
		
	}
	
	@Test
	public void TC_04_Register_At_MailChimp() throws InterruptedException {
		driver.get("https://login.mailchimp.com/signup/");
		
		driver.findElement(By.id("email")).sendKeys("testing@ymail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("new_username")).sendKeys("testing");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@title = 'Show Password']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("new_password")).sendKeys("a");
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed' and text()='One lowercase character']")).isDisplayed());	
		Assert.assertFalse(driver.findElement(By.id("create-account")).isEnabled());	
		Assert.assertFalse(driver.findElement(By.xpath("//h4[text() = \"Your password is secure and you're all set!\"]")).isDisplayed());
		Thread.sleep(3000);
		
		driver.findElement(By.id("new_password")).sendKeys("T");
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed' and text()='One lowercase character']")).isDisplayed());	
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed' and text()='One uppercase character']")).isDisplayed());	
		Assert.assertFalse(driver.findElement(By.id("create-account")).isEnabled());	
		Assert.assertFalse(driver.findElement(By.xpath("//h4[text() = \"Your password is secure and you're all set!\"]")).isDisplayed());
		Thread.sleep(3000);
		
		driver.findElement(By.id("new_password")).sendKeys("1");
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed' and text()='One lowercase character']")).isDisplayed());	
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed' and text()='One uppercase character']")).isDisplayed());	
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed' and text()='One number']")).isDisplayed());	
		Assert.assertFalse(driver.findElement(By.id("create-account")).isEnabled());	
		Assert.assertFalse(driver.findElement(By.xpath("//h4[text() = \"Your password is secure and you're all set!\"]")).isDisplayed());
		Thread.sleep(3000);
		
		driver.findElement(By.id("new_password")).sendKeys("@");
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed' and text()='One lowercase character']")).isDisplayed());	
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed' and text()='One uppercase character']")).isDisplayed());	
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed' and text()='One number']")).isDisplayed());	
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed' and text()='One special character']")).isDisplayed());	
		Assert.assertFalse(driver.findElement(By.id("create-account")).isEnabled());	
		Assert.assertFalse(driver.findElement(By.xpath("//h4[text() = \"Your password is secure and you're all set!\"]")).isDisplayed());
		Thread.sleep(3000);
		
		driver.findElement(By.id("new_password")).sendKeys("abcd");
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed' and text()='One lowercase character']")).isDisplayed());	
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='uppercase-char completed' and text()='One uppercase character']")).isDisplayed());	
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='number-char completed' and text()='One number']")).isDisplayed());	
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed' and text()='One special character']")).isDisplayed());	
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed' and text()='8 characters minimum']")).isDisplayed());	
		Assert.assertTrue(driver.findElement(By.id("create-account")).isEnabled());	
		Assert.assertTrue(driver.findElement(By.xpath("//h4[text() = \"Your password is secure and you're all set!\"]")).isDisplayed());				
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@role = 'checkbox']")).click();
	}
	
	public void IsElementEnabled(By Locator, String name) {
		if (driver.findElement(Locator).isEnabled() == true) {
			System.out.println("Element " + name + " is enabled");
		} else {
			System.out.println("Element " + name + " is disabled");
		}
	}
	
	public void IsElementSelected (By Locator, String name) {
		if (driver.findElement(Locator).isSelected() == true) {
			System.out.println("Element " + name + " is selected");
		} else {
			System.out.println("Element " + name + " is de-selected");
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
