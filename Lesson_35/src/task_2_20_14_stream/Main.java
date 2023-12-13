package task_2_20_14_stream;

/**
 * 1. До пакету streams, який Ви створили у попередніх завданнях, додайте клас Main з методом main, у якому
 * створіть список символів '1', 'a', '5', 'v'.
 * 2. Отримайте стрім з цього списку та зберіть елементи стріму до Map, ключами якого є самі символи, а
 * значеннями — значення коду кожного символу.
 * 3. Виведіть записи Map на консоль.
 * <p>
 *
 * @version 1.0
 * @author Olha Nozdriukhina
 */


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Character> characters = Arrays.asList('1', 'a', '5', 'v');
        Map<Character, Integer> charMap = characters.stream()
                .collect(Collectors.toMap(
                        // Ключ: сам символ
                        character -> character,
                        // Значення: код символу
                        character -> (int) character
                ));

        charMap.forEach((key, value) -> System.out.println(("Key: " + key + ", Value: " + value)));
    }
}
