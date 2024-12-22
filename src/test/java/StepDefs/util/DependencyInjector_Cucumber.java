package StepDefs.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.Prop;

import io.appium.java_client.AppiumDriver;
import or.app.customer.LoginCustomerApp;
import or.web.admin.LoginAdmin;
import or.web.customer.LoginCustomer;
import or.web.sa.LoginSAdmin;

public class DependencyInjector_Cucumber {
	private WebDriver driver;
	private AppiumDriver<WebElement> driverApp;
	private WebDriverWait wait;

	public DependencyInjector_Cucumber() {
		System.out.println(Thread.currentThread().getId() + " DI: constructor DependencyInjector_Cucumber @Before setUp()");
	}

	public void loadUrl(String site) {
		DriverManager.loadUrl(driver, site);
	}

	public void launchAppiumDriver() {
		driverApp = DriverManager.launchAppiumDriver();
		wait = new WebDriverWait(driverApp, Integer.parseInt(Prop.getProp("wait_explicit")));
	}

	public void launchWebDriver() {
		driver = DriverManager.launchWebDriver();
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Prop.getProp("wait_implicit")), TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Integer.parseInt(Prop.getProp("wait_explicit")));
	}

	public WebDriver getWebDriver() {
		System.out.println(Thread.currentThread().getId() + " DI: getWebDriver()");
		return driver;
	}

	public AppiumDriver<WebElement> getAppiumDriver() {
		System.out.println(Thread.currentThread().getId() + " DI: getAppiumDriver()");
		return driverApp;
	}

	public WebDriverWait getWait() {
		System.out.println(Thread.currentThread().getId() + " DI: getWait()");
		return wait;
	}

	public void tearDownWebDriver() {
		System.out.println(Thread.currentThread().getId() + " DI: @After tearDownWebDriver()");
		getWebDriver().quit();
	}

	public void tearDownAppiumDriver() {
		System.out.println(Thread.currentThread().getId() + " DI: @After tearDownAppiumDriver()");
		getAppiumDriver().quit();
	}

	public LoginAdmin getLoginAdmin() {
		return new LoginAdmin(getWebDriver(), getWait());
	}

	public LoginCustomer getLoginCustomer() {
		return new LoginCustomer(getWebDriver(), getWait());
	}

	public LoginSAdmin getLoginSAdmin() {
		return new LoginSAdmin(getWebDriver(), getWait());
	}

	public LoginCustomerApp getLoginCustomerApp() {
		return new LoginCustomerApp(getAppiumDriver(), getWait());
	}

}