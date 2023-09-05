package task_2_13_1;

/**
 * 1. Створіть тип перерахування MyDayOfWeek, який визначає дні тижня (SUNDAY, MONDAY, …)
 * 2. Створіть клас Main з методом main, який перебирає можливі значення перерахування MyDayOfWeek у циклі та друкує
 * назву кожного значення на консолі.
 * 3. Виконайте програму.
 * Приклад виведення програми:
 * SUNDAY
 * MONDAY
 * TUESDAY
 * WEDNESDAY
 * THURSDAY
 * FRIDAY
 * SATURDAY
 * 4. Додайте до методу main() код, який перебирає можливі значення перерахування MyDayOfWeek у циклі та використовуючи
 * оператор switch, друкує дні тижня на консолі, лише якщо у вас є заняття з програмування на Java.
 * 5. Виконайте програму.
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

enum MyDayOfWeek {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

public class Main {
    public static void main(String[] args) {

        for (MyDayOfWeek day : MyDayOfWeek.values()) {
            System.out.println(day);
        }

        System.out.println();
        boolean haveJavaClass = true;

        for (MyDayOfWeek day : MyDayOfWeek.values()) {
            switch (day) {
                case WEDNESDAY, FRIDAY -> {
                    if (haveJavaClass) {
                        System.out.println("Have Java class on " + day);
                    }
                }
                default -> System.out.println("No Java class on " + day);
            }
        }
    }
}

