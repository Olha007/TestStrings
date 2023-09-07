package task_2_15_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1. Додайте пакет testcollections.
 * 2. Створіть клас Main з методом main, який оголошує змінну list (типу List) рядкових об’єктів, яка вказує на колекцію ArrayList<String>.
 * 3. Напишіть код, щоб заповнити цей список у циклі рядковими значеннями "number_i", де i - номер поточної ітерації (від 0 до 10).
 * 4. Додайте код, який за допомогою ітератора виводить значення елементів на консоль.
 * 5. Виконайте програму.
 * Результат програми повинен бути таким, як у наступному прикладі:
 * number_0
 * number_1
 * number_2
 * …
 * number_10
 * 6. Додайте цикл, у якому видаліть елементи колекції з парними номерами.
 * 7. Виведіть значення елементів результуючої колекції на консоль.
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        // Заповнення списку рядковими значеннями "number_i", де i - номер поточної ітерації (від 0 до 10).
        for (int i = 0; i <= 10; i++) {
            String value = "number_" + i;
            list.add(value);
        }

        // Виведення значень елементів на консоль за допомогою ітератора.
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        // Цикл, в якому видаляються елементи колекції з парними номерами.
        iterator = list.iterator(); // Повторно ініціалізуємо ітератор
        int index = 0;
        while (iterator.hasNext()) {
            iterator.next();
            if (index % 2 == 0) {
                iterator.remove();
            }
            index++;
        }

        // Виведення значень елементів результуючої колекції (непарні) на консоль.
        for (String item : list) {
            System.out.println(item);
        }
    }
}

