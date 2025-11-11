package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By submitButton = By.id("submit");
    private By successMessage = By.xpath("//h1[contains(text(),'Logged In')]");
    private By errorMessage = By.id("error");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public boolean isLoginSuccessful() {
        return driver.findElements(successMessage).size() > 0;
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
