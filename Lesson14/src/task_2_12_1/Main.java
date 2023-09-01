package task_2_12_1;

/**
 * 1. Створіть клас MyPhoneBook зі статичним вкладеним класом PhoneNumber. Додайте до класу PhoneNumber два поля: name (типу String) та phone (типу String), конструктор з двома параметрами, геттери для кожного поля класу та перевизначений метод toString(), який повертає інформацію про ім’я та номер телефону.
 * 2. Додайте до класу MyPhoneBook приватне поле phoneNumbers як масив PhoneNumber (довжина масиву 10). Додайте до класу MyPhoneBook загальнодоступний метод addPhoneNumber із двома параметрами типу (ім’я, телефон), які використовуються для створення нового об’єкта PhoneNumber і розміщенн його у наступному доступному елементу масиву.
 * 3. Додайте до класу MyPhoneBook загальнодоступний метод printPhoneBook, який циклічно обробляє масив phoneNumbers і виводить інформацію про ім’я та номер телефону кожного запису на консоль.
 * 4. Створіть клас Main з методом main, який створює об’єкт об’єкт MyPhoneBook, і заповнює його п’ятьма записами телефонних номерів. Додайте код для виклику методу printPhoneBook().
 * 5. Виконайте програму.
 * Приклад виведення програми:
 * Ім'я: Саша, телефон: 0501234567
 * Ім'я: Вова, телефон: 0679876543
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class Main {
    public static void main(String[] args) {

        MyPhoneBook phoneBook = new MyPhoneBook();

        phoneBook.addPhoneNumber("Саша", "0501234567");
        phoneBook.addPhoneNumber("Вова", "0679876543");
        phoneBook.addPhoneNumber("Jack", "0689876544");
        phoneBook.addPhoneNumber("David", "9067987655");
        phoneBook.addPhoneNumber("Alia", "0674666543");

        phoneBook.printPhoneBook();
    }
}
