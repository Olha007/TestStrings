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
        while (isWritingDone) {
            try {
                wait();
            } catch (InterruptedException e) {
                // Thread.currentThread().interrupt();
                // System.out.println("setData interrupted");
            }
        }
        this.data = data;
        isWritingDone = true;
        notify();
    }

    public synchronized int getData() {
        while (!isWritingDone) {
            try {
                wait();
            } catch (InterruptedException e) {
                //Thread.currentThread().interrupt();
                //System.out.println("getData interrupted");
            }
        }
        isWritingDone = false;
        notify();
        return data;
    }
}

class Counter extends Thread {
    private final Storage storage;
    private final int times;

    public Counter(Storage storage, int times) {
        this.storage = storage;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i <= times; i++) {
            storage.setData(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Printer extends Thread {
    private final int times;
    private final Storage storage;

    public Printer(Storage storage, int times) {
        this.storage = storage;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i <= times; i++) {
            int data = storage.getData();
            System.out.println(data);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        int times = 1000;
        Counter counter = new Counter(storage, times);
        Printer printer = new Printer(storage, times);

        counter.start();
        printer.start();
    }
}


