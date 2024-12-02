package QATestCases;

import java.time.Duration;

import org.testng.annotations.Test;

import baseSource.BaseClass;
import baseSource.LoginPageComponent;
import baseSource.SelectCatalogComponent;
import onBoardingtile.NewHireSubtaskHandling;
import onBoardingtile.NewHireTicketCreation;

public class NewHireRBANotRequiredQA extends BaseClass{

	@Test(priority = 1)
	public void NewHireOnboard() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		LoginPageComponent login = new LoginPageComponent();
		login.goTo();
		login.loginApplication();
	}
	
	@Test(priority = 2)
	public void NewHireCatalog() throws InterruptedException {
		
		SelectCatalogComponent catalog = new SelectCatalogComponent();
		catalog.serviceDeskPortal();
		windowHandle();
		catalog.onboardCatalog();
	}
	
	@Test(priority = 3)
	public void NewHireTicketCreation() throws InterruptedException {
		NewHireTicketCreation NHTC = new NewHireTicketCreation();
		NHTC.fillFormAndSubmit(); 
		Thread.sleep(30000);
		ITView();
		windowHandle();
		Thread.sleep(10000);
		driver.navigate().refresh();
		sideArrow();
	}
	 
	@Test(priority = 4)
	public void NewHireRBANotRequiredSubtasks() throws InterruptedException {
		NewHireSubtaskHandling subtask = new NewHireSubtaskHandling();
		subtask.selectSubtask("RBANotRequired");
		
	}
}
