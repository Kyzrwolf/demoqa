package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ModalWindowComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class RegistrationPage {

    private final ModalWindowComponent resultTable = new ModalWindowComponent();

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesCheckBoxes = $("#hobbiesWrapper"),
            uploadPictureButton = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submitButton = $("#submit"),
            modalWindow = $(".modal-dialog"),
            formWrapper = $(".practice-form-wrapper");

    @Step("Открыть страницу регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formWrapper.shouldHave(text("Student Registration Form"));
        new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.of(3000, ChronoUnit.SECONDS)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        $("#fixedban").shouldBe(visible);
        return this;
    }
    @Step("Установить имя {0}")
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }
    @Step("Установить фамилию {0}")
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    @Step("Установить email {0}")
    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }
    @Step("Установить пол {0}")
    public RegistrationPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }
    @Step("Установить номер {0}")
    public RegistrationPage setPhoneNumber(String phoneNumber) {
        numberInput.setValue(phoneNumber);
        return this;
    }

    @Step("Установить дату рождения {0}, {1}, {2}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        new CalendarComponent().setDate(day, month, year);
        return this;
    }
    @Step("Установить предметы {0}")
    public RegistrationPage setSubjects(String... subjects) {
        Arrays.asList(subjects).forEach(subject -> subjectInput.setValue(subject).pressEnter());
        return this;
    }
    @Step("Установить хобби {0}")
    public RegistrationPage setHobbies(String... hobbies) {
        Arrays.asList(hobbies).forEach(hobbie -> hobbiesCheckBoxes.$(byText(hobbie)).click());
        return this;
    }
    @Step("Загрузить фото {0}")
    public RegistrationPage uploadPicture(String filename) {
        uploadPictureButton.uploadFromClasspath("pictures/" + filename);
        return this;
    }
    @Step("Установить адрес {0}")
    public RegistrationPage setCurrentAddress(String currentAddress){
        currentAddressInput.setValue(currentAddress);
        return this;
    }
    @Step("Установить штат {0} и город {1} ")
    public RegistrationPage setStateAndCity(String state, String city) {
        stateCityWrapper.$("#state").click();
        stateCityWrapper.$("#state").$(byText(state)) .click();

        stateCityWrapper .$("#city").click();
        stateCityWrapper.$("#city") .$(byText(city)).click();
        return this;
    }
    @Step("Нажать кнопку submit")
    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public void checkModalWindow() {
    modalWindow.shouldBe(visible);
    }

    public void checkModalWindowNotVisible() {
        modalWindow.shouldNotBe(visible);
    }

    public RegistrationPage checkResults(String key, String value){
        resultTable.checkField(key, value);
        return this;
    }
    @Step("Удалить баннеры")
    public RegistrationPage removeBanners() {
        SelenideElement bannerRoot = $(".fc-consent-root");
        if (bannerRoot.is(visible)) {
            bannerRoot.$(byText("Consent")).click();
        }
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

}

