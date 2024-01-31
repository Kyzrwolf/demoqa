package com.demoqa.tests;

import com.demoqa.utils.RandomUtils;

import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestData {
    private static final RandomUtils random = new RandomUtils();

    static String firstName = random.getRandomFirstName();
    static String lastName = random.getRandomLastName();
    static String email = random.getRandomEmail();
    static String[] genders = {"Male", "Female", "Other"};
    static String gender = random.getRandomGender(genders);
    static String phoneNumber = random.getRandomPhone();
    static String year = String.valueOf(random.getRandomDate().getYear());
    static String month = capitalizedMonth(random.getRandomDate().getMonth());
    static String DateOfBirth = String.valueOf(random.getRandomDate().getDayOfMonth());
    static String[] subjects = random.getRandomSubject();
    static String[] hobbies = {"Sports", "Reading", "Music"};
    static String[] randomHobbies = sortStringArray(random.getRandomHobbies(hobbies));
    static String currentAddress = random.getRandomAddress();
    static String picturePath = random.getRandomPicture();

    public static Map<String, List<String>> stateCityData() {
        Map<String,List<String>> stateCityMap = new HashMap<>();
        stateCityMap.put("NCR", Arrays.asList("Delhi", "Gurgaon", "Noida"));
        stateCityMap.put("Rajasthan", Arrays.asList("Jaipur", "Jaiselmer"));
        stateCityMap.put("Uttar Pradesh", Arrays.asList("Agra","Lucknow","Merrut"));
        return stateCityMap;
    }
    static String state = random.getRandomState(stateCityData());
    static String city = random.getRandomCity(stateCityData(),state);

    private static String capitalizedMonth(Month month) {
        return month.name().charAt(0) + month.name().substring(1).toLowerCase();
    }

    public static String addLeadingZeroes (String number) {
        // 7 = 007; 27 = 027
        int leadingZeroCount = 3 - number.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < leadingZeroCount; i++) {
            result.append('0');
        }
        result.append(number);
        return result.toString();
    }

    public static String addLeadingZero(String number) {
        // добавляет 0 для единичного разряда
        if(number.length() < 2) {
            number = 0 + number;
        }
        return number;
    }

    public static String[] sortStringArray(String[] array) {
        Arrays.sort(array);
        return array;
    }

    public static String trimArray(String[] array) {
        String arrayString = Arrays.toString(array);
        return arrayString.substring(1, arrayString.length() - 1);
    }
}