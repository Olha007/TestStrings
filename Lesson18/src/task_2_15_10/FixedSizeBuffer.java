package task_2_15_10;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 1. Створіть узагальнений клас FixedSizeBuffer<K,V>, який успадковує LinkedHashMap<K, V>.
 * 2. Додайте до цього класу приватне фінальне поле maxsize, що визначає максимальну кількість елементів у буфері,
 * та конструктор, який його ініціалізує.
 * 3. Додайте до класу перевизначений метод LinkedHashMap - boolean removeEldestEntry(Map.Entry<K, V> eldest), який
 * обмежує вміст буферу зазначеною змінною maxsize кількістю елементів та виводить до консолі ключ та значення, які
 * видаляються у разі переповнення буферу.
 * 4. Створіть клас Main з методом main(), у коді якого створіть екземпляр FixedSizeBuffer<Integer,Character>, який
 * може містити максимум 3 елементи .
 * 5. Додайте до методу main() цикл з 5 ітераціями, у якому додавайте до буферу записи з ключами, що дорівнюють ітератору
 * та відповідними значеннями ключів у вигляді символів.
 * 6. У кінці програми віведіть вміст буферу до консолі.
 * 7. Виконайте програму.
 * 8. Зазначте у документованому коментарі класів номер завдання, своє ім'я та прізвище.
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

class FixedSizeBuffer<K, V> extends LinkedHashMap<K, V> {
    private final int maxsize;

    public FixedSizeBuffer(int maxsize) {
        this.maxsize = maxsize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        boolean removeEldest = size() > maxsize;
        if (removeEldest) {
            System.out.println("Видаляється: " + eldest.getKey() + " -> " + eldest.getValue());
        }
        return removeEldest;
    }
}

class Main {
    public static void main(String[] args) {
        FixedSizeBuffer<Integer, Character> buffer = new FixedSizeBuffer<>(3);

        for (int i = 1; i <= 5; i++) {
            buffer.put(i, (char) ('A' + i - 1));
        }

        System.out.println("Вміст буфера:");
        for (Map.Entry<Integer, Character> entry : buffer.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

