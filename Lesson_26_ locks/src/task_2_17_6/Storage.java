package task_2_17_6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1. Додайте пакет locks.
 * 2. Скопіюйте до цього пакету клас Storage з завдання 2.17.3 та перепишіь його так, щоб він використовував об'єкт класу ReentrantLock для синхронізації потоків із використанням отриманого з нього об'єкта Condition.
 * 3. Скопіюйте також класи Counter, Printer та клас Main з методом main().
 * 4. Виконайте програму.
 * 5. Зазначте у документованому коментарі класів номер завдання, своє ім'я та прізвище.
 * <p>
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class Storage {
    private int data;
    private boolean isWritingDone = false;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();// Створення об'єкта Condition для управління умовами

    // Метод для встановлення даних з використанням ReentrantLock і Condition
    // Метод для встановлення даних з використанням ReentrantLock і Condition
    public void setData(int data) {
        lock.lock();
        try {
            while (isWritingDone) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("setData interrupted");
                }
            }
            this.data = data;
            isWritingDone = true;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public int getData() {
        lock.lock();
        try {
            while (!isWritingDone) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("getData interrupted");
                }
            }
            isWritingDone = false;
            condition.signal();
            return data;
        } finally {
            lock.unlock();
        }
    }
}

    class Counter extends Thread {
    private final Storage storage;

    public Counter(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            storage.setData(i);
        }
    }
}

class Printer extends Thread {
    private final Storage storage;

    public Printer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            int data = storage.getData();
            System.out.println(data);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Counter counter = new Counter(storage);
        Printer printer = new Printer(storage);

        counter.start();
        printer.start();
    }
}
