package testsregexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1. Створіть  у пакеті testsregexp клас Main1 з методом main у якому оголосіть рядок:
 * "The 5 most populated US states in 2023 are: CA: 38,915,693, TX: 30,500,280, FL: 22,661,577, NY: 19,496,810, PA: 12,931,957."
 * 2. За допомогою регулярного виразу з використанням груп виконайте аналіз рядка і розрахуйте значення проценту
 * населення кожного штату від загальної кількості населення США 339,996,563 станом на 2023 рік.
 * 3. Виведіть на екран абревіатуру назви і відповідний процент населення для кожного штату.
 * *
 * * @version 1.0
 * * @autor Olha Nozdriukhina
 */

public class Main1 {
    public static void main(String[] args) {

        String states = "The 5 most populated US states in 2023 are: CA: 38,915,693, TX: 30,500,280, " +
                "FL: 22,661,577, NY: 19,496,810, PA: 12,931,957";

        String pattern = "([A-Z]{2}): ([\\d,]+)";

        Pattern p = Pattern.compile(pattern);

        // Створення об'єкту для знаходження зібгів в рядку
        Matcher matcher = p.matcher(states);

        long totalPopulation = 339996563;

        while (matcher.find()) {
            // Отримання абревіатури штату
            String stateAbbreviation = matcher.group(1);
            // Отримання рядка з населенням та видалення ком з числа
            String populationStr = matcher.group(2).replace(",", "");
            long populations = Long.parseLong(populationStr);

            double percentage = ((double) populations / totalPopulation) * 100;

            System.out.println(stateAbbreviation + ":" + percentage);
        }
    }
}
