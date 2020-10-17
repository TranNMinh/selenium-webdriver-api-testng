package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_02_Xpath_Css {
  WebDriver driver;
	
	// Mở ra 1 trình duyệt
	// Nhập vào App
	// Nhập vào email textbox
	
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.facebook.com/");
  }

  	//Tìm element: findElement (số ít)
  	//Tìm element: findElements (số nhiều)
  @Test
  public void TC_01 () {
	  System.out.println("Start TC-01 for first 6 locators");
	  
	  // ID
	  driver.findElement(By.id("email")).sendKeys("minh@gmail.com");
	  
	  // Class
	  boolean display = driver.findElement(By.className("_featuredLogin__formContainer")).isDisplayed();
	  if (display == true) {
		  System.out.println("The form is being displayed.");
	  }
	  
	  // Name
	  driver.findElement(By.name("pass")).sendKeys("123456");
	  
	  // Tagname
	  int linkNumber = driver.findElements(By.tagName("a")).size();
	  System.out.println("Number of links in the site is " + linkNumber);
	  
	  // Link Text (Link -a)
	  driver.findElement(By.linkText("English (UK)")).click();
	  
	  // Partial Link Text (Link -a)
	  driver.findElement(By.partialLinkText("Việt")).click();
	  
  }
  
  @Test
  public void TC_02 () {
	  System.out.println("Start TC-02 for Css Xpath");
	  
	  // CSS
	  driver.findElement(By.cssSelector("#email")).sendKeys("Hello World");
	  driver.findElement(By.cssSelector("input[id = 'email']")).clear();
	  
	  // Xpath
	  driver.findElement(By.xpath("//input[@id = 'pass']")).sendKeys("123456");
	  driver.findElement(By.xpath("//input[@name = 'pass']")).clear();
	  driver.findElement(By.xpath("//a[text() = 'English (UK)']")).click();
  }
  
  
  @AfterClass
  public void afterClass() {
  }

}
