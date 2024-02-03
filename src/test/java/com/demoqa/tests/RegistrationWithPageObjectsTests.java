package com.demoqa.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.demoqa.pages.RegistrationPage;


public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    @DisplayName("Проверка успешной регистрации студента")
    void successfulRegistrationTest() throws InterruptedException {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setPhoneNumber(testData.phoneNumber)
                .setDateOfBirth(testData.addLeadingZeroes(testData.DateOfBirth),testData.month,testData.year)
                .setSubjects(testData.subject)
                .setHobbies(testData.randomHobbies)
                .uploadPicture(testData.picturePath)
                .setCurrentAddress(testData.currentAddress)
                .setStateAndCity(testData.state, testData.city)
                .clickSubmitButton()
                .checkModalWindow();

        Thread.sleep(5000);

        registrationPage
                .checkResults("Student Name", testData.firstName + " " + testData.lastName)
                .checkResults("Student Email", testData.email)
                .checkResults("Gender",testData.gender)
                .checkResults("Mobile",testData.phoneNumber)
                .checkResults("Date of Birth",testData.addLeadingZero(testData.DateOfBirth) + " " + testData.month + "," + testData.year)
                .checkResults("Subjects", testData.trimArray(testData.subjects))
                .checkResults("Hobbies",testData.trimArray(testData.randomHobbies))
                .checkResults("Picture",testData.picturePath)
                .checkResults("Address",testData.currentAddress)
                .checkResults("State and City",testData.state + " " + testData.city);
    }

    @Test
    @DisplayName("Проверка успешной регистрации с минимальными данными")
    void minRequiredFieldsRegistrationTest() {
        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setPhoneNumber(testData.phoneNumber)
                .clickSubmitButton()
                .checkModalWindow();

        registrationPage
                .checkResults("Student Name", testData.firstName + " " + testData.lastName)
                .checkResults("Gender",testData.gender)
                .checkResults("Mobile",testData.phoneNumber);
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
