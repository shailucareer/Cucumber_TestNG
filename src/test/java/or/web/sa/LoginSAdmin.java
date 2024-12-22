package or.web.sa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSAdmin {
	public LoginSAdmin(WebDriver driver, WebDriverWait wait) {
		PageFactory.initElements(driver, this);
	}
	
}
