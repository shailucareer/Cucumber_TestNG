package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/feature/web" }, glue = {
		"StepDefs" }, tags = "@run", monochrome = true, plugin = { "pretty", "html:target/HtmlReports/report2.html", "json:target/json-cucumber-reports/cukejson2.json",
				"testng:target/testng-cucumber-reports/cuketestng2.xml", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" })
public class WebTestRunner extends AbstractTestNGCucumberTests {

	
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}