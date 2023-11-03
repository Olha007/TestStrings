package task_2_17_4;

/**
 * 1. Додайте пакет lesson24.synblocks.
 * 2. Скопіюйте у цей пакет класи з завдання 2.17.3 та переробіть класи Storage, Counter і Printer, залишивши у класі
 * Storage тільки конструктор та гетери-сетери та перемістивши функціональність встановлення інкрементованих значень до
 * Storage до класу Counter і отримання та виведення їх значень до класу Printer. Для синхронізації доступу потоків до
 * об'єкту Storage використовуйте синхронні блоки на моніторі екземпляра Storage.
 * 3. Скопіюйте програму, яка створює екземпляр класу Storage і встановлює його у об’єкти Counter і Printer для роботи з
 * ним з завдання 2.17.3 та виконайте її.
 * 4. Зазначте у документованому коментарі класів номер завдання, своє ім'я та прізвище.
 * <p>
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class Storage {
    private int data;
    private boolean isWritingDone = false;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isWritingDone() {
        return isWritingDone;
    }

    public void setWritingDone(boolean isWritingDone) {
        this.isWritingDone = isWritingDone;
    }
}

class Counter extends Thread {
    private final Storage storage;

    public Counter(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        synchronized (storage) {
            for (int i = 0; i <= 1000; i++) {
                storage.setData(i);
                storage.notify();
                try {
                    storage.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Counter interrupted");
                }
            }
            storage.setWritingDone(true);
            storage.notify();
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
        synchronized (storage) {
            while (!storage.isWritingDone()) {
                try {
                    int data = storage.getData();
                    System.out.println(data);
                    storage.notify();
                    if (!storage.isWritingDone()) {
                        storage.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Printer interrupted");
                }
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



