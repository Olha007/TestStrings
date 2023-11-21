package task_2_20_5_functions;

/**
 * 1. Ддодайте пакет functions.
 * 2. Додайте до пакету клас Main з методом main, у якому за допомогою функції виконайте перетворення колекції Map із записами:
 * ключ - "dog", значення - "wolf descendant";
 * ключ - "cat", значення - "feline with nine lives";
 * ключ - "rat", значення - "rodent with long tail".
 * у колекцію Map, у якій для кожного запису ключ та значення змінені місцями.
 * 3. Перевірте роботу програми.
 * <p>
 * * * @version 1.0
 * * * @author Olha Nozdriukhina
 */

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, String> originalMap = new HashMap<>();
        originalMap.put(" dog", "wolf descendant ");
        originalMap.put(" cat", "feline with nine lives ");
        originalMap.put(" rat", "rodent with long tail ");

        //перетворення
        Map<String, String> transformedMap = transformMap(originalMap);
        System.out.println("Transformed Map: " + transformedMap);
    }

    private static Map<String, String> transformMap(Map<String, String> map) {
        Map<String, String> newMap = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            newMap.put(entry.getValue(), entry.getKey());
        }
        return newMap;
    }
}