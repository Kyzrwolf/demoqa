package com.demoqa.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.demoqa.pages.RegistrationPage;


public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Проверка успешной регистрации студента")
    void successfulRegistrationTest() throws InterruptedException {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(TestData.firstName)
                .setLastName(TestData.lastName)
                .setEmail(TestData.email)
                .setGender(TestData.gender)
                .setPhoneNumber(TestData.phoneNumber)
                .setDateOfBirth(TestData.addLeadingZeroes(TestData.DateOfBirth),TestData.month,TestData.year)
                .setSubjects(TestData.subjects)
                .setHobbies(TestData.randomHobbies)
                .uploadPicture(TestData.picturePath)
                .setCurrentAddress(TestData.currentAddress)
                .setStateAndCity(TestData.state, TestData.city)
                .clickSubmitButton()
                .checkModalWindow();

        Thread.sleep(5000);

        registrationPage
                .checkResults("Student Name", TestData.firstName + " " + TestData.lastName)
                .checkResults("Student Email", TestData.email)
                .checkResults("Gender",TestData.gender)
                .checkResults("Mobile",TestData.phoneNumber)
                .checkResults("Date of Birth",TestData.addLeadingZero(TestData.DateOfBirth) + " " + TestData.month + "," + TestData.year)
                .checkResults("Subjects", TestData.trimArray(TestData.subjects))
                .checkResults("Hobbies",TestData.trimArray(TestData.randomHobbies))
                .checkResults("Picture",TestData.picturePath)
                .checkResults("Address",TestData.currentAddress)
                .checkResults("State and City",TestData.state + " " + TestData.city);
    }

    @Test
    @DisplayName("Проверка успешной регистрации с минимальными данными")
    void minRequiredFieldsRegistrationTest() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(TestData.firstName)
                .setLastName(TestData.lastName)
                .setGender(TestData.gender)
                .setPhoneNumber(TestData.phoneNumber)
                .clickSubmitButton()
                .checkModalWindow();

        registrationPage
                .checkResults("Student Name", TestData.firstName + " " + TestData.lastName)
                .checkResults("Gender",TestData.gender)
                .checkResults("Mobile",TestData.phoneNumber);
    }

    @Test
    @DisplayName("Проверка не успешной регистрации")
    void negativeRegistrationTest() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(String.valueOf(Faker.instance().funnyName()))
                .setLastName("")
                .setPhoneNumber("")
                .clickSubmitButton()
                .checkModalWindowNotVisible();
    }
}
