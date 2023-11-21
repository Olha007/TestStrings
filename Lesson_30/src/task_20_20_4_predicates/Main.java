package task_20_20_4_predicates;

/**
 * Додайте пакет predicates.
 * Додайте до пакету клас Main з методом main, у якому, використовуючи єдиний ланцюжок предикатів, визначте, чи є п’ятибуквене слово, яке вводиться з консолі, паліндромом (паліндром – це слово, яке пишеться однаково і вперед, і назад, наприклад, “kayak” – паліндром, тоді як “apple” - ні.
 * Продемонструйте роботу програми на двох словах, одне з яких паліндром.
 * <p>
 * * * @version 1.0
 * * * @author Olha Nozdriukhina
 */

import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a five-letter word:");
        String word = scanner.nextLine();

        boolean isPalindrome = isPalindrome(word);

        if (isPalindrome) {
            System.out.println(word + " - True");
        } else {
            System.out.println(word + " - False");
        }

        scanner.close();
    }

    // перевірка чи є слово паліндромом
    private static boolean isPalindrome(String word) {
        return isLengthFive().and(isMirrorImage()).test(word);
    }

    // Перевірка чи слово має довжину 5
    private static Predicate<String> isLengthFive() {
        return word -> word.length() == 5;
    }

    // Перевірка чи слово є дзеркальним
    private static Predicate<String> isMirrorImage() {
        return word -> {
            StringBuilder reversed = new StringBuilder(word).reverse();
            return word.equals(reversed.toString());
        };

    }
}