package or.web.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.Util;

public class LoginCustomer {
	WebDriverWait wait;
	WebDriver driver;
	public LoginCustomer(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[.='Log in']")
	private WebElement button_Login;
	
	@FindBy(name="userName")
	private WebElement text_UserName;

	@FindBy(name="password")
	private WebElement text_Password;

	@FindBy(xpath = "(//button[.='Log in'])[2]")
	private WebElement button_Login_Form;
	
	@FindBy(xpath = "//span[contains(@class,'icon-notification')]1")
	private WebElement button_Notification;
	
	
	public void performLogin() {
		
		RemoteWebElement d=null;
		
		button_Login.click();
		wait.until(ExpectedConditions.visibilityOf(text_UserName)).sendKeys("+919967489701");
		text_Password.sendKeys("Password");
		button_Login_Form.click();
		
		wait.until(ExpectedConditions.visibilityOf(button_Notification));
		
		Util.wait(5);
		
	}
}
