import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * . Додайте пакет executors.
 * 2. Скопіюйте до цього пакету клас MySumCount з завдання 2.17.2 та перепишіь його так, щоб він реалізовував інтерфейс Callable<Integer> (поле resultSum та відповідний гетер тепер не потрібні). Релізуйте метод call() так, щоб він повертав суму елементів масиву від startIndex до stopIndex.
 * 3. Додайте клас Main з методом main(), у якому виконайе розрахунок сум двох половин масиву, використовуючи пул потоків newFixedThreadPool(2).
 * 4. Виконайте програму.
 * 5. Зазначте у документованому коментарі класів номер завдання, своє ім'я та прізвище.
 * <p>
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class MySumCount implements Callable<Integer> {
    private int startIndex;
    private int stopIndex;
    private int[] arr;

    public MySumCount(int startIndex, int stopIndex, int[] arr) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.arr = arr;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = startIndex; i < stopIndex; i++) {
            sum += arr[i];
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        int[] myArray = new int[1000];

        // Заповнення масиву значеннями їх індексу
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i;
        }

        ExecutorService executor = Executors.newFixedThreadPool(2);

        MySumCount task1 = new MySumCount(0, 500, myArray);
        MySumCount task2 = new MySumCount(500, 1000, myArray);

        Future<Integer> future1 = executor.submit(task1);
        Future<Integer> future2 = executor.submit(task2);

        try {
            int result1 = future1.get();
            int result2 = future2.get();

            System.out.println("Сума елементів першої половини масиву: " + result1);
            System.out.println("Сума елементів другої половини масиву: " + result2);
            System.out.println("Загальна сума масиву: " + (result1 + result2));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}

