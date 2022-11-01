package way2AutomationTests;

import base.BaseTest;
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
                .selectPhoneNumber(TestValues.PHONE_NUMBER)
                .enterUsername(TestValues.USERNAME)
                .enterEmail(TestValues.EMAIL)
                .enterDescription(TestValues.DESCRIPTION)
                .enterPassword(TestValues.PASSWORD)
                .submit();
        Assertions.assertTrue(register.isNameEmpty());
        Assertions.assertTrue(register.isUsernameEmpty());
    }

    @Test
    public void unsuccessfulRegistration(){
        var register = new Registration();
        register.chooseMaritalStatus()
                .chooseHobby()
                .enterCountry()
                .enterUsername(TestValues.USERNAME)
                .enterPassword(TestValues.PASSWORD)
                .submit();
        Assertions.assertTrue(register.isErrorDisplayed());
    }
}
