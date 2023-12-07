package task_2_20_12streams;

/**
 * 1. Додайте пакет streams.
 * 2. До пакету streams додайте клас Main з методом main, у якому створіть стрім для рядків “Robert”, “Cheryl”, “Rachel” “Jose”, та “Rita”.
 * 3. Видаліть усі імена, які не починаються з літери R.
 * 4. Відсортуйте решту елементів у зворотному порядку.
 * 5. Виведіть результуючі елементи стріма на консоль.
 * 6. Зазначте у документованому коментарі класів номер завдання, своє ім'я та прізвище.
 * <p>
 * * * @version 1.1
 * * * @author Olha Nozdriukhina
 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//public class Main {
//    public static void main(String[] args) {
//
//        List<String> names = Arrays.asList("Robert", "Cheryl", "Rachel", "Jose", "Rita");
//
//        List<String> filteredStrings = names.stream()
//                .filter(name -> name.startsWith("R"))
//                .collect(Collectors.toList());
//        System.out.println("Names that start with a letter R: " + filteredStrings);
//
//        Collections.reverse(filteredStrings);
//        System.out.println("Reverse names in list: " + filteredStrings);
//    }
//}

public class Main {
    public static void main(String[] args) {

        Stream.of("Robert", "Cheryl", "Rachel", "Jose", "Rita")
                .filter(name -> name.startsWith("R"))
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}
