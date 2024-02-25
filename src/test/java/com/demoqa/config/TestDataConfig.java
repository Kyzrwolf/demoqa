package com.demoqa.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${stand}/${block}.properties"
                })
public interface TestDataConfig extends Config {

    @Key("test.data.first.name")
    String firstName();

    @Key("test.data.last.name")
    String lastName();

    @Key("test.data.email")
    String email();
}
