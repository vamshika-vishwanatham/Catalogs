package utilities;

import java.util.ResourceBundle;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseSource.BaseClass;

public class GenericMethods extends BaseClass {

	@FindBy(xpath = "//div[@id='select2-drop']/div/input")
    public WebElement enterInput;
	@FindBy(xpath = "//div[@class='rw_item_footer']/button[2]/span")
    public WebElement submit;
	public ResourceBundle re = ResourceBundle.getBundle("QALogin");

	public void enterEmail(WebElement element) {
		element.sendKeys(re.getString("email"));
	}

	public void enterPassword(WebElement element) {
		element.sendKeys(re.getString("password"));
	}

	public void clickToSignIn(WebElement element) {
		element.click();
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public static void selectCatalog(WebElement element, String text) throws InterruptedException {
		element.click();
		Thread.sleep(3000);
		driver.switchTo().frame(text);
		Thread.sleep(3000);
		System.out.println("************** Opened Catalog **************");
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
