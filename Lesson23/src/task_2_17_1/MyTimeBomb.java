package task_2_17_1;

/**
 * 1. Створіть новий пакет testthread.
 * 2. Створіть клас MyTimeBomb, який розширює клас Thread.
 * 3. Перевизначте метод run() так, щоб він виводив на консоль числа від 10 до 0 з паузою у 1 секунду і після
 * цього рядок "Boom!!!".
 * 4. Створіть клас Main з методом main, який оголошує локальну змінну bomb1 типу MyTimeBomb, і створіть
 * екземпляр MyTimeBomb. Запустіть поток і виконайте програму.
 * Результат програми повинен бути таким, як у наступному прикладі:
 * 10
 * 9
 * 8
 * 7
 * 6
 * 5
 * 4
 * 3
 * 2
 * 1
 * 0
 * Boom!!!
 * 5. Додайте до пакету testthread клас MyTimeBombTask, що реалізує інтерфейс Runnable.
 * 6. Перевизначте метод run() так, щоб він виводив на консоль числа від 10 до 0 з паузою у 1 секунду і після цього
 * рядок "Boom!!!".
 * 7. Додайте до методу main класу Main код, який оголошує локальну змінну bomb2 типу MyTimeBombTask, і створіть
 * екземпляр MyTimeBombTask.
 * Створіть потік, у конструктор якого передайте екземпляр bomb2. Запустіть поток і виконайте програму.
 * Результат програми повинен бути таким, як у попередній програмі.
 * <p>
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class MyTimeBomb extends Thread {

    @Override
    public void run() {
        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // пауза на 1 секунду
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Boom!!!");
    }
}

class MyTimeBombTask implements Runnable {
    @Override
    public void run() {
        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // пауза на 1 секунду
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Boom!!!");
    }
}

class Main {
    public static void main(String[] args) {
        MyTimeBomb bomb1 = new MyTimeBomb();
        bomb1.start();

        MyTimeBombTask bombTask = new MyTimeBombTask();
        Thread bomb2 = new Thread(bombTask);
        bomb2.start();
    }
}
