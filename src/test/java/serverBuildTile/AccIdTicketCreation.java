package serverBuildTile;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseSource.BaseClass;

public class AccIdTicketCreation extends BaseClass{


	public ResourceBundle rb = ResourceBundle.getBundle("QAFieldvaluedata");
	
	
	
	@FindBy(id="s2id_customfield_13223")
	WebElement category;
	
	@FindBy(id="s2id_customfield_13223:1")
	WebElement subCategory;
	
	@FindBy(id="s2id_customfield_28000")
	WebElement typeOfRequest;
	
	@FindBy(id="s2id_customfield_27101")
	WebElement accessType;
	
	@FindBy(id="s2id_customfield_27102")
	WebElement environment;
	
	@FindBy(id="s2id_customfield_27113")
	WebElement sharedSystemFolder;
	
	@FindBy(name="customfield_27114")
	WebElement sharedFolderPath;
	
	@FindBy(id="s2id_customfield_27115")
	WebElement sharedFolderAccessType;
	
	@FindBy(id="s2id_customfield_28002")
	WebElement SQLServer;
	
	@FindBy(id="customfield_27117")
	WebElement ReportURL_ServerDetails;
	
	@FindBy(id="s2id_customfield_27118")
	WebElement jumpServer;
	
	@FindBy(id="s2id_customfield_28003")
	WebElement providerPortal;
	
	@FindBy(id="s2id_customfield_27120")
	WebElement userRole;
	
	@FindBy(id="customfield_11560")
	WebElement dateNeedBy;
	
	@FindBy(id="customfield_11543")
	WebElement justification;
	
	@FindBy(xpath="//div[@class='rw_item_footer']/button[2]/span")
	WebElement submit;
	
	@FindBy(xpath="//div[@id='select2-drop']/div/input")
	WebElement enterInput;
	
	@FindBy(id="s2id_customfield_19523")
	WebElement access_Type;
	
	
	
	public void formSubmittion() throws InterruptedException {
		
		
		category.click();
		enterInput.sendKeys(rb.getString("category"));
		enterInput.sendKeys(Keys.ENTER);
		
		subCategory.click();
		enterInput.sendKeys(rb.getString("subCategory"));
		enterInput.sendKeys(Keys.ENTER);
		
		String subcatvalue = subCategory.getText();
		
		if("VA RAC".equals(subcatvalue)) {
		typeOfRequest.click();
		enterInput.sendKeys(rb.getString("typeOfRequest"));
		enterInput.sendKeys(Keys.ENTER);
		
		String requestTypeText = typeOfRequest.getText();  
	    if ("Access Request".equals(requestTypeText)) {
			
		accessType.click();
		enterInput.sendKeys(rb.getString("accessType"));
		enterInput.sendKeys(Keys.ENTER);
		
		environment.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[1]")).click();
		
		sharedSystemFolder.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]")).click();
		
		String val1 = sharedSystemFolder.getText();
		if("Yes".equals(val1)) {
		sharedFolderPath.sendKeys(rb.getString("sharedFolderPath"));
		
		sharedFolderAccessType.click();
		enterInput.sendKeys(rb.getString("sharedFolderAccessType"));
		enterInput.sendKeys(Keys.ENTER);
		}
		
		SQLServer.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]")).click();
		String val = SQLServer.getText();
		if("Yes".equals(val)) {
		ReportURL_ServerDetails.sendKeys(rb.getString("ReportURL_ServerDetails"));
		}
		
		jumpServer.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[3]")).click();
		
		providerPortal.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]")).click();
		String val2 = SQLServer.getText();
		if("Yes".equals(val2)) {
		userRole.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]")).click();
		}
		
		dateNeedBy.sendKeys(rb.getString("dateNeedBy"));
		
		justification.sendKeys(rb.getString("justification"));
		
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		
		submit.click();
		}
		
		else {
			
			justification.sendKeys(rb.getString("justification"));
			driver.switchTo().parentFrame();
			Thread.sleep(3000);
			
			submit.click();
		}
		}
		
		if("Jira Work Management (JWM)".equals(subcatvalue)){
			
			Thread.sleep(3000);
			access_Type.click();
			driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[3]")).click();
			
			justification.sendKeys(rb.getString("justification"));
			driver.switchTo().parentFrame();
			Thread.sleep(3000);
			
			submit.click();
		}
	}
	
}
