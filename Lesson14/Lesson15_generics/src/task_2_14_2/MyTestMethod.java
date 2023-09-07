package task_2_14_2;

import java.text.DecimalFormat;

/**
 * 1. Додайте до пакету testgenerics клас MyTestMethod зі статичним методом calcSum з двома параметрами: масив
 * T[] і змінна maxval типу T, який обчислює суму елементів у масиві T[], які перевищують вказане значення maxval.
 * 2. Додайте до методу main класу Main код, який створює два масиви, перший – масив типу Integer, а другий – масив
 * типу Double. Заповніть ці масиви деякими випадковими значеннями.
 * 3. Додайте код для підрахунку суми елементів у кожному з масивів, які перевищують вказаний елемент, викликавши статичний метод calcSum.
 * 4. Виконайте програму.
 * Результат програми повинен бути таким, як у наступному прикладі:
 * Значення масиву: [1,2,3,4,5,6,7,8,9]
 * Сума елементів, що перевищує 3:
 * 39
 * Значення масиву: [1.1,2.2,3.3,4.4,5.5,6.6,7.7,8.8,9.9]
 * Сума елементів, що перевищує 3:
 * 46.2
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class MyTestMethod {

    public static <T extends Number & Comparable<T>> double calcSum(T[] array, T maxval) {
        double sum = 0.0;

        for (T element : array) {
            if (element.compareTo(maxval) > 0) {
                sum += element.doubleValue();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9};

        System.out.println("Значення масиву (Integer):");
        printArray(intArray);

        System.out.println("Сума елементів, що перевищують 3 (Integer):");
        double intSum = calcSum(intArray, 3);
        System.out.println(intSum);
        System.out.println();

        System.out.println("Значення масиву (Double):");
        printArray(doubleArray);

        System.out.println("Сума елементів, що перевищують 3 (Double):");
        double doubleSum = calcSum(doubleArray, 3D);
        System.out.println(formatDecimal(doubleSum));
    }

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static String formatDecimal(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        return decimalFormat.format(number);
    }
}
