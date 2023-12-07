package task_2_20_10_comparators;

/**
 * 1. Додайте пакет comparators.
 * 2. Додайте до пакету клас Main з методом main, у якому створіть програму для обробки списку персон:
 * List<Person> persons = Arrays.asList(
 * new Person("Sally", "Jones", 3),
 * new Person("Sally", "Seashell", 4),
 * new Person("Harry", "Jones", 1),
 * new Person("Harry", "Homeowner", 5),
 * new Person("Harry", "Homeowner", 2)
 * );
 * 3. Відсортуйте список об’єктів Person спочатку за ім'ям, потім за прізвищем у зворотному порядку, а потім за номером.
 * 4. Після завершення сортування роздрукуйте отриманий список.
 * <p>
 * * * @version 1.0
 * * * @author Olha Nozdriukhina
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Person {
    private String firstName;
    private String lastName;
    private int number;

    public Person(String firstName, String lastName, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", number=" + number +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Sally", "Jones", 3),
                new Person("Sally", "Seashell", 4),
                new Person("Harry", "Jones", 1),
                new Person("Harry", "Homeowner", 5),
                new Person("Harry", "Homeowner", 2)
        );

        // Створюємо компаратор за ім'ям, прізвищем і номером
        Comparator<Person> comparator = Comparator
                .comparing(Person::getFirstName)
                .thenComparing(Person::getLastName, Comparator.reverseOrder())
                .thenComparingInt(Person::getNumber);

        // Сортуємо список за допомогою компаратора
        persons.sort(comparator);

        for (Person person : persons) {
            System.out.println(person);
        }
    }
}

