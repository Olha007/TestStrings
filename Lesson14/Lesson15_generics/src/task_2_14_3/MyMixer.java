package task_2_14_3;

import java.util.Random;

/**
 * 1. Додайте до пакету testgenerics узагальнений клас MyMixer із полем-масивом для елементів змінного типу та
 * конструктором, який задає цей масив значенням масиву-параметру.
 * 2. Додайте до класу MyMixer звичайний метод shuffle(), який перемішує елементи масиву та повертає його.
 * 3. Додайте до методу main класу Main код, який створює два масиви різних типів:
 * Перший — це масив цілих чисел зі значеннями {1,2,3,4,5,6,7,8,9}
 * Другий — це масив рядків: {"один","два", …}.
 * 4. Створіть два об’єкти типу MyMixer і використовуючи кожен із масивів, викличте метод shuffle() і виведіть результат на консоль.
 * 5. Виконайте програму.
 * Приклад виведення програми:
 * [6,7,4,3,2,9,1,5,8]
 * ["дев'ять", "один", "два", "п'ять",…]
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class MyMixer<T> {
    private T[] elements;

    public MyMixer(T[] elements) {
        this.elements = elements;
    }

    public T[] shuffle() {
        Random random = new Random();

        for (int i = elements.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            T temp = elements[index];
            elements[index] = elements[i];
            elements[i] = temp;
        }

        return elements;
    }
}

class Main {
    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] stringArray = {"один", "два", "три", "чотири", "п'ять" };

        // Створюємо об'єкти MyMixer для кожного масиву
        MyMixer<Integer> intMixer = new MyMixer<>(intArray);
        MyMixer<String> stringMixer = new MyMixer<>(stringArray);

        // Перемішуємо і виводимо результат для масиву цілих чисел
        Integer[] shuffledIntArray = intMixer.shuffle();
        System.out.println("Перемішаний масив цілих чисел: " + arrayToString(shuffledIntArray));

        // Перемішуємо і виводимо результат для масиву рядків
        String[] shuffledStringArray = stringMixer.shuffle();
        System.out.println("Перемішаний масив рядків: " + arrayToString(shuffledStringArray));
    }

    private static <T> String arrayToString(T[] array) {
        StringBuilder builder = new StringBuilder();
        for (T item : array) {
            builder.append(item).append(" ");
        }
        return builder.toString();
    }

}