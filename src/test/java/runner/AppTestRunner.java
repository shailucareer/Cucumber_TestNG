package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/feature/app" }, glue = {
		"StepDefs" }, tags = "@run", monochrome = true, plugin = { "pretty", "html:target/HtmlReports/report1.html", "json:target/json-cucumber-reports/cukejson1.json",
				"testng:target/testng-cucumber-reports/cuketestng1.xml", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" })
public class AppTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}