package com.demoqa.utils;

import com.github.javafaker.Faker;
import com.demoqa.tests.SchoolSubjects;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    Faker faker = new Faker();

    public String getRandomFirstName() {
        return faker.name().firstName();
    }

    public String getRandomLastName() {
        return faker.name().lastName();
    }

    public String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min,max + 1);
    }

    public String getRandomGender(String[] genders) {
                int index = getRandomInt(0, genders.length - 1);
                return  genders[index];
    }

    public String getRandomPhone() {
        return String.format("7%s%s%s%s",
                getRandomInt(900,999),getRandomInt(10,99),getRandomInt(10,99),getRandomInt(10,99));
    }

    public LocalDate getRandomDate() {
        int month = getRandomInt(1,12);
        int year = getRandomInt(1900,2022);
        int dayOfMonth = getRandomInt(1, Month.of(month).maxLength());
        return LocalDate.of(year, month, dayOfMonth);
    }


    public String[] getRandomSubject() {
        SchoolSubjects[] allSubjects = SchoolSubjects.values();
        int numberOfSubjects = getRandomInt(1, allSubjects.length - 1);
        // Создаем список для хранения уникальных предметов
        List<String> uniqueSubjectsList = new ArrayList<>();

        while (uniqueSubjectsList.size() < numberOfSubjects) {
            int randomIndex = getRandomInt(0,allSubjects.length - 1);
            String randomSubject = allSubjects[randomIndex].toString();

            if (!uniqueSubjectsList.contains(randomSubject)) {
                uniqueSubjectsList.add(randomSubject);
            }
        }
        return uniqueSubjectsList.toArray(new String[0]);
    }

    public String getRandomAddress() {
       return faker.address().fullAddress();
    }

    public String getRandomPicture() {
        File resourcesDir = new File("src/test/resources");
        File[] files = resourcesDir.listFiles();
        if (files == null || files.length == 0) {
            throw new RuntimeException("В директории resources нет файлов");
        }
        File randomPicture = files[getRandomInt(0,files.length - 1)];
        return randomPicture.getName();
    }

    public String[] getRandomHobbies(String[] hobbies) {
        List<String> uniqueHobbiesList = new ArrayList<>(Arrays.asList(hobbies));
        Collections.shuffle(uniqueHobbiesList);

        int randomCount = getRandomInt(1, hobbies.length);
        return uniqueHobbiesList.subList(0, randomCount).toArray(new String[0]);
    }

    public String getRandomState(Map<String, List<String>> stateCityMap) {
        List<String> states = new ArrayList<>(stateCityMap.keySet());
        return states.get(getRandomInt(0,states.size() - 1));
    }

    public String getRandomCity(Map<String, List<String>> stateCityMap,String state) {
        List<String> cities = stateCityMap.get(state);
        if (cities != null && !cities.isEmpty()) {
            return cities.get(getRandomInt(0,cities.size() - 1));
        } else {
            return null;
        }
    }
}
