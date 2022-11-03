package way2AutomationTests;

import base.BaseTest;
import helpers.PropertyReader;

import helpers.TestListener;
import helpers.TestValues;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import way2Automation.Registration;

@Tag("way2automation")
@DisplayName("Registration page testing")
@Feature("Registration form")
@ExtendWith(TestListener.class)
public class RegistrationTest extends BaseTest {

    @Test
    @Story("Complete registration")
    @Description("Fill in all input fields, radio button and checkbox to make successful registration")
    public void successfulFullRegistration() {
        var register = new Registration();
        register.enterName(TestValues.NAME)
                .chooseMaritalStatus()
                .chooseHobby()
                .selectCountry()
                .selectDateOfBirth()
                .enterPhoneNumber(TestValues.PHONE_NUMBER)
                .enterUsername(TestValues.USERNAME)
                .enterEmail(TestValues.EMAIL)
                .enterDescription(TestValues.DESCRIPTION)
                .enterPassword(TestValues.PASSWORD)
                .enterPasswordConfirm(TestValues.PASSWORD)
                .submit();
        Assertions.assertTrue(register.isNameEmpty());
        Assertions.assertTrue(register.isUsernameEmpty());
    }


    @Test
    @Story("Incomplete registration form")
    @Description("Not fill in obligatory input fields, such as name, email and phone number in order to get error message")
    public void unsuccessfulRegistration() {
        var register = new Registration();
        register.chooseMaritalStatus()
                .chooseHobby()
                .selectCountry()
                .enterUsername(TestValues.USERNAME)
                .enterPassword(TestValues.PASSWORD)
                .enterPasswordConfirm(TestValues.PASSWORD)
                .submit();
        Assertions.assertTrue(register.isErrorDisplayed());
    }

    @Test
    @Story("Upload avatar")
    @Description("Add profile picture to registration form")
    public void uploadPhoto() {
        var register = new Registration();
        register.uploadFile(PropertyReader.readPhotoPath());
        Assertions.assertTrue(register.getUploadFileName().contains("photo.jpg"));
    }

    @Test
    @Story("Enter unequal passwords")
    @Description("Write wrong password in field 'Confirm password' in order to get error message")
    public void unequalPasswords() {
        var register = new Registration();
        register.enterName(TestValues.NAME)
                .chooseMaritalStatus()
                .chooseHobby()
                .enterPhoneNumber(TestValues.PHONE_NUMBER)
                .enterUsername(TestValues.USERNAME)
                .enterEmail(TestValues.EMAIL)
                .enterPassword(TestValues.PASSWORD)
                .enterPasswordConfirm(TestValues.NOTFULLPASSWORD)
                .submit();
        Assertions.assertTrue(register.isErrorDisplayed());
    }

}
