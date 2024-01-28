package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ModalWindowComponent;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@SuppressWarnings("FieldMayBeFinal")
public class RegistrationPage {

    private ModalWindowComponent resultTable = new ModalWindowComponent();

    private SelenideElement
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
            modalWindow = $(".modal-dialog");

public RegistrationPage openPage() {
    open("/automation-practice-form");
    $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    executeJavaScript("$('footer').remove()");
    executeJavaScript("$('#fixedban').remove()");
    return this;
}

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String phoneNumber) {
        numberInput.setValue(phoneNumber);
        return this;
    }


    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        new CalendarComponent().setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String... subjects) {
        Arrays.asList(subjects).forEach(subject -> subjectInput.setValue(subject).pressEnter());
        return this;
    }

    public RegistrationPage setHobbies(String... hobbies) {
        Arrays.asList(hobbies).forEach(hobbie -> hobbiesCheckBoxes.$(byText(hobbie)).click());
        return this;
    }

    public RegistrationPage uploadPicture(String filename) {
        uploadPictureButton.uploadFromClasspath(filename);
        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress){
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateCityWrapper.$("#state").click();
        stateCityWrapper.$("#state").$(byText(state)) .click();

        stateCityWrapper .$("#city").click();
        stateCityWrapper.$("#city") .$(byText(city)).click();
        return this;
    }

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
}

