package task_2_16_2;

/**
 1. Створіть клас OverloadedMethTest з методами void foo(int i), який виводить «int» на консоль, і void foo(Byte b), який виводить «Byte».
 2. Додайте методи void foo(int a, int b), який виводить a і b на консоль, і void foo(int ... a), який друкує вміст масиву.
 3. Створіть клас Main з методом main(), у коді якого створіть об'єкт класу OverloadedMethTest.
 4. Оголосіть у методі main() змінну байт b і організуйте виклик методу foo(), що приймає цю змінну як параметр.
 5. У методі main() викличте двічі метод foo(), спочатку передайте йому 3 цілочисельних аршументи, а потім - 2 цілочисельних аргументи. Запустіть програму.
 6. Поясніть коментарями, як був обраний перевантажений метод у кожному з випадків.
 7. Зазначте у документованому коментарі класів номер завдання, своє ім'я та прізвище.
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

class OverloadedMethTest {
    // Перевантажений метод для int
    void foo(int i) {
        System.out.println("int");
    }

    // Перевантажений метод для Byte
    void foo(byte b) {
        System.out.println("byte");
    }

    // Перевантажений метод для двох int аргументів
    void foo(int a, int b) {
        System.out.println("Two ints: " + a + ", " + b);
    }

    // Перевантажений метод для набору int аргументів
    void foo(int... a) {
        System.out.print("Varargs: ");
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        OverloadedMethTest obj = new OverloadedMethTest();

        int i = 1;
        obj.foo(i);

        //Виклик foo з параметром типу byte
        byte b = 5;
        obj.foo(b);

        //Виклик foo з 3 цілочисельними аргументами
        obj.foo(1, 2, 3);

        //Виклик foo з 2 цілочисельними аргументами
        obj.foo(4, 5);
    }
}
