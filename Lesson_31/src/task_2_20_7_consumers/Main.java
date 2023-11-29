package task_2_20_7_consumers;

/**
 * 1. Додайте пакет consumers.
 * 2. Додайте до пакету клас Main з методом main, у якому створіть програму, що за допомогою Consumer виводить на
 * консоль розділений комами список перших слів кожного значення записів словника Map<String, String> dictionary для
 * ключів, довжина яких дорівнює 5 символів.
 * Map<String, String> dictionary = Map.of("quest", "Be or not to be?",
 * "answer", "It's Only Love",
 * "route", "But there is no end of the road");
 * 3. Використовуйте клас java.util.StringJoiner для об'єднання відібраних значень у рядок через кому.
 * 4. Використовуйте предикат для перевірки довжини ключа записів.
 * 5. Використовуйте посилання на методи замість лямбда виразів, якщо це доцільно.
 * 6. Перевірте роботу програми.
 *
 * * * @version 1.0
 * * * @author Olha Nozdriukhina
 */

import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = Map.of(
                "quest", "Be or not to be?",
                "answer", "It's Only Love",
                "route", "But there is no end of the road"
        );

        Predicate<String> isKeyLengthFive = key -> key.length() == 5;

        StringJoiner joiner = new StringJoiner(", "); //рядок з результатами

        Consumer<Map.Entry<String, String>> processEntry = entry -> {
            if (isKeyLengthFive.test(entry.getKey())) {
                String firstWord = entry.getValue().split(" ")[0];
                joiner.add(firstWord);
            }
        };

        dictionary.entrySet().forEach(processEntry);

        System.out.println(joiner);
    }
}
