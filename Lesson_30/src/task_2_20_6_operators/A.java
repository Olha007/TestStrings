package task_2_20_6_operators;

/**
 * 1. Додайте пакет operators.
 * 2. Додайте до пакету клас A, який містить поля int first та double second, конструктор з параметрами та
 * перевизначений метод toString.
 * 3. Додайте до пакету клас Main з методом main, у якому створіть BinaryOperator, що повертає об'єкт класу
 * A зі значенням поля first, яке дорівнює сумі значень полів first двох об’єктів класу A, та значенням поля second,
 * яке дорівнює різниці значень полів second цих об’єктів.
 * 4. Перевірте роботу програми для двох об'єктів класу A з довільними значеннями полів.
 * <p>
 * * * @version 1.0
 * * * @author Olha Nozdriukhina
 */

import java.util.function.BinaryOperator;

public class A {

    int first;
    double second;

    public A(int first, double second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "A{" +
                "first = " + first +
                ", second = " + second +
                '}';
    }
}

class Main {
    public static void main(String[] args) {

        A obj1 = new A(1, 1.5);
        A obj2 = new A(1, 1.5);

        BinaryOperator<A> binaryOperator = (a1, a2) -> new A(a1.first + a2.first, a1.second - a2.second);
        A result = binaryOperator.apply(obj1, obj2);

        System.out.println("Result: " + result);
    }
}
