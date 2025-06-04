package org.example.actions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Playwright;

public class Actions {

    public static void main(String[] args) {
            Playwright playwright = Playwright.create();
            // Launch Chromium browser in non-headless mode
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Navigate to the login page (replace with your URL)
            page.navigate("https://www.saucedemo.com/v1/");

            // Type username (replace selector with actual username field selector)
            page.fill("//*[@type='text']", "standard_user");

            // Type password (replace selector with actual password field selector)
            page.fill("//*[@type='password']", "secret_sauce");

            // Click submit button (replace selector with actual submit button selector)
            page.click("//*[@type='submit']");

            // Wait for navigation or page load (optional, adjust as needed)
            page.waitForLoadState();

            Locator dropdown = page.locator("//*[@id=\"inventory_filter_container\"]/select");

            // Select by value
            dropdown.selectOption("Price (low to high)");


            // Close browser
            browser.close();
            playwright.close();
    }
}
