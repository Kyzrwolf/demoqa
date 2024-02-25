package com.demoqa.tests;

import com.demoqa.config.TestDataConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static java.lang.String.format;

public class OwnerTests extends TestBase {

    @Test
    @Tag("owner")
    void standTest() {
        TestDataConfig testDataConfig = ConfigFactory.create(TestDataConfig.class);
        String firstName = testDataConfig.firstName();
        String lastName = testDataConfig.lastName();
        String email = testDataConfig.email();
        System.out.printf("firstname: %s\n lastName: %s\n email: %s\n",firstName,lastName,email);
    }
}
