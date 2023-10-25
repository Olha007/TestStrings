package task_2_17_2;

/**
 * 1. Додайте до пакету testthread клас MySumCount, який розширює клас Thread.
 * 2. Додайте до класу MySumCount приватні цілочисельні поля startIndex, stopIndex та resultSum із відповідними гетерами.
 * 3. Додайте до класу MySumCount приватне поле arr - масив цілого типу.
 * 4. Додайте до класу MySumCount конструктор, який задає значення полів startIndex, stopIndex та встановлює
 * посилання на масив arr.
 * 5. Перевизначте метод run() MySumCount. Додайте код для обчислення суми елементів масиву від startIndex до stopIndex
 * і збережіть результат у полі resultSum.
 * 6. Створіть клас Main з методом main, який оголошує локальну змінну myArray як масив цілого типу (розміром 1000) і
 * заповнює елементи масиву значеннями їх індексу.
 * 7. Створіть два екземпляри MySumCount.
 * 8. Додайте код для обчислення суми елементів myArray у двох окремих потоках - перший повинен обчислювати елементи
 * за індексами від 0 (включно) до 500 (виключно), другий - елементи за індексами від 500 (включно) до 1000 (виключно), та виведіть суму елементів, що розраховується кожним з потоків, та загальну суму на консоль.
 * 9. Виконайте програму.
 * <p>
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class MySumCount extends Thread {
    private int startIndex;
    private int stopIndex;
    private int resultSum;
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

    public int getResultSum() {
        return resultSum;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < stopIndex; i++) {
            resultSum += arr[i];
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[] myArray = new int[1000];

        // Заповнення масиву значеннями їх індексу
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i;
        }

        // Створення двох екземплярів MySumCount
        MySumCount thread1 = new MySumCount(0, 500, myArray);
        MySumCount thread2 = new MySumCount(500, 1000, myArray);

        thread1.start();
        thread2.start();

        // Очікування завершення обох потоків
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Сума елементів першої половини масиву: " + thread1.getResultSum());
        System.out.println("Сума елементів другої половини масиву: " + thread2.getResultSum());
        System.out.println("Загальна сума масиву: " + (thread1.getResultSum() + thread2.getResultSum()));
    }
}

