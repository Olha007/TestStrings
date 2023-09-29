package task_2_15_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 1. Додайте пакет testmygen.
 * 2. Створіть клас MyNumGenerator із двома полями: numOfElm і maxNumb типу int, конструктором із двома параметрами
 * та методом generate(), який повертає нову колекцію (типу List) із довжиною numOfElm, заповненою випадковими числами
 * від 0 до maxNumb (включно обидві границі).
 * 3. Створіть клас Main з методом main(). Додайте код методу main(), що створює екземпляр MyNumGenerator і виводить
 * результат виклику методу generate() на консоль.
 * 4. Виконайте програму.
 * Результат програми (наприклад, для параметрів 10, 5) повинен виглядати, наприклад:
 * [1, 2, 2, 4, 1, 0, 4, 5, 1, 3]
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

        for (int i = 0; i < numOfElm; i++){
            int randomNumber = random.nextInt(maxNumb + 1); // +1 to include maxNumb
            result.add(randomNumber);
        }
        return result;
    }
}

class Main{
    public static void main(String[] args) {

        MyNumGenerator numGenerator = new MyNumGenerator(10, 5);
        List<Integer> randomNumbers= numGenerator.generate();

        System.out.println("Generated random numbers: " + randomNumbers);
    }
}





