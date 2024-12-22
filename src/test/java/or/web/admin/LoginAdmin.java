package or.web.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.Util;

public class LoginAdmin {
	WebDriverWait wait;
	WebDriver driver;
	public LoginAdmin(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	private WebElement text_Email;

	@FindBy(name="password")
	private WebElement text_Password;

	@FindBy(xpath = "//button[.='Log in']")
	private WebElement button_Login;
	
	@FindBy(xpath = "//span[contains(@class,'icon-notification')]1")
	private WebElement button_Notification;
	
	public void performLogin() {
		
		wait.until(ExpectedConditions.visibilityOf(text_Email)).sendKeys("email@yopmail.com");
		text_Password.sendKeys("Password");
		button_Login.click();
		
		wait.until(ExpectedConditions.visibilityOf(button_Notification));
		
		Util.wait(5);
		
	}
	
}
