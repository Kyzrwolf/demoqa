package demo.qa;


import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends Configuration {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
    textBoxPage
            .openpage()
            .setFullName("Marcus Aurelius")
            .setEmail("Dictator@gmail.com")
            .setCurrentAddress("Rome, Via del Corso, 20")
            .setPermanentAddress("Syracuse Fonte Aretusa 55")
            .pressSubmitButton()
            .checkOutput();

    textBoxPage
            .checkResults("name","Marcus Aurelius")
            .checkResults("email","Dictator@gmail.com")
            .checkResults("currentAddress", "Rome, Via del Corso, 20")
            .checkResults("permanentAddress","Syracuse Fonte Aretusa 55");
    }
}
