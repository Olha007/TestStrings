package teststring3;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. До проекту TestStrings додайте пакет teststring3.
 * 2. Створіть клас Main, в ньому створіть статичний метод uniqueChars, який має приймати рядок як аргумент і
 * повертати масив унікальних символів аргумента-рядка.
 * 3. Створіть метод main та додайте до нього виклик методу uniqueChars і передайте йому рядок "Використання
 * методів класу String" як аргумент. Виведіть результат роботи методу на екран.
 * 4. Зазначте у документованому коментарі класу та методу їх призначення, у документованому коментарі класу -
 * номер завдання, а також своє ім'я та прізвище.
 * 5. Надішліть викладачеві лістинги коду програм та результат їх роботи.
 * <p>
 * * @version 1.0
 * * @autor Olha Nozdriukhina
 */

public class Main {
    public static void main(String[] args) {

        String s = "Використання методів класу String";
        char[] result = uniqueChars1(s);

        for (char c : result) {
            if (c != 0) {
                System.out.print(c);
            }
        }
    }

    public static char[] uniqueChars1(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string should not be null");
        }

        List<Character> uniqueCharList = new ArrayList<>();

        for (char c : input.toCharArray()) {
            if (!uniqueCharList.contains(c)) {
                uniqueCharList.add(c);
            }
        }

        char[] uniqueCharsArray = new char[uniqueCharList.size()];
        for (int i = 0; i < uniqueCharList.size(); i++) {
            uniqueCharsArray[i] = uniqueCharList.get(i);
        }

        return uniqueCharsArray;
    }
}