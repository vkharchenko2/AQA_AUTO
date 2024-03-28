package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationStep {

    public static final String URL = "https://qa-course-01.andersenlab.com/registration";
    private final SelenideElement firstNameInput = $x("//input[@placeholder='Fitst Name']");
    private final SelenideElement lastNameInput = $x("//input[@placeholder ='Last Name']");
    private final SelenideElement dateOfBirthInput = $x("//input[@placeholder='Date of birth']");
    private final SelenideElement emailInput = $x("//input[@placeholder='Enter email']");
    private final SelenideElement passwordInput = $x("//input[@placeholder='Enter password']");
    private final SelenideElement confirmPasswordInput = $x("//input[@placeholder='Confirm Password']");
    private final SelenideElement passwordsMustMatchErrorMessage = $x("//span[text()='Passwords must match']");
    private final SelenideElement submitBtn = $x("//button[@type='submit']");
    private final SelenideElement andersenLogo = $x("//img[@alt='logo']");

    @Given("Set up driver Selenide")
    public void set_up_driver_selenide() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.browserSize = "1920X1080";
    }

    @When("I am on Registration page Selenide")
    public void i_am_on_registration_page_selenide(){
        open(URL);
    }

    @And("I set {string}to FirstName field Selenide")
    public void enter_first_name_selenide(String firstName) {
        firstNameInput.setValue(firstName);
    }

    @And("I set {string}to LastName field Selenide")
    public void enter_last_name_selenide(String lastName) {
        lastNameInput.setValue(lastName);
    }

    @And("I set {string}to DateOfBirth field Selenide")
    public void enter_date_of_birth_selenide(String dateOfBirth) {
        dateOfBirthInput.setValue(dateOfBirth);
        dateOfBirthInput.sendKeys(Keys.ENTER);
    }

    @And("I set {string}to Email field Selenide")
    public void enter_email_selenide(String email) {
        emailInput.setValue(email);
    }

    @And("I set {string}to Password field Selenide")
    public void enter_password_selenide(String password) {
        passwordInput.setValue(password);
    }

    @And("I set {string}to ConfirmPassword field Selenide")
    public void enter_confirm_password_selenide(String confirmPassword) {
        confirmPasswordInput.setValue(confirmPassword);
    }

    @Then("I check passwords must match error message is displayed Selenide")
    public void is_passwords_must_match_error_message_displayed_selenide() {
        passwordsMustMatchErrorMessage.shouldBe(Condition.visible);
    }

    @And("I click on Submit button Selenide")
    public void click_on_submit_btn_selenide() {
        submitBtn.click();
    }

    @And("I click on Andersen logo Selenide")
    public void click_on_andersen_logo_selenide() {
        andersenLogo.click();
    }
}
