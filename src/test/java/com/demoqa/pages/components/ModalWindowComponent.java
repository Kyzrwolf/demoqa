package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindowComponent {

    private SelenideElement fieldSelector = $(".table-responsive");

    public void checkField (String key, String value) {
       fieldSelector.$(byText(value)).parent().shouldHave(text(key));
    }
}
