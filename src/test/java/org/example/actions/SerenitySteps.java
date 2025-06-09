package org.example.actions;

import com.microsoft.playwright.*;
import net.serenitybdd.annotations.Step;
import net.thucydides.core.model.screenshots.ScreenshotPermission;
import net.thucydides.model.domain.TakeScreenshots;
import net.thucydides.model.webdriver.Configuration;
import net.thucydides.model.webdriver.WebdriverAssertionError;

import java.nio.file.Paths;


public class SerenitySteps {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    public SerenitySteps(Playwright playwright, Browser browser, BrowserContext context, Page page) {
        this.playwright = playwright;
        this.browser = browser;
        this.context = context;
        this.page = page;


    }


   /* public void takeScreenshot(String name) {
        Configuration configuration = new WebdriverAssertionError();
        ScreenshotPermission screenshots = new ScreenshotPermission(page.e);
        if (screenshots.areAllowed(TakeScreenshots.FOR_FAILURES)) {
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(name + ".png")));
        }}
    }*/
    @Step("Open web browser")
    public void openWebBrowser() {

        //page = context.newPage();
    }

    @Step("Navigate to login page")
    public void navigateToLoginPage() {
        page.navigate("https://www.saucedemo.com/v1/");
    }

    @Step("Enter valid username")
    public void enterValidUsername() {
        page.fill("//*[@type='text']", "standard_user");
    }

    @Step("Enter valid password")
    public void enterValidPassword() {
        page.fill("//*[@type='password']", "secret_sauce");
    }

    @Step("Click submit button")
    public void clickSubmitButton() {
        page.click("//*[@type='submit']");
        page.waitForLoadState();
    }

    @Step("Select dropdown option")
    public void selectDropdownOption() {
        Locator dropdown = page.locator("//*[@id=\"inventory_filter_container\"]/select");
        dropdown.selectOption("Price (low to high)");
    }

    @Step("Close web browser")
    public void closeWebBrowser() {

        browser.close();
        playwright.close();
    }


}