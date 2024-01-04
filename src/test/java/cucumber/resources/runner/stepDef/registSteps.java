package cucumber.resources.runner.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class registSteps {
    WebDriver driver;
    String baseUrl = "https://kasiraja.ajikamaludin.id/";

    @Given("the user opens the web and navigates to the URL")
    public void theUserOpensTheWebAndNavigatesToTheURL() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @When("the user clicks on the register page")
    public void theUserClicksOnTheRegisterPage() {
        WebElement registerLink = driver.findElement(new By.ByXPath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[3]/a"));
        registerLink.click();
    }

    @And("the user enters {string} in the nama field")
    public void theUserEntersInTheNamaField(String nama) {
        WebElement namaField = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        namaField.sendKeys(nama);
    }

    @And("the user enters {string} in the email field")
    public void theUserEntersInTheEmailField(String email) {
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailField.sendKeys(email);
    }

    @And("the user enters {string} in the password field")
    public void theUserEntersInThePasswordField(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordField.sendKeys(password);
    }

    @And("the user submits the registration form")
    public void theUserSubmitsTheRegistrationForm() {
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/button"));
        submitButton.click();
    }

    @Then("a success message appears")
    public void aSuccessMessageAppears() {
        String xpathExpression = "//*[contains(text(),'Toko berhasil didaftarkan')]";
        WebElement successMessageElement = driver.findElement(By.xpath(xpathExpression));
        driver.quit();
    }

    @Then("a error message appears")
    public void aErrorMessageAppears() {
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[1]"));
        assertTrue(errorMessage.isDisplayed());
        driver.quit();
    }
}
