package testsregexp;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * 1. До проекту TestStrings додайте пакет testsregexp.
 * 2. Створіть клас Main, в ньому створіть статичний метод checkPersonWithRegExp, який приймає аргумент-рядок і повертає
 * булеве значення true, лише якщо перший символ рядка-аргументу зазначений у верхньому регістрі, а всі інші символи -
 * у нижньому регістрі і рядок містить лише літери.
 * 3. Створіть метод main та оголосіть у ньому масив рядків з такими значеннями: {"VOVA", "Ivan", "R2d2", "ZX",
 * "Anna", "12345", "ToAd", "TomCat", " "}
 * 4. Додайте код для перевірки кожного з цих значень за допомогою методу checkPersonWithRegExp і виведіть результат
 * на консоль.
 * *
 * * @version 1.0
 * * @autor Olha Nozdriukhina
 */

public class Main {
    public static void main(String[] args) {
        String[] names = {"VOVA", "Ivan", "R2d2", "ZX", "Anna", "12345", "ToAd", "TomCat", " " };

        for (String name : names) {
            boolean isValid = checkPersonWithRegExp(name);
            System.out.println(name + ": " + isValid);
        }
    }

    public static boolean checkPersonWithRegExp(String input) {
        // Використовуємо регулярний вираз для перевірки умови
        String regex = "^[A-Z][a-z]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
}
