package onBoardingtile;

import java.util.ResourceBundle;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseSource.BaseClass;

public class NewHireTicketCreation extends BaseClass {

	public ResourceBundle rb = ResourceBundle.getBundle("QAOnboardData");
	@FindBy(id="s2id_customfield_12703")
	WebElement Rehire;
	@FindBy(id="customfield_12741")
	WebElement AssociateID;
	@FindBy(id="customfield_12728")
	WebElement AssociateName;
	@FindBy(id="customfield_11602")
	WebElement UserName;
	@FindBy(id="customfield_12743")
	WebElement Division;
	@FindBy(id="s2id_customfield_12744")
	WebElement Manager;
	@FindBy(id="customfield_12717")
	WebElement Department;
	@FindBy(id="customfield_11658")
	WebElement PhoneNumber;
	@FindBy(id="customfield_11604")
	WebElement EmailID;
	@FindBy(id="s2id_customfield_12746")
	WebElement PhoneType;
	@FindBy(id="customfield_12749")
	WebElement BadgeNumber;
	@FindBy(id="customfield_12748")
	WebElement TokenNumber;
	@FindBy(id="customfield_12753")
	WebElement Title;
	@FindBy(id="customfield_11605")
	WebElement HireDate;
	@FindBy(id="customfield_12750")
	WebElement FaxNumber;
	@FindBy(id="s2id_customfield_12754")
	WebElement EmploymentType;
	@FindBy(id="customfield_12752")
	WebElement MACAddress;
	@FindBy(id="customfield_12715")
	WebElement Company;
	@FindBy(id="customfield_12747")
	WebElement PhoneModel;
	@FindBy(id="customfield_12755")
	WebElement Full_PartTime;
	@FindBy(id="customfield_12716")
	WebElement LOB;
	@FindBy(id="customfield_12724")
	WebElement PrimaryRole ;
	@FindBy(id="customfield_12751")
	WebElement PCName;
	@FindBy(id="customfield_12756")
	WebElement ContractEndDate;
	@FindBy(id="customfield_12718")
	WebElement Location;
	@FindBy(id="s2id_customfield_12757")
	WebElement DocumentsVerified;
	@FindBy(id="s2id_customfield_12706")
	WebElement Domain;
	@FindBy(id="customfield_12758")
	WebElement Solution;
	@FindBy(id="s2id_customfield_12745")
	WebElement ManagerSystemDomain;
	@FindBy(id="customfield_12760")
	WebElement RollUp;
	@FindBy(id="customfield_12761")
	WebElement AgencyName;
	@FindBy(id="customfield_12763")
	WebElement PrimaryEmail;
	@FindBy(xpath="//div[@id='select2-drop']/div/input")
	WebElement enterInput;
	@FindBy(xpath="//div[@class='rw_item_footer']/button[2]/span")
	WebElement submit;
	@FindBy(xpath="//*[@id='rw_iframe']")
	WebElement iframe;
	
public void formSubmittion() throws InterruptedException {
		
		//driver.switchTo().frame(iframe);
		Rehire.click();
		enterInput.sendKeys(rb.getString("Rehire"));
		Thread.sleep(1000);
		enterInput.sendKeys(Keys.ENTER);
		
		AssociateID.sendKeys(rb.getString("AssociateID"));
		//Thread.sleep(1000);
		AssociateName.sendKeys(rb.getString("AssociateName"));
		//Thread.sleep(1000);
		UserName.sendKeys(rb.getString("UserName"));
		//Thread.sleep(1000);
		Division.sendKeys(rb.getString("Division"));
		//Thread.sleep(1000);
		Manager.click();
		enterInput.sendKeys(rb.getString("Manager"));
		Thread.sleep(1000);
		enterInput.sendKeys(Keys.ENTER);
		
		Department.sendKeys(rb.getString("Department"));
		//Thread.sleep(1000);
		PhoneNumber.sendKeys(rb.getString("PhoneNumber"));
		//Thread.sleep(1000);
		EmailID.sendKeys(rb.getString("EmailID"));
		//Thread.sleep(1000);
		PhoneType.click();
		enterInput.sendKeys(rb.getString("PhoneType"));
		Thread.sleep(1000);
		enterInput.sendKeys(Keys.ENTER);
		
		BadgeNumber.sendKeys(rb.getString("BadgeNumber"));
		//Thread.sleep(1000);
		TokenNumber.sendKeys(rb.getString("TokenNumber"));
		//Thread.sleep(1000);
		Title.sendKeys(rb.getString("Title"));
		//Thread.sleep(1000);
		HireDate.sendKeys(rb.getString("HireDate"));
		//Thread.sleep(1000);
		FaxNumber.sendKeys(rb.getString("FaxNumber"));
		//Thread.sleep(1000);
		EmploymentType.click();
		enterInput.sendKeys(rb.getString("EmploymentType"));
		Thread.sleep(1000);
		enterInput.sendKeys(Keys.ENTER);
		
		MACAddress.sendKeys(rb.getString("MACAddress"));
		//Thread.sleep(1000);
		Company.sendKeys(rb.getString("Company"));
		//Thread.sleep(1000);
		PhoneModel.sendKeys(rb.getString("PhoneModel"));
		//Thread.sleep(1000);
		Full_PartTime.sendKeys(rb.getString("Full_PartTime"));
		//Thread.sleep(1000);
		LOB.sendKeys(rb.getString("LOB"));
		//Thread.sleep(1000);
		PrimaryRole.sendKeys(rb.getString("PrimaryRole"));
		//Thread.sleep(1000);
		PCName.sendKeys(rb.getString("PCName"));
		//Thread.sleep(1000);
		ContractEndDate.sendKeys(rb.getString("ContractEndDate"));
		//Thread.sleep(1000);
		Location.sendKeys(rb.getString("Location"));
		//Thread.sleep(1000);
		DocumentsVerified.click();
		enterInput.sendKeys(rb.getString("DocumentsVerified"));
		Thread.sleep(1000);
		enterInput.sendKeys(Keys.ENTER);
		
		Domain.click();
		enterInput.sendKeys(rb.getString("Domain"));
		Thread.sleep(1000);
		enterInput.sendKeys(Keys.ENTER);
		
		Solution.sendKeys(rb.getString("Solution"));
		//Thread.sleep(1000);
		ManagerSystemDomain.click();
		enterInput.sendKeys(rb.getString("ManagerSystemDomain"));
		Thread.sleep(1000);
		enterInput.sendKeys(Keys.ENTER);
		
		RollUp.sendKeys(rb.getString("RollUp"));
		//Thread.sleep(1000);
		AgencyName.sendKeys(rb.getString("AgencyName"));
		//Thread.sleep(1000);
		PrimaryEmail.sendKeys(rb.getString("PrimaryEmail"));
		Thread.sleep(1000);
		driver.switchTo().parentFrame();
		
		submit.click();
		Thread.sleep(5000);
		
		
}
}
