package task_2_13_2;

import java.util.Scanner;

/**
 * 1. Додайте до перерахування MyDayOfWeek, створеного у попередньому завданні, метод nextDay(), який повертає наступний день тижня для значення перерахування, з якого викликається цей метод.
 * Наприклад: MyDayOfWeek.FRIDAY.nextDay() має повертати MyDayOfWeek.SATURDAY.
 * 2. Додайте до методу main() класу Main код, який зчитує рядкове значення з консолі (за допомогою Scanner), виконує парсинг рядкового значення до певного значення enum, а потім виводитьь на консоль назву наступного дня тиждня. Передбачте генерування виключення у разі, якщо користувачем вводться помилкове рядкове значення.
 * 3. Виконайте програму.
 * Приклад виведення програми:
 * FRIDAY
 * Наступний день тижня: SATURDAY
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

enum MyDayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public MyDayOfWeek nextDay() {
        int nextIndex = (this.ordinal() + 1) % values().length;
        return values()[nextIndex];
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть день тижня: ");

        try {
            String input = scanner.nextLine();
            MyDayOfWeek currentDay = MyDayOfWeek.valueOf(input);
            MyDayOfWeek nextDay = currentDay.nextDay();

            System.out.println("Поточний день тижня: " + currentDay);
            System.out.println("Наступний день тижня: " + nextDay);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилковий ввід, введіть правильний день тижня");
        }

    }
}
