package onBoardingtile;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseSource.BaseClass;

public class NewHireApprovalFlow extends BaseClass{
	
	String currentUrl;
	String switchUserUrl;

	
	@FindBy(xpath="//a[@title='Administration']")
	WebElement administrator;
	@FindBy(xpath="//div[@id='system-admin-menu-content']/div/ul/li[10]")
	WebElement scriptRunner;
	@FindBy(css=".sr-rs__value-container.css-1ftf48x")
	WebElement selectUser;
	@FindBy(xpath="//button[@data-cy='execute-button']/span")
	WebElement runProfile;
	@FindBy(id="com.atlassian.servicedesk.approvals-plugin:approve-approval")
	WebElement approveButton;
	@FindBy(partialLinkText="Return to your session as ")
	WebElement returnToSession;
	@FindBy(id="searchScripts")
	WebElement searchScripts;	
	@FindBy(xpath="//div[@data-testid='scriptContainer']/a")
	WebElement switchUser;
	
	public void switchUser() throws InterruptedException {
		
		currentUrl = driver.getCurrentUrl();
		administrator.click();
		scriptRunner.click();
		searchScripts.sendKeys("Switch to a different user");
		switchUser.click();
		Thread.sleep(3000);
		switchUserUrl = driver.getCurrentUrl();
	}
	
	
	public void userProfileSwitch(String name) throws InterruptedException {
		
		//multiThread();
		selectUser.click();
		driver.findElement(By.id("react-select-2-input")).sendKeys(name);
		Thread.sleep(3000);
		driver.findElement(By.id("react-select-2-input")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(1000);
		runProfile.click();
		Thread.sleep(5000);
		driver.get(currentUrl);
		Thread.sleep(3000);
		approveButton.click();
		Thread.sleep(4000);
		//driver.get(switchUserUrl);
		driver.navigate().back();
		returnToSession.click();
		Thread.sleep(2000);
		driver.get(currentUrl);
		System.out.println("************** Ticket Approved "+ name +"**************");
		Thread.sleep(30000);
		driver.navigate().refresh();
		Thread.sleep(30000);
		driver.navigate().refresh();
		
	}

}
