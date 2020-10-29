package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_WebElement_Commands {
	WebDriver driver;
	WebElement element;
	List<WebElement> elements;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Web_Element_Command() {
		// Textbox/ TextArea/ Dropdown (Editable)
		// Xóa dữ liệu đang có trong field
		element.clear();		// *

		// Nhập liệu
		element.sendKeys("");		// **

		// Cho phép tìm element (1)
		element = driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));

		// Cho phép tìm nhiều element
		elements = driver.findElements(By.xpath(""));

		WebElement searchTextbox = driver.findElement(By.xpath("//input[@id='search']"));
		searchTextbox.getAttribute("placeholder");		// *
		searchTextbox.getAttribute("value");		// *
		// Search entire store here...

		// GUI: font/ size/ color/ location/ position/...
		WebElement subscribeButton = driver.findElement(By.xpath("//button[@title='Subscribe']"));
		subscribeButton.getCssValue("background");
		subscribeButton.getCssValue("font-family");
		subscribeButton.getCssValue("font-size");
		subscribeButton.getCssValue("text-align");

		// Report HTML: ReportNG/ ExtentReport/ AllureReport
		// element.getScreenshotAs(target)

		// A
		WebElement subscribeTextbox = driver.findElement(By.cssSelector("#newsletter"));
		String subscribeTagname = subscribeTextbox.getTagName();

		// B
		driver.findElement(By.xpath("//" + subscribeTagname + "[@id='search']"));

		element.getText();		// **

		// Kiểm tra xem element này là hiển thị hoặc ko
		// Hiển thị: true
		// Ko: false

		Assert.assertTrue(element.isDisplayed());		// **

		// 1 element có bị disabled hay ko
		// true
		// false

		// ko bị disabled = enabled
		Assert.assertTrue(element.isEnabled());

		// Đang bị disabled
		Assert.assertFalse(element.isEnabled());

		// Được chọn hay chưa: checkbox/ radio
		// Dropdown (item) -> thư viện riêng = Class riêng = Select (selenium)
		
		Assert.assertTrue(element.isSelected());		// *
		
		// Checkbox/ Radio/ Button/ Image/ Link/..
		element.click();		// **
		
		// Form
		element.submit();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
