package QATestCases;
import java.time.Duration;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import baseSource.BaseClass;
import baseSource.LoginPageComponent;
import baseSource.SelectCatalogComponent;
import serverBuildTile.ApprovalComponent;
import serverBuildTile.ServerBuildTicket;
import serverBuildTile.SubtaskHandlingComponent;


public class InfraQA extends BaseClass{

	public ResourceBundle rb = ResourceBundle.getBundle("QAFieldvaluedata");
	
		@Test	
		public void accIdCatalog() throws InterruptedException {
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPageComponent loginPage = new LoginPageComponent();
		
		loginPage.goTo();
		loginPage.loginApplication();
		
		SelectCatalogComponent catalog = new SelectCatalogComponent();
		catalog.serviceDeskPortal();
		windowHandle();
		catalog.infraCatalog();
		
		ServerBuildTicket ServerBuild = new ServerBuildTicket();
		ServerBuild.formSubmission();
		Thread.sleep(10000);
		ITView();
		windowHandle();
		
		Thread.sleep(20000);
		driver.navigate().refresh(); 
		moduleTicketData();
		sideArrow();
		ApprovalComponent approval = new ApprovalComponent();
		SubtaskHandlingComponent subtask = new SubtaskHandlingComponent();
		int approvalLevels = 2;		//mention about approval levels
		for(int i=1;i<=approvalLevels;i++) {
		String approver = statusUpdate(i);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.navigate().refresh();
		String name = driver.findElement(By.xpath("//li[@class='sd-approval-status-panel']/dl/dd/ul/li")).getText();
		System.out.println(name);
		if("USER APPROVAL".equals(approver)) {
			approval.switchUser();
			approval.userProfileSwitch(name);//userapprover
			Thread.sleep(60000);
			driver.navigate().refresh();
		}
		else if("MANAGER APPROVAL".equals(approver)) {
			approval.switchUser();
			approval.userProfileSwitch(name);//managername
		}
		subtask.selectSubtask();
		}
		}
}