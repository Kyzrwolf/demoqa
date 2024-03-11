package com.demoqa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:properties",
        "classpath:config/driver.properties"
})
public interface DriverConfig extends Config {

    @Key("local.mode")
    @DefaultValue("false")
    boolean localMode();

    @Key("browser.name")
    @DefaultValue("chrome")
    String browserName();

    @Key("browser.version")
    String browserVersion();

    @Key("browser.size")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browser.remote.url")
    String browserRemoteUrl();
}

