package task_2_20_1_funcinterfaces.listmanipulator;

/**
 * 1. Додайте пакет funcinterfaces.listmanipulator
 * 2. Створіть у цьому пакеті узагальнений функціональний інтерфейс ListManipulator<T> з функціональним методом
 * manipulate, який приймає List<T> і T як аргументи і нічого не повертає.
 * 3. Додайте до інтефрейсу ListManipulator<T> default-метод create, який створює ArrayList з трьома довільними
 * рядками. Цей метод не бере аргументів і повертає List<T>.
 * 4. Додайте клас Main з методом main, у якому напишіть три реалізації ListManipulator:
 * sListAdd, яка реалізує ListManipulator<String> і функціональний метод якої додає рядок у кінець списку;
 * iListAdd, яка реалізує ListManipulator<Integer> і функціональний метод якої додає ціле число у кінець списку;
 * iListRmv, яка реалізує ListManipulator<Integer> і функціональний метод якої видаляє перше входження цілого числа
 * зі списку.
 * 5. Реалізації iListAdd та iListRmv повинні перевизначати default-метод функціонального інтерфейсу реалізацією, яка
 * встановлює початкову місткість ArrayList у 50 елементів та додає до списку три довільних числа.
 * 6. Продемонструйте роботу усіх реалізацій функціонального інтерфейсу на довільних вхідних параметрах із виведенням
 * результату у консоль.
 * <p>
 * * * @version 1.0
 * * * @author Olha Nozdriukhina
 */

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface ListManipulator<T> {
    void manipulate(List<T> list, T element);

    // Дефолтний метод для створення списку
    default List<T> create() {
        return new ArrayList<>();
    }
}

class Main {
    public static void main(String[] args) {
        // Реалізація для рядків
        ListManipulator<String> sListAdd = (list, element) -> list.add(element);

        // Реалізація для цілих чисел (додавання)
        ListManipulator<Integer> iListAdd = new ListManipulator<>() {
            @Override
            public void manipulate(List<Integer> list, Integer element) {
                list.add(element);
            }

            @Override
            public List<Integer> create() {
                ArrayList<Integer> list = new ArrayList<>(50);
                list.add(1);
                list.add(2);
                list.add(3);
                return list;
            }
        };

        // Реалізація для цілих чисел (видалення)
        ListManipulator<Integer> iListRmv = new ListManipulator<>() {
            @Override
            public void manipulate(List<Integer> list, Integer element) {
                list.remove(element);
            }

            @Override
            public List<Integer> create() {
                ArrayList<Integer> list = new ArrayList<>(50);
                list.add(4);
                list.add(5);
                list.add(6);
                return list;
            }
        };

        List<String> stringList = sListAdd.create();
        sListAdd.manipulate(stringList, "Hello");
        sListAdd.manipulate(stringList, "World");
        System.out.println(stringList);

        List<Integer> integerList = iListAdd.create();
        iListAdd.manipulate(integerList, 10);
        System.out.println(integerList);

        integerList = iListRmv.create();
        iListRmv.manipulate(integerList, 5);
        System.out.println(integerList);
    }
}
