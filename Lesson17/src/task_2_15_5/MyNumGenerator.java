package task_2_15_5;

import java.util.*;

/**
 * 1. Додайте до класу MyNumGenerator з попереднього завдання метод generateDistinct(), який повертає нову колекцію
 * (типу Set) із довжиною numOfElm і заповненою випадковими числами без повторюваних значень від 0 до maxNumb (включно обидві границі).
 * 2. Додайте до методу main() класу Main код, що створює екземпляр MyNumGenerator і виводить результат виклику методу
 * generateDistinct() на консоль.
 * 3. Виконайте програму.
 * Результат програми (наприклад, для параметрів 10, 5) повинен виглядати, наприклад:
 * [0, 2, 3, 1, 4, 5]
 * 4. Додайте до класу MyNumGenerator метод generateOrdered(), який повертає нову колекцію (типу TreeSet) упорядковану
 * за значеннями елементів із довжиною numOfElm і заповненою випадковими числами від 0 до maxNumb (включно обидві границі).
 * 5. Додайте до класу MyNumGenerator метод splitOrdered(), який приймає як параметр колекцію TreeSet та виводить
 * на консоль дві її частини: елементи, які менші середнього арифметичного колекції-параметра, та елементи, що більше
 * або дорівнюють середньому арифметичному колекції-параметра.
 * 6. Зазначте у документованому коментарі класів номер завдання, своє ім'я та прізвище.
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */
public class MyNumGenerator {

    int numOfElm;
    int maxNumb;

    public MyNumGenerator(int numOfElm, int maxNumb) {
        this.numOfElm = numOfElm;
        this.maxNumb = maxNumb;
    }

    public List<Integer> generate() {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numOfElm; i++) {
            int randomNumber = random.nextInt(maxNumb + 1); // +1 to include maxNumb
            result.add(randomNumber);
        }
        return result;
    }

    public Set<Integer> generateDistinct() {
        if (numOfElm > maxNumb + 1) {
            throw new IllegalArgumentException("Cannot generate more distinct numbers than the range allows.");
        }

        Set<Integer> distinctNumbers = new LinkedHashSet<>();
        Random random = new Random();

        while (distinctNumbers.size() < numOfElm) {
            int randomNumber = random.nextInt(maxNumb + 1); // +1 to include maxNumb
            distinctNumbers.add(randomNumber);
        }

        return distinctNumbers;
    }

    public TreeSet<Integer> generateOrdered() {
        TreeSet<Integer> orderedNumbers = new TreeSet<>();
        Random random = new Random();

        for (int i = 0; i < numOfElm; i++) {
            int randomNumber = random.nextInt(maxNumb + 1); // +1 to include maxNumb
            orderedNumbers.add(randomNumber);
        }

        return orderedNumbers;
    }

    public void splitOrdered(TreeSet<Integer> sortedNumbers) {
        if (sortedNumbers.isEmpty()) {
            System.out.println("The collection is empty.");
            return;
        }

        Iterator<Integer> iterator = sortedNumbers.iterator();
        double average = calculateAverage(sortedNumbers);

        SortedSet<Integer> lessThanAverage = new TreeSet<>();
        SortedSet<Integer> greaterThanOrEqualAverage = new TreeSet<>();

        while (iterator.hasNext()) {
            int number = iterator.next();
            if (number < average) {
                lessThanAverage.add(number);
            } else {
                greaterThanOrEqualAverage.add(number);
            }
        }

        System.out.println("Elements less than the average: " + lessThanAverage);
        System.out.println("Elements greater than or equal to the average: " + greaterThanOrEqualAverage);
    }

    private double calculateAverage(SortedSet<Integer> sortedNumbers) {
        int sum = 0;
        for (int num : sortedNumbers) {
            sum += num;
        }
        return (double) sum / sortedNumbers.size();
    }
}

class Main {
    public static void main(String[] args) {
        MyNumGenerator numGenerator = new MyNumGenerator(6, 5);

        // Generate distinct random numbers
        Set<Integer> distinctRandomNumbers = numGenerator.generateDistinct();
        System.out.println("Generated distinct random numbers: " + distinctRandomNumbers);

        // Generate ordered numbers and split them
        TreeSet<Integer> orderedNumbers = numGenerator.generateOrdered();
        System.out.println("Generated ordered numbers: " + orderedNumbers);
        numGenerator.splitOrdered(orderedNumbers);
    }
}













