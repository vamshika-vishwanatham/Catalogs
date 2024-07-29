package baseSource;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import serverBuildTile.SubtaskHandlingComponent;

public class BaseClass {

	public static WebDriver driver;
	public LoginPageComponent loginPage;
	public String statusCode;
	public SubtaskHandlingComponent subtaskhandling;
	public String statusValue;

	public BaseClass() {
		PageFactory.initElements(driver, this);
	}

	@BeforeClass
	public void inizializeDriver() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	public void ITView() throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[@class='rw_request_key rw_request_key_link']")).click();
	}

	public void windowHandle() {

		Set<String> windows = driver.getWindowHandles();
		for (String ServiceDeskPortal : windows) {
			driver.switchTo().window(ServiceDeskPortal);
		}
	}

	public void multiThread() throws InterruptedException {
		Thread.sleep(60000);
		driver.navigate().refresh();
		Thread.sleep(60000);
		driver.navigate().refresh();
		Thread.sleep(40000);
		driver.navigate().refresh();
	}

	public void multiThreads() throws InterruptedException {
		Thread.sleep(120000);
		driver.navigate().refresh();
		System.out.println(1);
		Thread.sleep(120000);
		driver.navigate().refresh();
		System.out.println(2);
		Thread.sleep(120000);
		driver.navigate().refresh();
		System.out.println(3);
	}

	public void elementToBeClickable(By expectedElement) {
		WebDriverWait waittime = new WebDriverWait(driver, Duration.ofSeconds(60));
		waittime.until(ExpectedConditions.elementToBeClickable(expectedElement));
	}

	public void sideArrow() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='aui-sidebar-footer']/button")).click();
		Thread.sleep(3000);

	}

	public String statusUpdate(int level) throws InterruptedException {
		
		statusValue = driver.findElement(By.id("opsbar-transitions_more")).getText();
		System.out.println(statusValue);
				if ("user Approval".equals(statusValue)) {//user approval
					statusCode = "USER APPROVAL";
				} else if ("Manager Approval".equals(statusValue)) {
					statusCode = "MANAGER APPROVAL";
				} else {
					statusCode = null;
				}
		return statusCode;
	}

	public void moduleTicketData() throws InterruptedException {
		List<WebElement> SubtaskData = driver.findElements(By.xpath("//*/div[@class = 'module toggle-wrap']"));
		for (int i = 0; i < SubtaskData.size(); i++) {
			System.out.println(SubtaskData.get(i).getText());
			System.out.println("-----------------------");
		}
		Thread.sleep(5000);
	}
	
	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver; 
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		try 
		{
			FileUtils.copyFile(source, new File(destination)); 
		} 
		catch (Exception e) 
		{ 
			e.getMessage(); 
		} 
		return destination;
	}

}
