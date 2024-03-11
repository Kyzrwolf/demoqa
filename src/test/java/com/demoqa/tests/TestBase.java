package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.config.DriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static java.lang.String.format;

public class TestBase {
    @BeforeAll
    static void configuration() {
        DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

        if (!driverConfig.localMode()) {
            Configuration.remote = System.getProperty("browserRemoteUrl", driverConfig.browserRemoteUrl());
        } else {
            System.out.println("Запуск тестов локально");
        }

        System.setProperty("stand", System.getProperty("stand", "stage"));
        System.setProperty("block", System.getProperty("block", "b1"));
        String stand = System.getProperty("stand", "stage");
        String block = System.getProperty("block", "b1");
        System.out.println(format("Running tests on:\n stand: %s\n block: %s\n", stand, block));

        Configuration.browser = System.getProperty("browser", driverConfig.browserName());
        Configuration.browserVersion = System.getProperty("browserVersion", driverConfig.browserVersion());
        Configuration.browserSize = System.getProperty("browserSize", driverConfig.browserSize());
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "normal";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000; // default 4000

        String browser = System.getenv("browser");
        String browserVersion = System.getenv("browserVersion");
        String browserSize = System.getenv("browserSize");
        System.out.println(format(
                "Browser: %s\n" +
                "browserSize: %s\n" +
                "browserVersion: %s\n",browser,browserSize,browserVersion));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}

