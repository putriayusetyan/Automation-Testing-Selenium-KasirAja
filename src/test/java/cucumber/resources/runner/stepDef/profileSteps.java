package cucumber.resources.runner.stepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class profileSteps {
    WebDriver driver;

    String baseUrl = "https://kasiraja.ajikamaludin.id/";

    @Given("the user is logged into KasirAja with {string} in email field and {string} in password field")
    public void theUserIsLoggedIntoKasirAjaWithInEmailFieldAndInPasswordField(String email, String password) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordField.sendKeys(password);

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/button"));
        submitButton.click();
    }

    @And("is on the KasirAja dashboard")
    public void isOnTheKasirAjaDashboard() {
        driver.findElement(By.xpath("//div[text()='dashboard']"));
        String username = driver.findElement(By.xpath("//div[text()='dashboard']")).getText();
        Assert.assertEquals(username, "dashboard");
    }

    @When("navigat e to edit profile account page")
    public void navigatEToEditProfileAccountPage() {
        driver.get("https://kasiraja.ajikamaludin.id/users/0592531b-ae3f-4096-9baa-50cfef443da0/edit");
    }

    @And("the user clear all the fields")
    public void theUserClearAllTheFields() {
        driver.findElement(By.xpath("//*[@id=\"nama\"]")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }

    @And("updates the profile with {string} in the nama field and {string} in email field")
    public void updatesTheProfileWithInTheNamaFieldAndInEmailField(String nama, String email) {
        WebElement namaField = driver.findElement(By.xpath("//*[@id=\"nama\"]"));
        namaField.sendKeys(nama);

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailField.sendKeys(email);

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/button"));
        submitButton.click();
    }

    @And("the user click {string} button")
    public void theUserClickButton(String buttonText) {
        // Assuming you have a button with the specified text.
        // Adjust the XPath expression based on your actual HTML structure.
        WebElement button = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/button"));
        button.click();
    }

    @Then("the users navigate to user management page")
    public void theUsersNavigateToUserManagementPage() {
        driver.get("https://kasiraja.ajikamaludin.id/users");
        driver.quit();
    }

    @Given("user logged into KasirAja with {string} in email field and {string} in password field")
    public void userLoggedIntoKasirAjaWithInEmailFieldAndInPasswordField(String email, String password) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordField.sendKeys(password);

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/button"));
        submitButton.click();
    }

    @And("navigate to edit profile account page")
    public void navigateToEditProfileAccountPage() {
        driver.get("https://kasiraja.ajikamaludin.id/users/0592531b-ae3f-4096-9baa-50cfef443da0/edit");
    }

    @And("the message should not be {string}")
    public void theMessageShouldNotBe(String notExpectedMessage) {
        WebElement messageElement = driver.findElement(By.id("//div[@role='alert']"));

        // Get the text of the message
        String actualMessage = messageElement.getText();

        // Verify if the actual message contains the expected text
        assertTrue("Expected message not displayed. Actual message: " + actualMessage,
                actualMessage.contains("success toko berhasil diubah"));

        // Verify that the message does not contain the specified notExpectedMessage
        assertTrue("Message contains the unexpected text: " + notExpectedMessage,
                !actualMessage.contains(notExpectedMessage));
        driver.quit();
    }

    @Then("the system should display error message")
    public void theSystemShouldDisplayErrorMessage() {
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div[1]"));
        assertTrue(errorMessage.isDisplayed());
        driver.quit();
    }
}
