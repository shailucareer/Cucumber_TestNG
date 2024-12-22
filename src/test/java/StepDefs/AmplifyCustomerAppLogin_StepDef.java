package StepDefs;

import StepDefs.util.DependencyInjector_Cucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AmplifyCustomerAppLogin_StepDef {

	DependencyInjector_Cucumber di;
	public AmplifyCustomerAppLogin_StepDef(DependencyInjector_Cucumber di) {
		this.di = di;
	}
	
	@Given("Customer App Login Screen is opened")
	public void customer_app_login_screen_is_opened() {
		di.launchAppiumDriver();
	}
	
	@Given("Perform Customer App Login")
	public void perform_customer_app_login() {
		di.getLoginCustomerApp().performLogin("+919967489701", "Amplify@123");
	}

	@Then("Customer App Dashboard is displayed")
	public void customer_app_dashboard_is_displayed() {
		
	}
}
