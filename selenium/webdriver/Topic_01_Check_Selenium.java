package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_01_Check_Selenium {
	// Khai báo biến đại diện cho Selenium Web Driver
	WebDriver driver;
	
	// Pre-Conditions
	@BeforeClass
	public void beforeClass() {
		// Mở trình duyệt lên
		driver = new FirefoxDriver();
		
		// Mở App lên
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_Check_Title() {
		String homePageTitle = driver.getTitle();
		
		Assert.assertEquals(homePageTitle, "Facebook - Đăng nhập hoặc đăng ký");
	}

	@Test
	public void TC_02_Check_Url() {
		String homePageUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(homePageUrl, "https://www.facebook.com/");
	}

	// Post-Condition (Clean Data Test/ Browser/ Driver/ DB)
	@AfterClass
	public void afterClass() {
		// Đóng trình duyệt
		driver.quit();
	}

}
