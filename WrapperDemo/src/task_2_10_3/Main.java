package task_2_10_3;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * 1. Створіть клас Main з методом main, у якому оголосіть змінну рядок зі значенням: "Середньорічний курс євро до долара
 * США становив: у 2015 р - 1.11, у 2016 р - 1.11, у 2017 р - 1.13, у 2018 р - 1.18, у 2019 р - 1.12, у 2020 р - 1.14,
 * у 2021 р - 1.18, у 2022 р - 1.05".
 * 2. За допомогою екземпляра Scanner проскануйте цей рядок та додайте проскановані дані до об'єктів класу Rate з полями
 * int year та double rate, які занесіть до масиву таких об'єктів.
 * 3. Виведіть елементи масиву на консоль.
 * *
 * * @version 1.0
 * * @autor Olha Nozdriukhina
 */

public class Main {
    public static void main(String[] args) {
        String rateString = "Середньорічний курс євро до долара США становив: у 2015 р - 1.11, у 2016 р - 1.11, " +
                "у 2017 р - 1.13, у 2018 р - 1.18, у 2019 р - 1.12, у 2020 р - 1.14, у 2021 р - 1.18, у 2022 р - 1.05";

        Scanner scanner = new Scanner(rateString);

        Rate[] rates = new Rate[8];

        for (int i = 0; i < 8; i++) {
            scanner.findInLine("у (\\d{4}) р - (\\d+\\.\\d+)");
            MatchResult match = scanner.match();

            int year = Integer.parseInt((match).group(1));
            double rateValue = Double.parseDouble(match.group(2));

            rates[i] = new Rate(year, rateValue);
        }
        scanner.close();

        for (Rate rate : rates) {
            System.out.println("Рік: " + rate.year + ", Курс: " + rate.rate);
        }
    }

}