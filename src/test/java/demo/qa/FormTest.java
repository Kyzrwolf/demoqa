package demo.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class FormTest extends Configuration {

    @Test
    void registrationFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue("Vasiliy");
        $("#lastName").setValue("Pupkin");
        $("#userEmail").setValue("VasiliyPupkin@mail.ru");
        $(("label[for=gender-radio-1]")).click();
        $("#userNumber").setValue("7912345678");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1984");
        $(".react-datepicker__day--022").click();
        $("#subjectsInput").setValue("s").pressEnter().setValue("m").pressEnter();
        $("label[for=hobbies-checkbox-1]").click();
        $("label[for=hobbies-checkbox-2]").click();
        $("label[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFromClasspath("1606135682168725538.jpg");
        $("#currentAddress").setValue("Lenina street 54");
        $("#react-select-3-input").setValue("Raja").pressEnter();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();

        $("#submit").pressEnter();

        $(".modal-open").shouldBe(visible);
        $(".table").shouldHave(text("Vasiliy Pupkin"));
        $(".table").shouldHave(text("VasiliyPupkin@mail.ru"));
        $(".table").shouldHave(text("7912345678"));
        $(".table").shouldHave(text("22 September,1984"));
        $(".table").shouldHave(text("English, Maths"));
        $(".table").shouldHave(text("Sports, Reading, Music"));
        $(".table").shouldHave(text("1606135682168725538.jpg"));
        $(".table").shouldHave(text("Lenina street 54"));
        $(".table").shouldHave(text("Rajasthan Jaipur"));
    }
}
