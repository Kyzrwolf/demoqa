package com.demoqa.tests;

import org.junit.jupiter.api.Test;
import com.demoqa.pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName("Vasiliy")
                .setLastName("Pupkin")
                .setEmail("VasiliyPupkin@mail.ru")
                .setGender("Male")
                .setPhoneNumber("7912345678")
                .setDateOfBirth("022","September","1984")
                .setSubjects("English", "Maths")
                .setHobbies("Sports","Reading","Music")
                .uploadPicture("1606135682168725538.jpg")
                .setCurrentAddress("Lenina street 54")
                .setStateAndCity("Rajasthan", "Jaipur")
                .clickSubmitButton()
                .checkModalWindow();

        registrationPage
                .checkResults("Student Name", "Vasiliy Pupkin")
                .checkResults("Student Email", "VasiliyPupkin@mail.ru")
                .checkResults("Gender","Male")
                .checkResults("Mobile","7912345678")
                .checkResults("Date of Birth","22 September,1984")
                .checkResults("Subjects","English, Maths")
                .checkResults("Hobbies","Sports, Reading, Music")
                .checkResults("Picture","1606135682168725538.jpg")
                .checkResults("Address","Lenina street 54")
                .checkResults("State and City","Rajasthan Jaipur");
    }

    @Test
    void minRequiredFieldsRegistrationTest() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName("Helen")
                .setLastName("Head")
                .setGender("Female")
                .setPhoneNumber("8800555353")
                .clickSubmitButton()
                .checkModalWindow();

        registrationPage
                .checkResults("Student Name", "Helen Head")
                .checkResults("Gender","Female")
                .checkResults("Mobile","8800555353");
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName("1111111111111111111111")
                .setLastName("")
                .setPhoneNumber("                   ")
                .clickSubmitButton()
                .checkModalWindowNotVisible();
    }
}
