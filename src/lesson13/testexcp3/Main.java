package lesson13.testexcp3;

/**
 * 1. Додайте до поточного проєкту до нього пакет lesson13.testexcp3. Створіть у цьоу пакеті клас Main з методом main().
 * 2. Додайте до класу Main статичний метод compute( ,  ), який використовує як аргументи два різні числові класи огортки.
 * Метод повинен додавати перший аргумент до другого та повертати екземпляр огортку, значенням якого є сума аргументів.
 * 3. У методі main() напишіть код для виклику метода compute( ,) у твердженні (assert), яке у разі його невиконання
 * повинно виводити відповідне повідомлення.
 * 4. Виконайте програму, порівнюючи результат метода compute( ,) зі значенням, відмінним від очікуваного.
 * 5. Ще раз виконайте програму, але тепер зі встановленим аргументом запуска віртуальної машини –ea.
 * *
 * * @version 1.1
 * * @autor Olha Nozdriukhina
 */

public class Main {
    public static void main(String[] args) {

        IntegerWrapper intWrapper = new IntegerWrapper(5);
        DoubleWrapper doubleWrapper = new DoubleWrapper(3.5);

        Number result = compute(intWrapper, doubleWrapper);

        // Перевірка твердження
        assert result.doubleValue() == 8.5 : "Помилка: результат не відповідає очікуваному значенню";

        System.out.println("Результат вірний: " + result);
    }

//    public static NumberWrapper compute(NumberWrapper first, NumberWrapper second) {
//        double sum = first.getValue() + second.getValue();
//        return new NumberWrapper(sum);
//    }

    public static Number compute(IntegerWrapper a, DoubleWrapper b) {
        return a.getValue() + b.getValue();
    }
}

class NumberWrapper {
    private double value;

    public NumberWrapper(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}

class IntegerWrapper extends NumberWrapper {
    public IntegerWrapper(double value) {
        super(value);
    }
}

class DoubleWrapper extends NumberWrapper {
    public DoubleWrapper(double value) {
        super(value);
    }
}
