package lesson13_testexcp1;

/**
 * 1. Додайте до поточного проєкту до нього пакет lesson13.testexcp1.
 * 2. Створіть у цьому пакеті клас Person, у якому оголосіть поля firstName(типу String), lastName(String), age (int).
 * Додайте до класу конструктор, геттери та сеттери для кожного поля.
 * 3. Створіть клас InvalidAgeException, який є підкласом RuntimeException, із конструктором без параметрів, який передає
 * до конструктора суперкласу повідомлення про помилкове значення віку.
 * 4. Виконайте модифікацію сеттера поля age, який має викликати InvalidAgeException, коли вік виходить за межі діапазону 1-120.
 * 5. Створіть клас Main з методом main, який створює об’єкт Person і викликає метод setAge з обробкою виключення за
 * допомогою оператора try-catch і виводить на консоль повідомлення виключення про помилку.
 * 6. Виконайте програму.
 * *
 * * @version 1.1
 * * @autor Olha Nozdriukhina
 */

public class Person {

    String firstName;
    String lastName;
    int age;

    public Person(String firstName, String lastName, int age) throws InvalidAgeException {
        this.firstName = firstName;
        this.lastName = lastName;
        setAge(age);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 1 || age > 120) {
            throw new InvalidAgeException();
        }
        this.age = age;
    }
}
