package com.demoqa.tests;

import org.junit.jupiter.api.Test;
import com.demoqa.pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
    textBoxPage
            .openpage()
            .removeBanners()
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
