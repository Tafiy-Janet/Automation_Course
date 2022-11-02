package way2Automation;

import helpers.WebElementHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageUtils.BasePage;

import java.io.File;

public class Registration extends BasePage {
    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputName;
    @FindBy(xpath = "//div[@class='radio_wrap']//label[contains(text(),'Divorced')]")
    private WebElement divorcedButton;
    @FindBy(xpath = "//div[@class='radio_wrap']//label[contains(text(),'Cricket')]")
    private WebElement cricketButton;
    @FindBy(xpath = "//option[@value='India']")
    private WebElement countryField;
    @FindBy(xpath = "//form[@id='register_form']/fieldset[4]/select")
    private WebElement countrySelection;
    @FindBy(xpath = "//div[@class='time_feild']//option[contains(text(),'Month')]")
    private WebElement monthBirthField;
    @FindBy(xpath = "//fieldset[./label[contains(text(),'Date of Birth')]]//div[1]/select")
    private WebElement monthBirthSelection;
    @FindBy(xpath = "//div[@class='time_feild']//option[contains(text(),'Day')]")
    private WebElement dayBirth;
    @FindBy(xpath = "//fieldset[./label[contains(text(),'Date of Birth')]]//div[2]/select")
    private WebElement dayBirthSelection;
    @FindBy(xpath = "//div[@class='time_feild']//option[contains(text(),'Year')]")
    private WebElement yearBirth;
    @FindBy(xpath = "//fieldset[./label[contains(text(),'Date of Birth')]]//div[3]/select")
    private WebElement yearBirthSelection;
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement inputFile;
    @FindBy(xpath = "//textarea[@rows='5']")
    private WebElement aboutYourselfField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@name='c_password']")
    private WebElement passwordConfirmationField;
    @FindBy(xpath = "//input[@value='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//label[contains(.,'This field is required.')]")
    private WebElement errorMessage;
    private By errorMessageSelector = By.xpath("//label[contains(.,'This field is required.')]");

    @Step("Enter the name: {name}")
    public Registration enterName(String name) {
        inputName.sendKeys(name);
        return this;
    }

    @Step("Select marital status by clicking on radio button")
    public Registration chooseMaritalStatus() {
        divorcedButton.click();
        return this;
    }

    @Step("Select hobby by clicking on checkbox")
    public Registration chooseHobby() {
        cricketButton.click();
        return this;
    }

    @Step("Select India in country field")
    public Registration selectCountry() {
        countryField.click();
        countrySelection.click();
        return this;
    }

    @Step("Select date of birth")
    public Registration selectDateOfBirth() {
        monthBirthField.click();
        monthBirthSelection.click();
        dayBirth.click();
        dayBirthSelection.click();
        yearBirth.click();
        yearBirthSelection.click();
        return this;
    }

    @Step("Enter phone number: {phoneNumber}")
    public Registration enterPhoneNumber(String phoneNumber) {
        phoneNumberField.sendKeys(phoneNumber);
        return this;
    }

    @Step("Enter username: {username}")
    public Registration enterUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    @Step("Enter email: {email}")
    public Registration enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    @Step("Fill in short description: {description}")
    public Registration enterDescription(String description) {
        aboutYourselfField.sendKeys(description);
        return this;
    }

    @Step("Enter password: {password}")
    public Registration enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Confirm password: {password}")
    public Registration enterPasswordConfirm(String password) {
        passwordConfirmationField.sendKeys(password);
        return this;
    }

    @Step("Upload photo from {path}")
    public Registration uploadFile(String path) {
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat(path);
        inputFile.sendKeys(filePath);
        return this;
    }

    @Step("Check if right file was uploaded by getting its path after uploading")
    public String getUploadFileName() {
        return inputFile.getAttribute("value");
    }

    @Step("Click submit button")
    public Registration submit() {
        submitButton.click();
        return this;
    }

    @Step("Check whether registration was completed with updating obligatory name field")
    public boolean isNameEmpty() {
        return inputName.getAttribute("value").equals("");
    }

    @Step("Check whether registration was completed with updating obligatory username field")
    public boolean isUsernameEmpty() {
        return usernameField.getAttribute("value").equals("");
    }

    @Step("Check whether the error message is displayed")
    public boolean isErrorDisplayed() {
        return WebElementHelper.isElementPresent(errorMessageSelector);
    }

}
