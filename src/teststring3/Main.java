package teststring3;

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

    public static char[] uniqueChars(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (result.indexOf(String.valueOf(c)) == -1) {
                result.append(c);
            }
        }

        return result.toString().toCharArray();
    }

    public static void main(String[] args) {
        String input = "Використання методів класу String";
        char[] uniqueCharsArray = uniqueChars(input);

        System.out.println("Унікальні символи рядка: ");
        for (char c : uniqueCharsArray) {
            System.out.print(c + " ");
        }
    }
}






