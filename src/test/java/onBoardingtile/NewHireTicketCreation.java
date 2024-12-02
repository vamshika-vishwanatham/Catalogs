package onBoardingtile;

import java.util.ResourceBundle;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseSource.BaseClass;

public class NewHireTicketCreation extends BaseClass {

	public ResourceBundle rb = ResourceBundle.getBundle("QAOnboardData");
   

    @FindBy(id = "s2id_customfield_12703")
    public WebElement Rehire;

    @FindBy(id = "customfield_12741")
    public WebElement AssociateID;

    @FindBy(id = "customfield_12728")
    public WebElement AssociateName;

    @FindBy(id = "customfield_11602")
    public WebElement UserName;

    @FindBy(id = "customfield_12743")
    public WebElement Division;

    @FindBy(id = "s2id_customfield_12744")
    public WebElement Manager;

    @FindBy(id = "customfield_12717")
    public WebElement Department;

    @FindBy(id = "customfield_11658")
    public WebElement PhoneNumber;

    @FindBy(id = "customfield_11604")
    public WebElement EmailID;

    @FindBy(id = "s2id_customfield_12746")
    public WebElement PhoneType;

    @FindBy(id = "customfield_12749")
    public WebElement BadgeNumber;

    @FindBy(id = "customfield_12748")
    public WebElement TokenNumber;

    @FindBy(id = "customfield_12753")
    public WebElement Title;

    @FindBy(id = "customfield_11605")
    public WebElement HireDate;

    @FindBy(id = "customfield_12750")
    public WebElement FaxNumber;

    @FindBy(id = "s2id_customfield_12754")
    public WebElement EmploymentType;

    @FindBy(id = "customfield_12752")
    public WebElement MACAddress;

    @FindBy(id = "customfield_12715")
    public WebElement Company;

    @FindBy(id = "customfield_12747")
    public WebElement PhoneModel;

    @FindBy(id = "customfield_12755")
    public WebElement Full_PartTime;

    @FindBy(id = "customfield_12716")
    public WebElement LOB;

    @FindBy(id = "customfield_12724")
    public WebElement PrimaryRole;

    @FindBy(id = "customfield_12751")
    public WebElement PCName;

    @FindBy(id = "customfield_12756")
    public WebElement ContractEndDate;

    @FindBy(id = "customfield_12718")
    public WebElement Location;

    @FindBy(id = "s2id_customfield_12757")
    public WebElement DocumentsVerified;

    @FindBy(id = "s2id_customfield_12706")
    public WebElement Domain;

    @FindBy(id = "customfield_12758")
    public WebElement Solution;

    @FindBy(id = "s2id_customfield_12745")
    public WebElement ManagerSystemDomain;

    @FindBy(id = "customfield_12760")
    public WebElement RollUp;

    @FindBy(id = "customfield_12761")
    public WebElement AgencyName;

    @FindBy(id = "customfield_12763")
    public WebElement PrimaryEmail;

    @FindBy(xpath = "//div[@id='select2-drop']/div/input")
    public WebElement enterInput;

    @FindBy(xpath = "//div[@class='rw_item_footer']/button[2]/span")
    public WebElement submit;

    @FindBy(xpath = "//*[@id='rw_iframe']")
    public WebElement iframe;

 
    public void fillFormAndSubmit() throws InterruptedException {
        
        fillDropdownField(Rehire, rb.getString("Rehire"));
        fillTextField(AssociateID, rb.getString("AssociateID"));
        fillTextField(AssociateName, rb.getString("AssociateName"));
        fillTextField(UserName, rb.getString("UserName"));
        fillTextField(Division, rb.getString("Division"));
        fillDropdownField(Manager, rb.getString("Manager"));
        fillTextField(Department, rb.getString("Department"));
        fillTextField(PhoneNumber, rb.getString("PhoneNumber"));
        fillTextField(EmailID, rb.getString("EmailID"));
        fillDropdownField(PhoneType, rb.getString("PhoneType"));
        fillTextField(BadgeNumber, rb.getString("BadgeNumber"));
        fillTextField(TokenNumber, rb.getString("TokenNumber"));
        fillTextField(Title, rb.getString("Title"));
        fillTextField(HireDate, rb.getString("HireDate"));
        fillTextField(FaxNumber, rb.getString("FaxNumber"));
        fillDropdownField(EmploymentType, rb.getString("EmploymentType"));
        fillTextField(MACAddress, rb.getString("MACAddress"));
        fillTextField(Company, rb.getString("Company"));
        fillTextField(PhoneModel, rb.getString("PhoneModel"));
        fillTextField(Full_PartTime, rb.getString("Full_PartTime"));
        fillTextField(LOB, rb.getString("LOB"));
        fillTextField(PrimaryRole, rb.getString("PrimaryRole"));
        fillTextField(PCName, rb.getString("PCName"));
        fillTextField(ContractEndDate, rb.getString("ContractEndDate"));
        fillTextField(Location, rb.getString("Location"));
        fillDropdownField(DocumentsVerified, rb.getString("DocumentsVerified"));
        fillDropdownField(Domain, rb.getString("Domain"));
        fillTextField(Solution, rb.getString("Solution"));
        fillDropdownField(ManagerSystemDomain, rb.getString("ManagerSystemDomain"));
        fillTextField(RollUp, rb.getString("RollUp"));
        fillTextField(AgencyName, rb.getString("AgencyName"));
        fillTextField(PrimaryEmail, rb.getString("PrimaryEmail"));
        submitForm();
    }


    public void fillTextField(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void fillDropdownField(WebElement element, String value) throws InterruptedException {
        element.click();
        enterInput.sendKeys(value);
        Thread.sleep(1000); // Wait for dropdown to appear
        enterInput.sendKeys(Keys.ENTER);
    }

    public void submitForm() throws InterruptedException {
        driver.switchTo().parentFrame();
        submit.click();
        Thread.sleep(5000); // Wait for form submission
    }

}
