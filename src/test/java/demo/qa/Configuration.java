package demo.qa;

import org.junit.jupiter.api.BeforeAll;

public class Configuration {

    @BeforeAll
    static void configuration() {

        com.codeborne.selenide.Configuration.browserSize = "1920x1080";
        com.codeborne.selenide.Configuration.baseUrl = "https://demoqa.com";
        com.codeborne.selenide.Configuration.pageLoadStrategy = "eager";
        com.codeborne.selenide.Configuration.holdBrowserOpen = true;
        com.codeborne.selenide.Configuration.timeout = 5000; // default 4000

    }
}
