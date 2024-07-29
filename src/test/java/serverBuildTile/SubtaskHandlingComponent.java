package serverBuildTile;
import java.time.Duration;
import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseSource.BaseClass;



public class SubtaskHandlingComponent extends BaseClass{

	public ResourceBundle rb = ResourceBundle.getBundle("QAFieldvaluedata");

	@FindBy(xpath = "//tbody[@class='ui-sortable']/tr")
	List<WebElement> subtaskList;
	
	@FindBy(id="edit-issue")
	WebElement editScreen;
	
	@FindBy(id="customfield_11333-field")
	WebElement assignmentGroup;
	
	@FindBy(id="customfield_19701")
	WebElement estimateSize;
	
	@FindBy(id="accxiaedit-issue-submit")
	WebElement submitButton;
	
	@FindBy(id="assignee-field")
	WebElement assigne;
	
	@FindBy(xpath="//*[@id=\"action_id_11\"]/a/div/div[1]/span")
	WebElement inProgress;
	
	@FindBy(id="status-val")
	WebElement statusText;
	
	@FindBy(xpath="//*[@id=\"action_id_61\"]/a/div/div[1]/span")
	WebElement onHold;
	
	@FindBy(id="customfield_12711")
	WebElement subState;
	
	@FindBy(xpath="//*[@title='Rich Text Area']")
	WebElement richTextAreaFrame;
	
	@FindBy(id="tinymce")
	WebElement onHoldCommentBody;
	
	@FindBy(xpath="//*[@id=\"action_id_31\"]/a/div/div[1]/span")
	WebElement close;
	
	@FindBy(id="customfield_11648")
	WebElement closeCode;
	
	@FindBy(xpath="//*[@id='accxiaissue-workflow-transition-submit']")
	WebElement onHoldCloseButton;
	
	@FindBy(id="customfield_11321")
	WebElement closeNote;
	
	@FindBy(id="customfield_19700")
	WebElement actualSize;
	
	@FindBy(id="summary-val")
	WebElement summary;
	
	@FindBy(id = "customfield_13212")
	WebElement nameoftheServer;
	
	@FindBy(id="customfield_13211")
	WebElement IPAdd;
	
	@FindBy(id="customfield_13210")
	WebElement scanningIP;
	
	@FindBy(id="customfield_13209")
	WebElement hardware;

	@FindBy(className = "dialog-error")
	WebElement alert;
	
	@FindBy(id="opsbar-transitions_more")
	WebElement statusDropDown;


	public void selectSubtask() throws InterruptedException {
		
		
	for (int i = 1; i <= subtaskList.size(); i++) {	
		Thread.sleep(20000);
		driver.navigate().refresh();
		driver.findElement(By.xpath("//tr[" + i + "]/td[@class='issuekey']/a")).click();
		Thread.sleep(4000);
		//System.out.println(summary.getText());
		System.out.println("************** Subtask"+ i +": " + summary.getText()+ "**************");
		
		updateAssignmentGroup();
		updateAssinee();
		inProgressTransition();
		onHoldTransition();
		closeTransition(i);
		System.out.println("************** Closed Subtask "+ i +"**************");
		}
	}
	
	
	public void updateAssignmentGroup() throws InterruptedException{
		Thread.sleep(3000);
		editScreen.click();
		Thread.sleep(2000);
		assignmentGroup.click();
		Thread.sleep(4000);
		assignmentGroup.sendKeys("TestAssignmentGroupJIRA");
		Thread.sleep(2000);
		assignmentGroup.sendKeys(Keys.ENTER);
		
		Select estimate = new Select(estimateSize);
		estimate.selectByIndex(2);

		submitButton.click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		System.out.println("************** Assignment Group Updated **************");
	}
	
	public void updateAssinee() throws InterruptedException {
		Thread.sleep(3000);
		editScreen.click();
		Thread.sleep(2000);
		assigne.click();
		Thread.sleep(2000);
		assigne.sendKeys("vamshika.vishwanatham@cotiviti.com");
		Thread.sleep(4000);
		assigne.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		submitButton.click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		System.out.println("************** Assignee Updated **************");

	}
	
	public void inProgressTransition() throws InterruptedException {
		
		driver.navigate().refresh();
		Thread.sleep(5000);
		statusDropDown.click();
		inProgress.click();
		Thread.sleep(5000);
		System.out.println("--------------------------------");
		System.out.println(" ");
		System.out.println("Ticket Status: " + statusDropDown.getText());
	}
	
	public void onHoldTransition() throws InterruptedException {
		
		driver.navigate().refresh();
		Thread.sleep(2000);
		statusDropDown.click();
		onHold.click();

		Thread.sleep(3000);
		Select substatevalue = new Select(subState);
		substatevalue.selectByIndex(3);
		Thread.sleep(3000);
		driver.switchTo().frame(richTextAreaFrame);
		Thread.sleep(5000);
		onHoldCommentBody.sendKeys("On Hold");
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		onHoldCloseButton.click();
		Thread.sleep(10000);
		System.out.println("--------------------------------");
		System.out.println(" ");
		System.out.println("Ticket Status: " + statusDropDown.getText());
		
	}
	
	public void closeTransition(int n) throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		if(n==1) {
			driver.navigate().refresh();
			Thread.sleep(2000);
			statusDropDown.click();
			close.click();
			Thread.sleep(2000);
			
			nameoftheServer.sendKeys(rb.getString("nameoftheServer"));
			
			IPAdd.sendKeys(rb.getString("IPAdd"));
			
			scanningIP.sendKeys(rb.getString("scanningIP"));
			
			Select hardwareType = new Select(hardware);
			Thread.sleep(2000);
			hardwareType.selectByIndex(2);
			
			Thread.sleep(2000);
			Select closecodevalue = new Select(closeCode);
			Thread.sleep(2000);
			closecodevalue.selectByIndex(3);
			Thread.sleep(2000);
			closeNote.sendKeys("Test ticket please ignore");
			Select ActualSizeValue = new Select(actualSize);
			Thread.sleep(2000);
			ActualSizeValue.selectByIndex(4);
			Thread.sleep(2000);
			driver.switchTo().frame(richTextAreaFrame);
			Thread.sleep(3000);
			onHoldCommentBody.sendKeys("Tested");
			Thread.sleep(3000);
			driver.switchTo().parentFrame();
			onHoldCloseButton.click();
			try {
				  Alert alert = driver.switchTo().alert();
				  alert.accept(); // or alert.dismiss(); to cancel the alert
				} catch (NoAlertPresentException e) {
				  System.out.println("No alert was present");
				}

			Thread.sleep(30000);
			driver.navigate().refresh();
			System.out.println("--------------------------------");
			System.out.println("Ticket Status: " + statusDropDown.getText());
			moduleTicketData();
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(7000);
		}
		/*
		 * else if(n == 5){ driver.navigate().refresh(); Thread.sleep(3000);
		 * statusDropDown.click(); close.click(); Select closecodevalue = new
		 * Select(closeCode); Thread.sleep(2000); closecodevalue.selectByIndex(3);
		 * Thread.sleep(2000); closeNote.sendKeys("Test ticket please ignore"); Select
		 * ActualSizeValue = new Select(actualSize); Thread.sleep(2000);
		 * ActualSizeValue.selectByIndex(4); Thread.sleep(2000);
		 * driver.switchTo().frame(richTextAreaFrame); Thread.sleep(3000);
		 * onHoldCommentBody.sendKeys("Tested"); Thread.sleep(3000);
		 * driver.switchTo().parentFrame(); onHoldCloseButton.click();
		 * //Thread.sleep(60000); try { Alert alert = driver.switchTo().alert();
		 * alert.accept(); // or alert.dismiss(); to cancel the alert } catch
		 * (NoAlertPresentException e) { System.out.println("No alert was present"); }
		 * 
		 * driver.navigate().refresh(); Thread.sleep(5000);
		 * System.out.println("--------------------------------");
		 * System.out.println("Ticket Status: " + statusDropDown.getText());
		 * moduleTicketData(); driver.navigate().back(); Thread.sleep(5000);
		 * driver.navigate().refresh(); Thread.sleep(7000); }
		 */
		else {
		driver.navigate().refresh();
		Thread.sleep(3000);
		statusDropDown.click();
		close.click();
		Select closecodevalue = new Select(closeCode);
		Thread.sleep(2000);
		closecodevalue.selectByIndex(3);
		Thread.sleep(2000);
		closeNote.sendKeys("Test ticket please ignore");
		Select ActualSizeValue = new Select(actualSize);
		Thread.sleep(2000);
		ActualSizeValue.selectByIndex(4);
		Thread.sleep(2000);
		driver.switchTo().frame(richTextAreaFrame);
		Thread.sleep(3000);
		onHoldCommentBody.sendKeys("Tested");
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		onHoldCloseButton.click();
		try {
			  Alert alert = driver.switchTo().alert();
			  alert.accept(); // or alert.dismiss(); to cancel the alert
			} catch (NoAlertPresentException e) {
			  System.out.println("No alert was present");
			}
		Thread.sleep(30000);
		driver.navigate().refresh();
		System.out.println("--------------------------------");
		System.out.println("Ticket Status: " + statusDropDown.getText());
		moduleTicketData();
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(7000);
		}
		}
	}
	