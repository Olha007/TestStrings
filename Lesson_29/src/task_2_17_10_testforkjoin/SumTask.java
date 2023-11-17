package task_2_17_10_testforkjoin;

/**
 * 1. Додайте новий пакет testforkjoin.
 * 2. Створіть програму для обчислення суми всіх елементів масиву (з 1000000 цілих елементів, значення яких генеруються
 * випадковим чином від 0 до 100), використовуючи структуру ForkJoin.
 * 3. Створіть RecursiveTask для поділу масиву на дві частини та призначте кожну частину іншій RecursiveTask для
 * подальшого поділу. Продовжуйте поділ масиву доки у масиві буде менше 10000 елементів.
 * 4. Виконайте програму та виведіть результат на екран.
 * 5. Перевірте отриманий результат обчисленням у одному циклі суми всіх елементів масиву.
 * 6. Порівняйте час обчислення у першому та другому випадках. Зробіть висновки.
 *
 *  * * @version 1.0
 *  * * @author Olha Nozdriukhina
 */

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10000;
    private int[] array;
    private int start;
    private int end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {

            int middle = start + length / 2;

            SumTask leftTask = new SumTask(array, start, middle);
            SumTask rightTask = new SumTask(array, middle, end);

            leftTask.fork();
            rightTask.fork();

            return leftTask.join() + rightTask.join();
        }
    }

    public static void main(String[] args) {
        int[] array = new int[1000000];
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        long startTimeForkJoin = System.currentTimeMillis();

        SumTask mainTask = new SumTask(array, 0, array.length);

        long resultForkJoin = forkJoinPool.invoke(mainTask);

        long endTimeForkJoin = System.currentTimeMillis();
        System.out.println("Sum of array elements using ForkJoin: " + resultForkJoin);
        System.out.println("Time taken by ForkJoin: " + (endTimeForkJoin - startTimeForkJoin) + " ms");

        long startTimeSingleLoop = System.currentTimeMillis();

        long sumSingleLoop = 0;
        for (int value : array) {
            sumSingleLoop += value;
        }

        long endTimeSingleLoop = System.currentTimeMillis();
        System.out.println("Sum of array elements using a single loop: " + sumSingleLoop);
        System.out.println("Time taken by a single loop: " + (endTimeSingleLoop - startTimeSingleLoop) + " ms");
    }
}


