package com.demoqa.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/local.properties")
public interface LocalConfig extends Config{

    @Config.Key("local.mode")
    @Config.DefaultValue("false")
    boolean localMode();
}
