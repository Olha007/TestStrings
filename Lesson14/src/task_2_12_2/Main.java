package task_2_12_2;

/**
 * 1. Додайте до класу MyPhoneBook з попереднього завдання два загальнодоступних методи sortByName() і sortByPhoneNumber().
 * 2. За допомогою інтерфейсу Comparator та анонімного класу розробіть код у методі sortByName() для сортування масиву PhoneNumbers за назвою.
 * 3. За допомогою інтерфейсу Comparator та анонімного класу розробіть код у методі sortByPhoneNumber(), щоб сортувати масив PhoneNumbers за номером телефона.
 * 4. Додайте до методу main() класу Main код, який створює об’єкт MyPhoneBook, і заповнює його десятьма записами телефонних номерів. Додайте код для сортування телефонних номерів у телефонній книзі, викликавши sortByName(), а потім викликавши метод printPhoneBook().
 * 5. Виконайте програму.
 * Приклад виведення програми:
 * Ім'я: Анна, телефон: 0501237777
 * Ім'я: Борис, телефон: 0679878888
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class Main {
    public static void main(String[] args) {

        MyPhoneBook phoneBook = new MyPhoneBook();

        phoneBook.addPhoneNumber("Саша", "0501234567");
        phoneBook.addPhoneNumber("Вова", "0679876543");
        phoneBook.addPhoneNumber("Джек", "0689876544");
        phoneBook.addPhoneNumber("Давид", "07987655");
        phoneBook.addPhoneNumber("Микита", "0974666543");
        phoneBook.addPhoneNumber("Андрій", "0500234567");
        phoneBook.addPhoneNumber("Петро", "0672276543");
        phoneBook.addPhoneNumber("Дмитро", "0687776544");
        phoneBook.addPhoneNumber("Дарина", "07999655");
        phoneBook.addPhoneNumber("Федір", "0974644543");

        System.out.println("Unsorted: ");
        phoneBook.printPhoneBook();
        System.out.println();

        System.out.println("Sorted by name: ");
        phoneBook.sortByName();
        phoneBook.printPhoneBook();


    }
}