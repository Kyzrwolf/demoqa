package com.demoqa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:properties",
        "classpath:config/driver.properties"
})
public interface DriverConfig extends Config {

    @Key("browser.name")
    @DefaultValue("firefox")
    String browserName();

    @Key("browser.version")
    @DefaultValue("null")
    String browserVersion();

    @Key("browser.size")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browser.remote.url")
    @DefaultValue("null")
    String browserRemoteUrl();
}

