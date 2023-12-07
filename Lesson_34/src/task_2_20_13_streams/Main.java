package task_2_20_13_streams;

/**
 * 1. Додайте пакет streams.
 * 2. Додайте до пакету клас Main з методом main, у якому створіть стрім, що містить числа від 1 до 5.
 * 3. Додайте 4 до кожного елемента в потоці.
 * 4. Створіть редукцію, яка додає елементи в потоці, що містять непарні значення, і подвоює значення елементів у
 * потоці, що містять парні значення.
 * 5. Виведіть результуючі значння елементів стріма до консолі.
 * <p>
 * * * @version 1.0
 * * * @author Olha Nozdriukhina
 */

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream stream = IntStream.range(1, 6);
        IntStream modifiedStream = stream.map(n -> n + 4);

        //Редукція
        int result = modifiedStream.reduce(0, (acc, n) -> {
            if (n % 2 == 0) {
                //подвоєння для парних значень
                return acc + (n * 2);
            } else {
                //додавання для непарних значень
                return acc + n;
            }
        });

        System.out.println("Результат редукції: " + result);
    }
}


