package serverBuildTile;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseSource.BaseClass;

public class ServerBuildTicket extends BaseClass {

	
	public ResourceBundle rb = ResourceBundle.getBundle("QAFieldvaluedata");
	
	@FindBy(id="s2id_customfield_13200")
	WebElement iCatagory;
	
	@FindBy(id="s2id_customfield_13200:1")
	WebElement iSubCategory;
	
	@FindBy(id="customfield_13601")
	WebElement budgetApprovalNumber;
	
	@FindBy(xpath="//div[@id='insight-atlas-select-11325']") //input[@id='customfield_11325']
	WebElement application;
	
	@FindBy(id="customfield_11328")
	WebElement businessUnit;
	
	@FindBy(id="customfield_11329")
	WebElement subBusinessUnit;
	
	@FindBy(id="s2id_customfield_13669")
	WebElement serverOwner;
	
	@FindBy(xpath="//label[@for='customfield_132270']")
	WebElement operatingSystem; 
	
	@FindBy(xpath="//label[@for='customfield_134965']")
	WebElement serverLocation;
	
	@FindBy(xpath="//label[@for='customfield_134948']")
	WebElement domain;
	
	@FindBy(xpath="//label[@for='customfield_134972']")
	WebElement purposeoftheServer;
	
	@FindBy(xpath="//label[@for='customfield_134980']")
	WebElement configurations;
	
	@FindBy(id="customfield_13579")
	WebElement RAM;
	
	@FindBy(id="customfield_13580")
	WebElement CPU;
	
	@FindBy(id="customfield_13599")
	WebElement cDrive;
	
	@FindBy(id="customfield_13600")
	WebElement dDrive;
	
	@FindBy(id="s2id_customfield_13604")
	WebElement Vcenter;
	
	@FindBy(id="customfield_13582")
	WebElement VMWArecluster;
	
	@FindBy(id="customfield_13583")
	WebElement VMWareDC;
	
	@FindBy(id="customfield_13586")
	WebElement EPGvlan;
	
	@FindBy(id="customfield_13585")
	WebElement template;
	
	@FindBy(id="customfield_13211")
	WebElement IPAddress;
	
	@FindBy(id="customfield_13643")
	WebElement DNSservers1;
	
	@FindBy(id="customfield_13587")
	WebElement DNSservers2;
	
	@FindBy(id="s2id_customfield_13596")
	WebElement accesslevel;
	
	@FindBy(id="insight-atlas-select-13644")
	WebElement Team;
	
	@FindBy(id="customfield_13590")
	WebElement activeDirectoryGroup;
	
	@FindBy(id="s2id_customfield_13597")
	WebElement antivirusScans;
	
	@FindBy(id="s2id_customfield_13595")
	WebElement noofIPAddress;
	
	@FindBy(id="customfield_18706")
	WebElement EVMPPatchWindow;
	
	@FindBy(id="customfield_25002")
	WebElement diskSpaceSize;
	
	@FindBy(id="s2id_customfield_25003")
	WebElement diskSpaceUOM;
	
	@FindBy(id="s2id_customfield_25004") 
	WebElement isDatabaseServer;
	
	@FindBy(id="s2id_customfield_25006")
	WebElement backupsRequired;
	
	@FindBy(id= "s2id_customfield_25007")
	WebElement  typeOfBackups;
	
	@FindBy(id="customfield_12725")
	WebElement justification;
	
	@FindBy(id="s2id_customfield_13476")
	WebElement environment;
	
	@FindBy(id = "customfield_13594")
	WebElement Qty;
	
	@FindBy(id="customfield_13634")
	WebElement osConfiguration;
	
	@FindBy(id="customfield_19324")
	WebElement driveSpaceRequirements ;
	
	@FindBy(xpath="//fieldset[@aria-labelledby='customfield_13473-label']")
	WebElement typeOfDatabase;
	
	@FindBy(id="customfield_19323")
	WebElement SQLVersionRequirement;
	
	@FindBy(id="customfield_19325")
	WebElement oracleVersionRequirement;
	
	@FindBy(id="customfield_19326")
	WebElement dBVersionRequirement;
	
	@FindBy(id="customfield_19352")
	WebElement TypeOfDatabase;
	
	@FindBy(id="s2id_customfield_13605") //s2id_autogen80
	WebElement redundancyRequirements;
	
	@FindBy(id="s2id_customfield_13606")
	WebElement dataStoredintheDatabase;
	
	@FindBy(id="s2id_customfield_13607")
	WebElement securityRequirementsforDatabase;
	
	@FindBy(id="customfield_13608")
	WebElement estimatedSizeofDatabase;
	
	@FindBy(id="customfield_13609")
	WebElement serviceAccountsNeeded;
	
	@FindBy(xpath="//div[@id='select2-drop']/div/input")//react-select-3-input
	WebElement enterInput;
	
	@FindBy(xpath = "//div[@id = 's2id_customfield_18713']/ul/li/input")
	WebElement input;
	
	@FindBy(xpath="//div[@class='rw_item_footer']/button[2]/span")
	WebElement submit;
	
	public void formSubmission() throws InterruptedException {
		
		iCatagory.click();
		enterInput.sendKeys(rb.getString("iCatagory"));
		enterInput.sendKeys(Keys.ENTER);
		
		iSubCategory.click();
		enterInput.sendKeys(rb.getString("iSubCategory"));
		enterInput.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		budgetApprovalNumber.sendKeys(rb.getString("budgetApprovalNumber"));
		//Thread.sleep(5000);
		
		application.click();
		driver.findElement(By.id("react-select-3-input")).sendKeys(rb.getString("application"));
		Thread.sleep(1000);
		driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
		
		serverOwner.click();
		Thread.sleep(1000);
		enterInput.sendKeys(rb.getString("serverOwner"));
		Thread.sleep(1000);
		enterInput.sendKeys(Keys.ENTER);
		
		operatingSystem.click();
		
		environment.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys(rb.getString("environment"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);
		
		serverLocation.click();
		Thread.sleep(1000);
		domain.click();
		Thread.sleep(1000);
		purposeoftheServer.click();
		
		osConfiguration.sendKeys(rb.getString("osConfiguration"));
		Thread.sleep(2000);
		configurations.click();
		
		Vcenter.click();
		enterInput.sendKeys(rb.getString("Vcenter"));
		enterInput.sendKeys(Keys.ENTER);
		
		VMWArecluster.sendKeys(rb.getString("VMWArecluster"));
		
		VMWareDC.sendKeys(rb.getString("VMWareDC"));
		
		template.sendKeys(rb.getString("template"));
		
		EPGvlan.sendKeys(rb.getString("EPGvlan"));
		Thread.sleep(1000);
		IPAddress.sendKeys(rb.getString("IPAddress"));
		
		DNSservers1.sendKeys(rb.getString("DNSservers1"));
		
		DNSservers2.sendKeys(rb.getString("DNSservers2"));
		Thread.sleep(1000);
		
		accesslevel.click();
		enterInput.sendKeys(rb.getString("accesslevel"));
		enterInput.sendKeys(Keys.ENTER);
		
		Team.click();
		Thread.sleep(1000);
		driver.findElement(By.id("react-select-12-input")).sendKeys(rb.getString("Team"));
		Thread.sleep(2000);
		driver.findElement(By.id("react-select-12-input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		EVMPPatchWindow.sendKeys(rb.getString("EVMPPatchWindow"));
		Thread.sleep(1000);
		
		activeDirectoryGroup.sendKeys(rb.getString("activeDirectoryGroup"));;
		
		antivirusScans.click();
		enterInput.sendKeys(rb.getString("antivirusScans"));
		enterInput.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		
		noofIPAddress.click();
		enterInput.sendKeys(rb.getString("noofIPAddress"));
		enterInput.sendKeys(Keys.ENTER);
		
		isDatabaseServer.click();
		enterInput.sendKeys(rb.getString("isDatabaseServer"));
		enterInput.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		
		backupsRequired.click();
		enterInput.sendKeys(rb.getString("backupsRequired"));
		Thread.sleep(1000);
		enterInput.sendKeys(Keys.ENTER);
		
		typeOfBackups.click();
		Thread.sleep(1000);
		driver.findElement(By.id("s2id_autogen90")).sendKeys(rb.getString("typeOfBackups"));
		Thread.sleep(1000);
		driver.findElement(By.id("s2id_autogen90")).sendKeys(Keys.ENTER);
		
		justification.sendKeys(rb.getString("justification"));
		
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		submit.click();
		
	}
}
