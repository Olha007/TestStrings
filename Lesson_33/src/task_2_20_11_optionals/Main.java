package task_2_20_11_optionals;

/**
 * 1. Додайте пакет optionals.
 * 2. Додайте до пакету клас Main з методом main, у якому розробіть постачальник Supplier<Optional<Integer>>, який пропонує користувачеві ввести з консолі число від 1 до 5 або "Q", щоб вийти, та повертає об'єкт Optional<Integer>. Цей об'єкт має містити ціле значення, коли вибрано число, і містити null, коли введено "Q".
 * 3. Організуйте виклик постачальника в циклі, який друкує вміст Optional, якщо він заповнений. Цикл припиняється, коли Optional буде містити null.
 * 4. Перевірте роботу програми.
 * 5. Зазначте у документованому коментарі класів номер завдання, своє ім'я та прізвище.
 * <p>
 * * * @version 1.0
 * * * @author Olha Nozdriukhina
 */

import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<Optional<Integer>> numberSupplier = () -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Enter a number between 1 and 5 or 'Q' to quit:");
                String input = scanner.nextLine();
                if ("Q".equalsIgnoreCase(input)) {
                    scanner.close();
                    return Optional.empty();
                } else {
                    try {
                        int value = Integer.parseInt(input);
                        if (value >= 1 && value <= 5) {
                            return Optional.of(value);
                        } else {
                            System.out.println("Invalid input. Please try again.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please try again.");
                    }
                }
            }
        };

        Optional<Integer> optionalValue;
        while (true) {
            optionalValue = numberSupplier.get();
            if (!optionalValue.isPresent()) {
                break;
            }
            optionalValue.ifPresent(System.out::println);
        }
    }
}

