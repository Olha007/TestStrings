package task_2_17_7_testsemaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1. Додайте пакет testsemaphore, у якому будуть розташовані класи програми-симулятора АЗС, яка має 5 місць для
 * обслуговування 10 автомобілів.
 * 2. Створіть клас під назвою GasStation, який буде предсавляти заправку для автомобілів. Оголосіть у цьому класі поле
 * Semaphore, що буде керувати доступом до колонок АЗС, та поле масив freeParkingLots типу boolean, який міститиме ознаки
 * зайнятості колонок. Крім того, оголосіть поле lockGasStation типу Lock під назвою, яке буде використовуватись для
 * синхронізації доступу до масиву freeParkingLots.
 * 3. Додайте до класу GasStation конструктор з параметром int places, який ініціалізує об’єкт семафора та задає розмір
 * масиву freeParkingLots (дорівнює кількості колонок). Встановіть у конструкторі для всіх елементів масиву значення true
 * (лоти вільні). Також створіть у конструкторі об’єкт ReentrantLock, який буде сихронізувати потоків доступ до масиву.
 * 4. Реалізуйте у класі GasStation метод takePlace(), який імітуватиме отримання вільної колонки автомобілем та його
 * заправку. Використовуйте об'єкт-семафор для регулювання доступу автомобілів до заправних колонок.
 * 5. Розробіть у класі GasStation приваний метод getLot(), який шукає та отримує для автомобіля вільну колонку, номер
 * якої використовується у методі takePlace().
 * 6. Після отримання вільної колонки у методі takePlace() імітується заправка автомобіля впродовж випадкового часу
 * (від 2 до 10 секунд) і виводиться на консоль номер автомобіля, номер колонки та тривалість заправки. 7. По завершенню
 * заправки всановіть у масиві freeParkingLots ознаку для колонки, що вона є вільною.
 * 7. Додайте до проекту клас Car, який імплементує інтерфейс Runnable, із полем типу GasStation. Релізуйте конструктор,
 * що ініціює це поле.
 * 8. Реалізуйе метод run() класу Car, у якому спочатку виведіть на консоль номер автомобіля (ім'я потоку) з інформацією,
 * що він під'їхав до заправки. Потім розмістіть виклик меоду takePlace() об’єкта GasStation. Нарешті, виведіть на консоль
 * номер автомобіля (ім'я потоку) з інформацією, що він закінчив заправку та залишив АЗС.
 * 9. Додайте до проекту клас Main з методом main(), у якому створіть об’єкт GasStation із 5 заправними колонками.
 * Створіть масив з 10 потоками, що виконують об'єкти Car, при цьому задвайте імена потоків, як Car-i, де i - значення
 * ітератора, а запустіть ці потоки.
 * 10. Виконайте програму.
 * 11. Зазначте у документованому коментарі класів номер завдання, своє ім'я та прізвище.
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class GasStation {
    private Semaphore gasStationSemaphore;
    private boolean[] freeParkingLots;
    private Lock lockGasStation;

    public GasStation(int places) {
        this.gasStationSemaphore = new Semaphore(places, true);
        this.freeParkingLots = new boolean[places];
        for (int i = 0; i < places; i++) {
            freeParkingLots[i] = true;
        }
        this.lockGasStation = new ReentrantLock();
    }

    // Метод симулює заправку автомобіля на заправній колонці
    public void takePlace(int carNumber) {
        try {
            gasStationSemaphore.acquire();
            int lot = getLot();
            if (lot != -1) {
                System.out.println("Car " + carNumber + " is using the gas pump at lot " + lot);
                int refuelTime = (int) (Math.random() * 8) + 2;
                Thread.sleep(refuelTime * 1000);
                freeParkingLots[lot] = true;
                System.out.println("Car " + carNumber + " has finished refueling for " + refuelTime + " seconds and left lot " + lot);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            gasStationSemaphore.release();
        }
    }

    //шукає вільну колонку для заправки
    private int getLot() {
        lockGasStation.lock();
        try {
            for (int i = 0; i < freeParkingLots.length; i++) {
                if (freeParkingLots[i]) {
                    freeParkingLots[i] = false;
                    return i;
                }
            }
            return -1; // no free lots available
        } finally {
            lockGasStation.unlock();
        }
    }
}


class Car implements Runnable {
    private GasStation gasStation;
    private int carNumber;

    public Car(GasStation gasStation, int carNumber) {
        this.gasStation = gasStation;
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        System.out.println("Car-" + carNumber + " has arrived at the gas station.");
        gasStation.takePlace(carNumber);
        System.out.println("Car-" + carNumber + " has finished refueling and left the gas station.");
    }
}

class Main {
    public static void main(String[] args) {
        // Створення об'єкта GasStation з 5 заправними колонками
        GasStation gasStation = new GasStation(5);

        // Створення масиву з 10 потоками, що виконують об'єкти Car
        Thread[] carThreads = new Thread[10];
        for (int i = 1; i <= 10; i++) {
            carThreads[i - 1] = new Thread(new Car(gasStation, i), "Car-" + i);
        }

        // Запуск потоків
        for (Thread thread : carThreads) {
            thread.start();
        }
    }
}

