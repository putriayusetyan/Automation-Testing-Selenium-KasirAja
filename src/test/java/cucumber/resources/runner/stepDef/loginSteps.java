package cucumber.resources.runner.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class loginSteps {
    WebDriver driver;
    String baseUrl = "https://kasiraja.ajikamaludin.id/";

    @Given("Login Page kasirAja")
    public void loginPageKasirAja() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @When("Input email {string}")
    public void inputEmail(String email) {
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailField.sendKeys(email);
    }

    @And("Input Password {string}")
    public void inputPassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordField.sendKeys(password);
    }

    @And("Click login button")
    public void clickLoginButton() {
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/button"));
        submitButton.click();
    }

    @Then("User in on dashboard page")
    public void userInOnDashboardPage() {
        driver.findElement(By.xpath("//div[text()='dashboard']"));
        String username = driver.findElement(By.xpath("//div[text()='dashboard']")).getText();
        Assert.assertEquals(username, "dashboard");
        driver.close();
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[1]"));
        assertTrue(errorMessage.isDisplayed());
        driver.quit();
    }
}
