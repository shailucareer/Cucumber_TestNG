package StepDefs.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks_Cucumber {

	DependencyInjector_Cucumber di;

	public Hooks_Cucumber(DependencyInjector_Cucumber di) {
		this.di = di;
	}

	@Before
	public void setUp(Scenario sc) {
		System.out.println(Thread.currentThread().getId() + " Hooks : Before " + sc.getName() + sc.getSourceTagNames());

		if (sc.getSourceTagNames().contains("@web")) {
			di.launchWebDriver();
		} else if (sc.getSourceTagNames().contains("@app")) {
			di.launchAppiumDriver();
		}

	}

	@After
	public void tearDown(Scenario sc) {
		System.out.println(Thread.currentThread().getId() + " Hooks : After" + sc.getSourceTagNames() + sc.getSourceTagNames().contains("@app"));

		
		if (sc.getSourceTagNames().contains("@web")) {
			if (sc.isFailed()) {
				final byte[] screenshot = ((TakesScreenshot) di.getWebDriver()).getScreenshotAs(OutputType.BYTES);
				sc.attach(screenshot, "image/png", sc.getName()); // ... and embed it in the report.
			}
			di.tearDownWebDriver();
			
		} else if (sc.getSourceTagNames().contains("@app")) {
			
			System.out.println(Thread.currentThread().getId()+" App tearDown()");
			if (sc.isFailed()) {
				System.out.println(Thread.currentThread().getId()+" App tearDown() FAILED");
				final byte[] screenshot = ((TakesScreenshot) di.getAppiumDriver()).getScreenshotAs(OutputType.BYTES);
				sc.attach(screenshot, "image/png", sc.getName()); // ... and embed it in the report.
			}
			di.tearDownAppiumDriver();
	
		}
		
		

	}
}
