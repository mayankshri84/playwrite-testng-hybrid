package org.example.stepdef;

import com.microsoft.playwright.*;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import org.example.actions.SerenitySteps;


/**
 * Step definitions for the Serenity BDD test suite.
 * This class contains methods that are executed based on Cucumber steps.
 */

public class MyStepdefs {

   SerenitySteps steps;

    @Before
    public void setup() {
        // Initialize Playwright and other necessary components
         Playwright playwright = Playwright.create();
         Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
         BrowserContext context = browser.newContext();
         Page page = context.newPage();
         steps = new SerenitySteps(playwright, browser, context, page);
    }

    @Given("user opens web browser")
    public void user_opens_web_browser() {
        steps.openWebBrowser();
    }

    @When("user navigates to login page")
    public void user_navigates_to_login_page() {
        steps.navigateToLoginPage();
    }

    @Then("user should see login form")
    public void user_should_see_login_form() {
        // Optionally add a verification step here
    }

    @When("user enters valid username")
    public void user_enters_valid_username() {
        steps.enterValidUsername();
    }

    @When("user enters valid password")
    public void user_enters_valid_password() {
        steps.enterValidPassword();
    }

    @When("user enters submit button")
    public void user_enters_submit_button() {
        steps.clickSubmitButton();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        // Optionally add a verification step here
    }

    @Then("user selects dropdown option")
    public void user_selects_dropdown_option() {
        steps.selectDropdownOption();
    }

    @Then("user closes web browser")
    public void user_closes_web_browser() {
        steps.closeWebBrowser();
    }
}