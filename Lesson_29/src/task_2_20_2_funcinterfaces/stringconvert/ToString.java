package task_2_20_2_funcinterfaces.stringconvert;

/**
 * . Додайте пакет funcinterfaces.stringconvert.
 * 2. Створіть узагальнений функціональний інтерфейс з назвою ToString<T> з функціональним методом convert, який
 * конвертує T у String.
 * 3. Додайте клас Main з методом main, у якому напишіть дві реалізації інтерфейсу ToString<T>:
 * l2s - яка перетворює List<String> у рядок елементів-рядків, розділених комами;
 * m2s - яка перетворює Map<String, Integer>, у рядок елементів ключ-значення, розділених комами, між ключем і
 * значенням повинна бути двокрапка.
 * 4. Продемонструйте роботу усіх реалізацій функціонального інтерфейсу на довільних вхідних параметрах із
 * виведенням результату у консоль.
 * <p>
 * * * @version 1.0
 * * * @author Olha Nozdriukhina
 */

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@FunctionalInterface
interface ToString<T> {
    String convert(T object);
}

class Main {
    public static void main(String[] args) {
        ToString<List<String>> l2s = list -> String.join(", ", list);

        ToString<Map<String, Integer>> m2s = map -> map.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.joining(", "));

        List<String> stringList = List.of("Apple", "Banana", "Cherry");
        System.out.println("List to String: " + l2s.convert(stringList));

        Map<String, Integer> map = Map.of("Anna", 10, "Victor", 20, "Anton", 30);
        System.out.println("Map to String: " + m2s.convert(map));
    }
}
