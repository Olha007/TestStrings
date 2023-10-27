package task_2_17_3;

/**
 * 1. Додайте пакет lesson24.synmethods.
 * 2. Розробіть і додайте до цього пакету три класи: Storage, Counter і Printer.
 * Клас Storage повинен зберігати ціле число у цілочисельній змінній data і мати відповідні методи запису та отримання
 * його значення. Передбачте синхронізацію методів, щоб запобігти інтерференції потоків та забезпечити цілісність даних
 * у пам'яті.
 * Клас Counter - це потік, який інкрементує число, починаючи від 0 до 1000, і зберігає кожне значення по черзі у змінній
 * data класу Storage.
 * Клас Printer - це потік, який зчитує кожне інкрементоване значення, збережене у класі Storage, і виводить його на консоль.
 * 3. Додайте до класу Storage флаг типу boolean для сигналізації про завершення запису у Storage потоком Counter та
 * перевірки потоком Printer (за допомогою механізму wait/notify).
 * 4. Напишіть програму, яка створює екземпляр класу Storage і встановлює його у об’єкти Counter і Printer для роботи з ним.
 * 5. Виконайте програму.
 * <p>
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class Storage {
    private int data;
    private boolean isWritingDone = false;

    public synchronized void setData(int data) {
        this.data = data;
        notify();
    }

    public synchronized int getData() throws InterruptedException {
        wait();
        return data;
    }

    public synchronized void setWritingDone() {
        isWritingDone = true;
        notify();
    }

    public synchronized boolean isWritingDone() {
        return isWritingDone;
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
        storage.setWritingDone();
    }
}

class Printer extends Thread {
    private final Storage storage;

    public Printer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (!storage.isWritingDone()) {
            try {
                int data = storage.getData();
                System.out.println(data);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Printer interrupted");
            }
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

