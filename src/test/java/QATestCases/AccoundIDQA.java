package QATestCases;
import java.time.Duration;
import java.util.ResourceBundle;

import org.testng.annotations.Test;

import baseSource.BaseClass;
import baseSource.LoginPageComponent;
import baseSource.SelectCatalogComponent;
import serverBuildTile.ApprovalComponent;
import serverBuildTile.SubtaskHandlingComponent;
import serverBuildTile.AccIdTicketCreation;


public class AccoundIDQA extends BaseClass{



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
		catalog.accIdCatalog();
		
		
		AccIdTicketCreation ticketCreation = new AccIdTicketCreation();
		ticketCreation.formSubmittion();
		
		ITView();
		windowHandle();
		multiThread();
		sideArrow();
		moduleTicketData();
		ApprovalComponent approval = new ApprovalComponent();
		SubtaskHandlingComponent subtask = new SubtaskHandlingComponent();
		int approvalLevels = 1;		//mention about approval levels
		for(int i=1;i<=approvalLevels;i++) {
		String approver = statusUpdate(i);
		System.out.println(approver);
		if("USER APPROVAL".equals(approver)) {
			approval.switchUser();
			approval.userProfileSwitch(rb.getString("approvername"));
		}
		else if("MANAGER APPROVAL".equals(approver)) {
			approval.switchUser();
			approval.userProfileSwitch(rb.getString("managername"));
		}
		subtask.selectSubtask();
		}
		}
}