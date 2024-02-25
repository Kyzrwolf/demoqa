package com.demoqa.tests;

import com.demoqa.config.TestDataConfig;
import com.demoqa.utils.RandomUtils;
import org.aeonbits.owner.ConfigFactory;

import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestData {
    private static final RandomUtils random = new RandomUtils();
    TestDataConfig config = ConfigFactory.create(TestDataConfig.class);

    String firstName = config.firstName();
    String lastName = config.lastName();
    String email = config.email();
    String[] genders = {"Male", "Female", "Other"};
    String gender = random.getRandomGender(genders);
    String phoneNumber = random.getRandomPhone();
    String year = String.valueOf(random.getRandomDate().getYear());
    String month = capitalizedMonth(random.getRandomDate().getMonth());
    String DateOfBirth = String.valueOf(random.getRandomDate().getDayOfMonth());
    String[] subjects = {"Accounting", "Arts", "Social Studies", "History"};
    String subject = random.getRandomSubject(subjects);
    String[] hobbies = {"Sports", "Reading", "Music"};
    String[] randomHobbies = sortStringArray(random.getRandomHobbies(hobbies));
    String currentAddress = random.getRandomAddress();
    String picturePath = random.getRandomPicture();

    public Map<String, List<String>> stateCityData() {
        Map<String,List<String>> stateCityMap = new HashMap<>();
        stateCityMap.put("NCR", Arrays.asList("Delhi", "Gurgaon", "Noida"));
        stateCityMap.put("Rajasthan", Arrays.asList("Jaipur", "Jaiselmer"));
        stateCityMap.put("Uttar Pradesh", Arrays.asList("Agra","Lucknow","Merrut"));
        return stateCityMap;
    }
    String state = random.getRandomState(stateCityData());
    String city = random.getRandomCity(stateCityData(),state);

    private String capitalizedMonth(Month month) {
        return month.name().charAt(0) + month.name().substring(1).toLowerCase();
    }

    public String addLeadingZeroes (String number) {
        // 7 = 007; 27 = 027
        int leadingZeroCount = 3 - number.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < leadingZeroCount; i++) {
            result.append('0');
        }
        result.append(number);
        return result.toString();
    }

    public String addLeadingZero(String number) {
        // добавляет 0 для единичного разряда
        if(number.length() < 2) {
            number = 0 + number;
        }
        return number;
    }

    public String[] sortStringArray(String[] array) {
        Arrays.sort(array);
        return array;
    }

    public String trimArray(String[] array) {
        String arrayString = Arrays.toString(array);
        return arrayString.substring(1, arrayString.length() - 1);
    }
}