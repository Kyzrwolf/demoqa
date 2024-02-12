package com.demoqa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import com.demoqa.pages.RegistrationPage;


public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    @Feature("Registration")
    @Story("Registration page")
    @Owner("Seningv")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("Smoke")
    @DisplayName("Проверка успешной регистрации студента")
    void successfulRegistrationTest() throws InterruptedException {
        SelenideLogger.addListener("allure", new AllureSelenide());

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
        registrationPage.addPageSource();

        Thread.sleep(5000);

        registrationPage
                .checkResults("Student Name", testData.firstName + " " + testData.lastName)
                .checkResults("Student Email", testData.email)
                .checkResults("Gender",testData.gender)
                .checkResults("Mobile",testData.phoneNumber)
                .checkResults("Date of Birth",testData.addLeadingZero(testData.DateOfBirth) + " " + testData.month + "," + testData.year)
                .checkResults("Subjects", testData.subject)
                .checkResults("Hobbies",testData.trimArray(testData.randomHobbies))
                .checkResults("Picture",testData.picturePath)
                .checkResults("Address",testData.currentAddress)
                .checkResults("State and City",testData.state + " " + testData.city);

        registrationPage.takeScreenshot();
        registrationPage.addPageSource();
    }

    @Test
    @Feature("Registration")
    @Story("Registration page")
    @Owner("Seningv")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Smoke")
    @DisplayName("Проверка успешной регистрации с минимальными данными")
    void minRequiredFieldsRegistrationTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setPhoneNumber(testData.phoneNumber)
                .clickSubmitButton()
                .checkModalWindow();

        registrationPage.addPageSource();

        registrationPage
                .checkResults("Student Name", testData.firstName + " " + testData.lastName)
                .checkResults("Gender",testData.gender)
                .checkResults("Mobile",testData.phoneNumber);

        registrationPage.takeScreenshot();
    }

    @Test
    @Feature("Registration")
    @Story("Registration page")
    @Owner("Seningv")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Smoke")
    @DisplayName("Проверка не успешной регистрации")
    void negativeRegistrationTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        registrationPage
                .openPage()
                .removeBanners()
                .setFirstName(String.valueOf(Faker.instance().funnyName()))
                .setLastName("")
                .setPhoneNumber("")
                .clickSubmitButton()
                .checkModalWindowNotVisible();

        registrationPage.addPageSource();
        registrationPage.takeScreenshot();
    }
}
