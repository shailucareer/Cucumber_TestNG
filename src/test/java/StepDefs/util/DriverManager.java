package StepDefs.util;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.util.Prop;

import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	static synchronized WebDriver launchWebDriver() {
		System.out.println(Thread.currentThread().getId() + " DI: launchWebDriver()");

		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}
	
	static synchronized AndroidDriver<WebElement> launchAppiumDriver() {
		try {
			System.out.println(Thread.currentThread().getId() + " DI: launchWebDriver()");

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("appPackage", "com.miui.calculator");
			cap.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity");

			String emulatorDevice = Prop.getProp("mobile_emulator");
			if ("Y".equalsIgnoreCase(emulatorDevice)) {
				/**
				 * EMULATOR CAPABILITIES
				 * 
				 * To Open Emulator from terminal 
				 * emulator -list-avds 
				 * //lists the emulators by name 
				 * emulator -avd Pixel_4_API_30 
				 * //To Start the emulator w/o opening Android Studio 
				 * cd %ANDROID_HOME%\emulator && emulator -avd Pixel_3a_API_30
				 */
				
				cap.setCapability("deviceName", "sdk_gphone_x86");
				cap.setCapability("udid", "emulator-5554");
				cap.setCapability("platformName", "Android");
				cap.setCapability("platformVersion", "11");

			} else {

				/**
				 * PHYSICAL DEVICE CAPABILITIES
				 */
				cap.setCapability("deviceName", "can't find");
				cap.setCapability("udid", "67692be2");
				cap.setCapability("platformName", "Android");
				cap.setCapability("platformVersion", "11 RKQ1.200826.002");
			}

			URL url = new URL("http://127.0.0.1:4723/wd/hub");

			return new AndroidDriver<WebElement>(url, cap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	static synchronized void loadUrl(WebDriver driver, String site) {
		System.out.println(Thread.currentThread().getId() + " DI: loadUrl()");

		String url = "";
		switch (site) {
		case "SUPER_ADMIN":
			url = Prop.getProp("superAdminUrl");
			break;
		case "ADMIN":
			url = Prop.getProp("adminUrl");
			break;
		case "CUSTOMER":
			url = Prop.getProp("customerUrl");
			break;
		}
		driver.get(url);
	}
}
