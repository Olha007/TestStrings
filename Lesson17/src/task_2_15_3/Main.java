package task_2_15_3;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

/**
 * 1. Додайте до пакету testcollections клас Main з методом main().
 * 2. Додайте до методу main() класу Main код, що оголошує змінну lnkdList (типу List) рядкових об’єктів, яка вказує
 * на колекцію LinkedList<String>.
 * 3. Додайте до методу main() класу Main код, що заповнює цей список у циклі рядковими значеннями "number_i", де i -
 * номер поточної ітерації (від 0 до 10) за випадковими індексами (від 0 до номера поточної ітерації).
 * 4. Додайте до методу main() класу Main код, який за допомогою ітератора виводить значення елементів на консоль.
 * 5. Виконайте програму.
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class Main {
    public static void main(String[] args) {
        // Оголошення списку LinkedList
        List<String> linkdList = new LinkedList<>();

        // Заповнення списку рядковими значеннями
        for (int i = 0; i <= 10; i++) {
            int randomIndex = (int) (Math.random() * (i + 1));
            linkdList.add(randomIndex, "number_" + i);
        }

        // Виведення значень елементів за допомогою ітератора
        Iterator<String> iterator = linkdList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

