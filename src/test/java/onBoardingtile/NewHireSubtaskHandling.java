package onBoardingtile;

import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import baseSource.BaseClass;

public class NewHireSubtaskHandling extends BaseClass{
	public ResourceBundle rb = ResourceBundle.getBundle("QAFieldvaluedata");
	NewHireApprovalFlow Approval = new NewHireApprovalFlow();
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
	
	@FindBy(xpath="//*[@id=\"action_id_21\"]/a/div/div[1]/span")
	WebElement inProgress;
	
	@FindBy(id="status-val")
	WebElement statusText;
	
	@FindBy(xpath="//*[@id=\"action_id_11\"]/a/div/div[1]/span")
	WebElement onHold;
	
	@FindBy(id="customfield_12711")
	WebElement subState;
	
	@FindBy(xpath="//*[@title='Rich Text Area']")
	WebElement richTextAreaFrame;
	
	@FindBy(id="tinymce")
	WebElement onHoldCommentBody;
	
	@FindBy(xpath="//*[@id=\"action_id_41\"]/a/div/div[1]/span")
	WebElement close;
	
	@FindBy(xpath="//*[@id=\"action_id_31\"]/a/div/div[1]/span")
	WebElement RBAclose;
	
	@FindBy(id="customfield_11648")
	WebElement closeCode;
	
	@FindBy(xpath="//*[@id='accxiaissue-workflow-transition-submit']")
	WebElement onHoldCloseButton;
	
	@FindBy(id="customfield_11321")
	WebElement closeNote;
	
	@FindBy(id="customfield_19700")
	WebElement actualSize;
	
	@FindBy(id="opsbar-transitions_more")
	WebElement statusDropDown;
	
	@FindBy(xpath = "//tbody[@class='ui-sortable']/tr")
	List<WebElement> subtaskList;
	
	@FindBy(id="summary-val")
	WebElement summary;
	
	@FindBy(xpath="//a[@id='aui-uid-4']/strong")
	WebElement ClosureInformation;
	
	@FindBy(xpath="//*[@id='action_id_61']")
	WebElement cancelRBA;
	
	@FindBy(xpath="//*[@id='action_id_91']")
	WebElement RBANotRequired;
	
	@FindBy(xpath="//*[@id='action_id_71']")
	WebElement RoleMissingInRBAList;
	
	@FindBy(xpath="//*[@id='action_id_21']")
	WebElement SelectRole;
	
	@FindBy(xpath="//*[@id='customfield_11387-single-select']")//*[@id='customfield_11387-single-select']
	WebElement RequestorBUClick;
	
	@FindBy(xpath="//*[@id='customfield_11388-single-select']")
	WebElement RequestorSBUClick;
	
	@FindBy(xpath="//input[@id='customfield_11387-field']")
	WebElement RequestorBU;
	
	@FindBy(xpath="//input[@id='customfield_11388-field']")
	WebElement RequestorSBU;
	
	@FindBy(xpath="//input[@id='customfield_12723-field']")
	WebElement Role;
	
	@FindBy(xpath="//*[@id='customfield_12723-single-select']")
	WebElement RoleClick;
	
	@FindBy(xpath="//textarea[@id='customfield_12725']")
	WebElement RoleMissingJustification;
	
	@FindBy(xpath="//button[@value='Role is Missing from RBA List'][2]")
	WebElement RoleMissingButton;
	
	@FindBy(xpath="//button[@value='Select Role'][2]")
	WebElement SelectRoleButton;
	
	String ParentTicket;
	
	public void selectSubtask(String Type) throws InterruptedException {
		int i;
		for (i = 1; i <= subtaskList.size(); i++) {	
			Thread.sleep(20000);
			driver.navigate().refresh();
			
			if(Type.contains("CancelRBA")) {
			CancelRBASubtaskHandling(i);
			}
			else if(Type.contains("RBANotRequired")) {
			RBANotRequiredSubtaskHandling(i);
			}
			else if(Type.contains("RoleMissingInRBA")) {
				RoleMissingInRBAListSubtaskHandling(i);
			}
			else if(Type.contains("NewHireSelectRole"))
					{
				NewHireSelectRoleSubtaskHandling(i);
					}
					
					}
	}
	
	private void NewHireSelectRoleSubtaskHandling(int tasknum) throws InterruptedException {
		ParentTicket = driver.getCurrentUrl();
		driver.findElement(By.xpath("//tr[" + tasknum + "]/td[@class='issuekey']/a")).click();
		Thread.sleep(4000);
		System.out.println("************** Subtask"+ tasknum +": " + summary.getText()+ "**************");
		if(tasknum == 1) {
			updateAssignmentGroup();
			updateAssinee();
			inProgressTransition();
			onHoldTransition();
			closeTransition();
			System.out.println("************** Closed Subtask "+ tasknum +"**************");
		}
		else if(tasknum == 2){
			//updateAssignmentGroup();
			//updateAssinee();
			SelectRole();
			
		}
		else{
			updateAssignmentGroup();
			updateAssinee();
			inProgressTransition();
			onHoldTransition();
			closeTransition();
			System.out.println("************** Closed Subtask "+ tasknum +"**************");
		}
		
	}

	private void SelectRole() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@class='issue-link link-title']")).click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		statusDropDown.click();
		Thread.sleep(1000);
		SelectRole.click();
		Thread.sleep(5000);
		
		RequestorBUClick.click();
		Thread.sleep(5000);
		RequestorBU.sendKeys("Test");
		Thread.sleep(5000);
		RequestorBU.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		RequestorSBUClick.click();
		Thread.sleep(5000);
		RequestorSBU.sendKeys("Test");
		Thread.sleep(5000);
		RequestorSBU.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		RoleClick.click();
		Thread.sleep(5000);
		Role.sendKeys("Testing");
		Thread.sleep(5000);
		Role.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		SelectRoleButton.click();
		Thread.sleep(5000);
		//Approval
		String name = driver.findElement(By.xpath("//li[@class='sd-approval-status-panel']/dl/dd/ul/li")).getText();
		Approval.switchUser();
		Approval.userProfileSwitch(name);
		//RBA subtask
		driver.findElement(By.xpath("//tr/td[@class='issuekey']/a")).click();
		updateAssignmentGroup();
		updateAssinee();
		driver.navigate().refresh();
		inProgressTransition();
		Thread.sleep(1000);
		RBAcloseTransition();
		driver.navigate().refresh();
		System.out.println("--------------------------------");
		System.out.println("Ticket Status: " + statusDropDown.getText());
		//moduleTicketData();
		driver.get(ParentTicket);
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(7000);
		System.out.println("************** Select Role Subtask closed  **************");
		
	}

	public void CancelRBASubtaskHandling(int tasknum) throws InterruptedException {
		
		driver.findElement(By.xpath("//tr[" + tasknum + "]/td[@class='issuekey']/a")).click();
		Thread.sleep(4000);
		System.out.println("************** Subtask"+ tasknum +": " + summary.getText()+ "**************");
		if(tasknum == 1) {
			updateAssignmentGroup();
			updateAssinee();
			inProgressTransition();
			onHoldTransition();
			closeTransition();
			System.out.println("************** Closed Subtask "+ tasknum +"**************");
		}
		else if(tasknum == 2){
			//updateAssignmentGroup();
			//updateAssinee();
			cancelRBA();
			
		}
		else{
			updateAssignmentGroup();
			updateAssinee();
			inProgressTransition();
			onHoldTransition();
			closeTransition();
			System.out.println("************** Closed Subtask "+ tasknum +"**************");
		}
		}
	
	
	public void RBANotRequiredSubtaskHandling(int tasknum) throws InterruptedException {
		driver.findElement(By.xpath("//tr[" + tasknum + "]/td[@class='issuekey']/a")).click();
		Thread.sleep(4000);
		System.out.println("************** Subtask"+ tasknum +": " + summary.getText()+ "**************");
		if(tasknum == 1) {
			updateAssignmentGroup();
			updateAssinee();
			inProgressTransition();
			onHoldTransition();
			closeTransition();
			System.out.println("************** Closed Subtask "+ tasknum +"**************");
		}
		else if(tasknum == 2){
			//updateAssignmentGroup();
			//updateAssinee();
			RBANotRequired();
			
		}
		else{
			updateAssignmentGroup();
			updateAssinee();
			inProgressTransition();
			onHoldTransition();
			closeTransition();
			System.out.println("************** Closed Subtask "+ tasknum +"**************");
		}
	}
	
	public void RoleMissingInRBAListSubtaskHandling(int tasknum) throws InterruptedException {
		driver.findElement(By.xpath("//tr[" + tasknum + "]/td[@class='issuekey']/a")).click();
		Thread.sleep(4000);
		System.out.println("************** Subtask"+ tasknum +": " + summary.getText()+ "**************");
		if(tasknum == 1) {
			updateAssignmentGroup();
			updateAssinee();
			inProgressTransition();
			onHoldTransition();
			closeTransition();
			System.out.println("************** Closed Subtask "+ tasknum +"**************");
		}
		else if(tasknum == 2){
			//updateAssignmentGroup();
			//updateAssinee();
			RoleMissingInRBA();
			
		}
		else{
			updateAssignmentGroup();
			updateAssinee();
			inProgressTransition();
			onHoldTransition();
			closeTransition();
			System.out.println("************** Closed Subtask "+ tasknum +"**************");
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
		
		public void cancelRBA() throws InterruptedException {
			driver.findElement(By.xpath("//a[@class='issue-link link-title']")).click();
			driver.navigate().refresh();
			Thread.sleep(2000);
			statusDropDown.click();
			Thread.sleep(1000);
			cancelRBA.click();
			Thread.sleep(5000);
			driver.navigate().refresh();
			driver.navigate().back();
			driver.navigate().back();
			System.out.println("--------------------------------");
			System.out.println("Ticket Status: " + statusDropDown.getText());
			//moduleTicketData();
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(7000);
			System.out.println("************** RBA Subtask cancelled **************");
			
		}
		
		public void RBANotRequired() throws InterruptedException {
			driver.findElement(By.xpath("//a[@class='issue-link link-title']")).click();
			driver.navigate().refresh();
			Thread.sleep(2000);
			statusDropDown.click();
			Thread.sleep(1000);
			RBANotRequired.click();
			Thread.sleep(3000);
			driver.navigate().refresh();
			driver.navigate().refresh();
			System.out.println("--------------------------------");
			System.out.println("Ticket Status: " + statusDropDown.getText());
			//moduleTicketData();
			driver.navigate().back();
			driver.navigate().back();
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(7000);
			System.out.println("************** RBA Not Required Subtask closed  **************");
		}
		
		public void RoleMissingInRBA() throws InterruptedException {
			driver.findElement(By.xpath("//a[@class='issue-link link-title']")).click();
			driver.navigate().refresh();
			Thread.sleep(2000);
			statusDropDown.click();
			Thread.sleep(1000);
			RoleMissingInRBAList.click();
			Thread.sleep(5000);
			
			RequestorBUClick.click();
			Thread.sleep(5000);
			RequestorBU.sendKeys("Test");
			Thread.sleep(5000);
			RequestorBU.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			RequestorSBUClick.click();
			Thread.sleep(5000);
			RequestorSBU.sendKeys("Test");
			Thread.sleep(5000);
			RequestorSBU.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			RoleMissingJustification.sendKeys("Testing Role missing in RBA");
			Thread.sleep(5000);
			RoleMissingButton.click();
			Thread.sleep(5000);
			//RBA subtask
			driver.findElement(By.xpath("//tr/td[@class='issuekey']/a")).click();
			updateAssignmentGroup();
			updateAssinee();
			driver.navigate().refresh();
			inProgressTransition();
			Thread.sleep(1000);
			RBAcloseTransition();
			driver.navigate().refresh();
			System.out.println("--------------------------------");
			System.out.println("Ticket Status: " + statusDropDown.getText());
			//moduleTicketData();
			driver.navigate().back();
			driver.navigate().back();
			driver.navigate().back();
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(7000);
			System.out.println("************** Role Missing in RBA List Subtask closed  **************");
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
			try {
				  Alert alert = driver.switchTo().alert();
				  alert.accept(); // or alert.dismiss(); to cancel the alert
				} catch (NoAlertPresentException e) {
				  System.out.println("No alert was present");
				}
			Thread.sleep(10000);
			System.out.println("--------------------------------");
			System.out.println(" ");
			System.out.println("Ticket Status: " + statusDropDown.getText());
			
		}
		
		public void closeTransition() throws InterruptedException {
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

				driver.navigate().refresh();
				Thread.sleep(2000);
				statusDropDown.click();
				close.click();
				Thread.sleep(2000);
				ClosureInformation.click();
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
				Thread.sleep(20000);
				try {
					  Alert alert = driver.switchTo().alert();
					  alert.accept(); // or alert.dismiss(); to cancel the alert
					} catch (NoAlertPresentException e) {
					  System.out.println("No alert was present");
					}
				Thread.sleep(25000);
				driver.navigate().refresh();
				System.out.println("--------------------------------");
				System.out.println("Ticket Status: " + statusDropDown.getText());
				//moduleTicketData();
				driver.navigate().back();
				Thread.sleep(5000);
				driver.navigate().refresh();
				Thread.sleep(7000);
			}
		
		public void RBAcloseTransition() throws InterruptedException {
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

				driver.navigate().refresh();
				Thread.sleep(2000);
				statusDropDown.click();
				RBAclose.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@class='form-body']/div[5]")).click();
				Select closecodevalue = new Select(closeCode);
				Thread.sleep(2000);
				closecodevalue.selectByIndex(2);
				Thread.sleep(2000);
				closeNote.sendKeys("Test ticket please ignore");
				Select ActualSizeValue = new Select(actualSize);
				Thread.sleep(2000);
				ActualSizeValue.selectByIndex(2);
				Thread.sleep(2000);
				driver.switchTo().frame(richTextAreaFrame);
				Thread.sleep(3000);
				onHoldCommentBody.sendKeys("Tested");
				Thread.sleep(3000);
				driver.switchTo().parentFrame();
				onHoldCloseButton.click();
				Thread.sleep(20000);
				try {
					  Alert alert = driver.switchTo().alert();
					  alert.accept(); // or alert.dismiss(); to cancel the alert
					} catch (NoAlertPresentException e) {
					  System.out.println("No alert was present");
					}
				Thread.sleep(20000);
				driver.navigate().refresh();
				System.out.println("--------------------------------");
				System.out.println("Ticket Status: " + statusDropDown.getText());
				//moduleTicketData();
				driver.navigate().back();
				Thread.sleep(3000);
				driver.navigate().refresh();
				Thread.sleep(7000);
			}
			}
