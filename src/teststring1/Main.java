package teststring1;

/**
 * 1. Створіть новий проект під назвою TestStrings. Додайте пакет teststring1.
 * 2. Створіть клас Main з методом main, у якому оголосіть локальну змінну myStr типу String та присвойте їй значення:
 * "abracadabra".
 * 3. Використовуючи методи класу String, виконайте наступне:
 * - знайдіть індекс першого підрядка "ra" значення myStr і виведіть результат на консоль;
 * - знайдіть індекс останнього підрядка "ra" значення myStr і виведіть результат на консоль;
 * — отримайте підрядок myStr від 3 до 7 символів індексу та виведіть результат на консоль;
 * 4. До класу Main додайте статичний метод reverseString(String), який повертає як результат значення рядка-параметра
 * із зміненим на зворотній порядком літер (наприклад, "abcd" -> "dcba").
 * 5. У методі main викличте метод reverseString з аргументом myStr і виведіть результат на консоль.
 * *
 * * @version 1.0
 * * @autor Olha Nozdriukhina
 */

public class Main {
    public static void main(String[] args) {

        String myStr = "abracadabra";
        String index = ("ra");

        int firstIndex = myStr.indexOf(index);
        System.out.println("Індекс першого входження: " + firstIndex);

        int lastIndex = myStr.lastIndexOf(index);
        System.out.println("Індекс останнього входження: " + lastIndex);

        System.out.println(myStr.substring(3, 8));

        String reversedStr = reverseString(myStr);
        System.out.println("Перевернутий рядок: " + reversedStr);

    }

    public static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder(input).reverse();
        return reversed.toString();
    }
}
