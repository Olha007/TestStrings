package task_2_18_2;

/**
 * . Створіть програму, яка створює масив розміром 10 елементів, кожен з яких є випадковим 128-бітовим числом BigInteger.
 * 2. Додайте код, який обраховує цілу частину та цілочисельний остаток середнього арифметичного значень елементів масиву,
 * та виводить на екран елементи масиву та обраховані частини середнього арифметичного.
 * 3. Виконайте перевірку правильності запропонованого рішення для того ж масиву, елементи якого будуть містити значення свого індексу.
 * 4. Зазначте у документованому коментарі класів номер завдання, своє ім'я та прізвище.
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

import java.math.BigInteger;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Створюємо масив розміром 10 з випадковими 128-бітовими числами BigInteger
        BigInteger[] array = new BigInteger[10];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            byte[] bytes = new byte[16];
            random.nextBytes(bytes);
            array[i] = new BigInteger(bytes);
        }

        // Виводимо елементи масиву та обраховану частину та остаток середнього арифметичного
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger element : array) {
            System.out.println("Елемент: " + element);
            sum = sum.add(element);
        }

        BigInteger average = sum.divide(BigInteger.valueOf(array.length));
        BigInteger remainder = sum.remainder(BigInteger.valueOf(array.length));

        System.out.println("\nЦіла частина середнього арифметичного: " + average);
        System.out.println("Цілочисельний остаток середнього арифметичного: " + remainder);

        // Перевірка для масиву зі значеннями індексів
        System.out.println("\nПеревірка для масиву зі значеннями індексів:");
        BigInteger[] indexArray = new BigInteger[10];

        for (int i = 0; i < indexArray.length; i++) {
            indexArray[i] = BigInteger.valueOf(i);
        }

        BigInteger indexSum = BigInteger.ZERO;
        for (BigInteger element : indexArray) {
            System.out.println("Елемент: " + element);
            indexSum = indexSum.add(element);
        }

        BigInteger indexAverage = indexSum.divide(BigInteger.valueOf(indexArray.length));
        BigInteger indexRemainder = indexSum.remainder(BigInteger.valueOf(indexArray.length));

        System.out.println("\nЦіла частина середнього арифметичного: " + indexAverage);
        System.out.println("Цілочисельний остаток середнього арифметичного: " + indexRemainder);
    }
}

