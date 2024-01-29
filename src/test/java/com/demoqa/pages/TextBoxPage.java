package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.OutputFormComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    OutputFormComponent outputForm = new OutputFormComponent();

    private SelenideElement
                    fullNameInput = $("#userName"),
                    emailInput = $("#userEmail"),
                    currentAddressInput = $("#currentAddress"),
                    permanentAddressInput = $("#permanentAddress"),
                    submitButton = $("#submit"),
                    outputAreaSelector = $("#output");

    public TextBoxPage openpage() {
        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));
        return this;
    }

    public TextBoxPage setFullName(String fullName) {
        fullNameInput.setValue(fullName);
        return this;
    }

    public TextBoxPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress) {
        permanentAddressInput.setValue(permanentAddress);
        return this;
    }

    public TextBoxPage pressSubmitButton() {
        submitButton.click();
        return this;
    }

    public void checkOutput() {
        outputAreaSelector.shouldBe(visible);
    }

   public TextBoxPage checkResults(String key, String value) {
        outputForm.checkField(key, value);
        return this;
   }

   public TextBoxPage removeBanners() {
       executeJavaScript("$('footer').remove()");
       executeJavaScript("$('#fixedban').remove()");
       return this;
   }
}
