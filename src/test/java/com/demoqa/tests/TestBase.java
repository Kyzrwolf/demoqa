package com.demoqa.tests;

import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void configuration() {

        com.codeborne.selenide.Configuration.browserSize = "1920x1080";
        com.codeborne.selenide.Configuration.baseUrl = "https://demoqa.com";
        com.codeborne.selenide.Configuration.pageLoadStrategy = "eager";
        com.codeborne.selenide.Configuration.holdBrowserOpen = false;
        com.codeborne.selenide.Configuration.timeout = 5000; // default 4000

    }
}
