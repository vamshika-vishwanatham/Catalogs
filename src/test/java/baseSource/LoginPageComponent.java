package baseSource;

import java.util.ResourceBundle;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.GenericMethods;

public class LoginPageComponent extends BaseClass {


	
	public ResourceBundle rb=ResourceBundle.getBundle("QALogin");
	
	@FindBy(xpath="//input[@name ='identifier']")
	WebElement emailId;
	//WebElement emailIds = driver.findElement(By.xpath(rb.getString("emailId")));
	@FindBy(xpath="//input[@name='credentials.passcode']")
	WebElement passcode;
	@FindBy(xpath="//input[@value='Sign in']")
	WebElement signIn;
	@FindBy(xpath="//input[@value='Receive a code via SMS']")
	WebElement codeViaSMS;
	@FindBy(name="credentials.passcode")
	WebElement enterCode;
	@FindBy(xpath="//input[@value='Verify']")
	WebElement verify; 
	@FindBy(xpath="//div[@role='alert']/p")
	WebElement errorMessage;
	GenericMethods generic = new GenericMethods();
	
	public void goTo() throws InterruptedException {
		
		driver.get(rb.getString("url"));
		Thread.sleep(2000);
	}
	
	public void loginApplication() throws InterruptedException {
		generic.enterEmail(emailId);
		generic.enterPassword(passcode);
		generic.clickToSignIn(signIn);
		Thread.sleep(5000);
		generic.clickElement(codeViaSMS);
		generic.clickElement(enterCode);
		Thread.sleep(15000);
		generic.clickElement(verify);
		System.out.println("**************logged in**************");
		
		/*
		 * emailId.sendKeys(rb.getString("email"));
		 * passcode.sendKeys(rb.getString("password")); signIn.click();
		 * Thread.sleep(5000); codeViaSMS.click(); otpVerification(enterCode,verify);
		 * System.out.println("**************logged in**************");
		 */
	}
	
	


	public String loginErrorMessage() throws InterruptedException {
		Thread.sleep(5000);
		return errorMessage.getText();
		}
}
