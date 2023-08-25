package task_2_10_4;

import java.util.Scanner;

/**
 * 1. Створіть клас Main з методом main, у якому за допомогою екземпляра Scanner введіть ціле число.
 * 2. Переведіть введене число до двійкового формату з відображенням незначущих нулів на початку числа за допомогою методів класу Integer.
 * 3. Запустіть програму двічі - перший раз введіть позитивне ціле, а другий - негативне. Перевірте правильність роботи програми.
 * *
 * * @version 1.0
 * * @autor Olha Nozdriukhina
 */

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");

        int number = scanner.nextInt();
        int length = Integer.SIZE;

        String binaryString = String.format("%" + length + "s", Integer.toBinaryString(number)).replace(' ', '0');
        System.out.println("Binary number: " + binaryString);

        scanner.close();

    }
}
