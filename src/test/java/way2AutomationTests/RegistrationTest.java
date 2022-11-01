package way2AutomationTests;

import base.BaseTest;
import helpers.PropertyReader;
import helpers.TestValues;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import way2Automation.Registration;

@Tag("way2automation")
public class RegistrationTest extends BaseTest {
    @Test
    public void successfulFullRegistration() {
        var register = new Registration();
        register.enterName(TestValues.NAME)
                .chooseMaritalStatus()
                .chooseHobby()
                .enterCountry()
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
    public void unsuccessfulRegistration() {
        var register = new Registration();
        register.chooseMaritalStatus()
                .chooseHobby()
                .enterCountry()
                .enterUsername(TestValues.USERNAME)
                .enterPassword(TestValues.PASSWORD)
                .enterPasswordConfirm(TestValues.PASSWORD)
                .submit();
        Assertions.assertTrue(register.isErrorDisplayed());
    }

    @Test
    public void uploadPhoto(){
        var register = new Registration();
        register.uploadFile(PropertyReader.readPhotoPath());
        Assertions.assertTrue(register.getUploadFileName().contains("photo.jpg"));
    }

    /**
     * Bug report: Registration is confirmed with unequal passwords
     * Priority: High
     * Severity: Critical
     * Expected result: Error message appears under password fields.
     * Actual result: Error message does not appear.
     * Steps to reproduce: 1.Run unequalPasswords().
     **/
    @Test
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
