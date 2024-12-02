package baseSource;

import java.util.ResourceBundle;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageComponent extends BaseClass {


	public ResourceBundle rb=ResourceBundle.getBundle("QALogin");
	
	@FindBy(xpath="//input[@name ='identifier']")
	WebElement emailId;
	@FindBy(xpath="//input[@name='credentials.passcode']")
	WebElement passcode;
	@FindBy(xpath="//label[@for='input43']")
	WebElement keepMeSignedin;
	@FindBy(xpath="//div[@id='rememberme']/label") //login-form-remember-me
	WebElement rememberMyLogin;
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
	@FindBy(xpath="//input[@id='login-form-remember-me']")
	WebElement termsConditions;
	@FindBy(xpath="//button[@class='close terms-btn accept']")
	WebElement Accept;
	
	
	public void goTo() throws InterruptedException {
		
		driver.get(rb.getString("url"));
		Thread.sleep(2000);
	}
	
	public void loginApplication() throws InterruptedException {
		
		emailId.sendKeys(rb.getString("email"));
		passcode.sendKeys(rb.getString("password"));
		//Thread.sleep(2000);
		//rememberMyLogin.click();
		signIn.click();
		Thread.sleep(5000);
		codeViaSMS.click();
		otpVerification();
		
	}
	
public void loginSBApplication() throws InterruptedException {
		
		emailId.sendKeys(rb.getString("email"));
		passcode.sendKeys(rb.getString("password"));
		//Thread.sleep(2000);
		//termsConditions.click();
		//Accept.click();
		signIn.click();
		Thread.sleep(5000);
		codeViaSMS.click();
		otpVerification();
		
	}
	
	public void otpVerification() throws InterruptedException {
		
		enterCode.click();
		Thread.sleep(15000);
		verify.click();
		System.out.println("**************logged in**************");
		
		
	}


	public String loginErrorMessage() throws InterruptedException {
		Thread.sleep(5000);
		return errorMessage.getText();
		
		}
}
