package com.luma.automation.stepDefinitions;

import com.luma.automation.locators.RegisterNewAccountElements;
import com.luma.automation.utils.HelperClass;
import com.luma.automation.utils.PropertyFileHandling;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.en.*;

public class RegisterNewAccountSteps {
    RegisterNewAccountElements RegisterAccount;
    public RegisterNewAccountSteps() {
        this.RegisterAccount = new RegisterNewAccountElements();
        PageFactory.initElements(HelperClass.getDriver(), RegisterAccount);

    }

    @Given("User is in OrangeHRM login page")
    public void user_is_in_orange_hrm_login_page() {

        HelperClass.openPage(PropertyFileHandling.property("OrangeHrmURL"));

    }

    @Then("Verify user is in correct page")
    public void verify_user_is_in_correct_page() {
        String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String currentUrl=HelperClass.getDriver().getCurrentUrl();
        if(url.equals(currentUrl)) {
            System.out.println("Login Url: "+currentUrl);
        }
    }

    @When("User enters Username in Username input field")
    public void user_enters_username_in_username_input_field() throws InterruptedException {
        HelperClass.sleepTime();
        HelperClass.fillTheElement(RegisterAccount.HrmUsernameInputField,PropertyFileHandling.property("HrmUsername"));

    }

    @When("User enters Password in Password input field")
    public void user_enters_password_in_password_input_field() {
        HelperClass.fillTheElement(RegisterAccount.HrmPasswordInputField,PropertyFileHandling.property("HrmPassword"));

    }

    @When("User click on Login button")
    public void user_click_on_login_button() {
        HelperClass.clickOnElement(RegisterAccount.HrmLoginButton);

    }

    @Then("Verify User is in Secure Dashboard page")
    public void verify_user_is_in_secure_dashboard_page() {

    }

}
