package task2_17_9_testconcoll;
/**
 * Створіть клас потоку HashMapPutThread, який містить поля для ключа (Integer) та значення (Character) т
 * а посилання на колекцію Map<Integer, Character>, та метод run якого розміщує у колекції ключ та значення, які разом
 * з посиланням на колекцію передаються як параметри конструктора, а також виводить на консоль свлє ім'я та додані ключ
 * та значення.
 * Створіть клас потоку HashMapGetThread, який містить поля для ключа (Integer) та посилання на колекцію Map<Integer,
 * Character>, та метод run якого викнує цикл for-each для наявних у колекції елементів та виводить ключ та значення на
 * консоль разом зі своїм ім'ям.
 * Додайте до проекту клас Main з методом main(), у якому 10 потоків записують у колекцію типу ConcurrentHashMap символи
 * від A до J, та 10 потоків читають дані колекції. У кінці методу виведіть елементи колекції на екран. Виконайте програму.
 *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class HashMapPutThread extends Thread {
    private final Integer key;
    private final Character value;
    private final Map<Integer, Character> map;

    public HashMapPutThread(Integer key, Character value, Map<Integer, Character> map) {
        this.key = key;
        this.value = value;
        this.map = map;
    }

    @Override
    public void run() {
        map.put(key, value);
        System.out.println("Thread " + Thread.currentThread().getId() +
                " added key: " + key + ", value: " + value);
    }
}

class HashMapGetThread extends Thread {
    private final Map<Integer, Character> map;

    public HashMapGetThread(Map<Integer, Character> map) {
        this.map = map;
    }

    @Override
    public void run() {
        for (Map.Entry<Integer, Character> entry : map.entrySet()) {
            System.out.println("Thread " + Thread.currentThread().getId() +
                    " retrieved key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer, Character> concurrentHashMap = new ConcurrentHashMap<>();

        Thread[] putThreads = new Thread[10];
        Thread[] getThreads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            final int index = i;
            putThreads[i] = new HashMapPutThread(i, (char) ('A' + i), concurrentHashMap);
            getThreads[i] = new HashMapGetThread(concurrentHashMap);

            putThreads[i].start();
            getThreads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            putThreads[i].join();
            getThreads[i].join();
        }

        System.out.println("Final elements in the map:");
        for (Map.Entry<Integer, Character> entry : concurrentHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}



