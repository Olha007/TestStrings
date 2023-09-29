package task_2_18_3;

/**
 * 1. Створіть програму, яка виконає порівняння результуючих сум типу BigDecimal, які отримуються додаванням однакової послідовності випадкових чисел BigDecimal при використані різних режимів скруглення: HALF_EVEN та HALF_UP. При цьому випадкові числа повинні генеруватись у діапазоні від 1.000 до 100.000 включно та враховувати 3 розряди після коми.
 * 2. Додайте клас Main з методом main, у якому організуйте у циклі з 100_000 ітераціями генерацію випадкових значень BigDecimal з вказаними вище властивостями та додання їх до оголошених у методі main змінних accountHalfEven та accountHalfUp типу BigDecimal.
 * 3. Виведіть результуючі суми на консоль. Зробіть висновки за результатами обчислень.
 * <p>
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BigDecimal accountHalfEven = BigDecimal.ZERO;
        BigDecimal accountHalfUp = BigDecimal.ZERO;
        Random random = new Random();

        for (int i = 0; i < 100_000; i++) {
            BigDecimal randomValue = getRandomBigDecimal(random);
            accountHalfEven = accountHalfEven.add(randomValue);
            accountHalfUp = accountHalfUp.add(randomValue);
        }

        System.out.println("Результат зі скругленням HALF_EVEN: " + accountHalfEven);
        System.out.println("Результат зі скругленням HALF_UP: " + accountHalfUp);
    }

    private static BigDecimal getRandomBigDecimal(Random random) {
        double randomDouble = 1_000 + (random.nextDouble() * (100_000 - 1_000));
        return BigDecimal.valueOf(randomDouble).setScale(3, RoundingMode.HALF_EVEN);
    }
}

