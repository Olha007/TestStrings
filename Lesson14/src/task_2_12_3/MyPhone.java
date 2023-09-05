package task_2_12_3;

/**
 * 1. Створіть новий клас MyPhone.
 * 2. Перепишіть клас MyPhoneBook з попереднього завдання, зробивши його внутрішнім (нестатичним) класу MyPhone (перемістіть код класу MyPhoneBook всередину класу MyPhone).
 * 3. Додайте до класу MyPhone конструктор без аргументів.
 * 4. Додайте до класу MyPhone загальнодоступний метод swichOn(), який друкує повідомлення "Завантаження записів телефонної книги…" та створіть об’єкт MyPhoneBook і додайте до нього десять записів телефонних номерів. В кінці роботи метод повине виводити на консоль "OK!";
 * 5. Додайте до класу MyPhone метод call(int index), який виводить на консоль повідомлення "Виклик: "
 * і повну інформацію з об'єкта MyPhoneBook, розташованого у масиві за індексом index.
 * 6. Додайте до методу main() код, який створює об’єкт MyPhone, викликає метод swichOn(), а потім викликає метод call() зі значенням аргументу 1.
 * 7. Виконайте програму.
 * Приклад виведення програми:
 * Завантаження записів телефонної книги… OK!
 * Виклик: Ім'я: Борис, телефон: 0679878888
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class MyPhone {
    public static void main(String[] args) {
        MyPhone myPhone = new MyPhone();
        myPhone.switchOn();
        myPhone.call(4);
    }

    private MyPhoneBook phoneBook;

    public MyPhone() {
    }

    public void switchOn() {
        System.out.println("Завантаження записів телефонної книги…");
        MyPhoneBook phoneBook = new MyPhoneBook();

        phoneBook.addPhoneNumber("Борис", "0679878881");
        phoneBook.addPhoneNumber("Анна", "0681234562");
        phoneBook.addPhoneNumber("Сергій", "0679878883");
        phoneBook.addPhoneNumber("Дмитро", "0681234564");
        phoneBook.addPhoneNumber("Аліна", "0679878885");
        phoneBook.addPhoneNumber("Олег", "0681234566");
        phoneBook.addPhoneNumber("Ірина", "0679878887");
        phoneBook.addPhoneNumber("Ганна", "0681234568");
        phoneBook.addPhoneNumber("Андрій", "0679878889");
        phoneBook.addPhoneNumber("Олександр", "0681234560");

        this.phoneBook = phoneBook; // Зберігаємо телефонну книгу в полі класу
        System.out.println("OK!");
    }

    public void call(int index) {
        if (index >= 0 && index < phoneBook.currentNumber) {
            System.out.println("Виклик: " + phoneBook.getPhoneNumber(index));
        } else {
            System.out.println("Недійсний індекс");
        }
    }

    class MyPhoneBook {
        private final PhoneNumber[] phoneNumbers = new PhoneNumber[10]; // Масив для зберігання номерів телефонів
        private int currentNumber = 0;

        // Метод для додавання номеру телефону
        public void addPhoneNumber(String name, String phone) {
            if (currentNumber < phoneNumbers.length) {
                phoneNumbers[currentNumber] = new PhoneNumber(name, phone);
                currentNumber++;
            } else {
                System.out.println("Телефонна книга заповнена");
            }
        }

        // Метод для отримання інформації про номер за індексом
        public String getPhoneNumber(int index) {
            if (index >= 0 && index < currentNumber) {
                return "Ім'я: " + phoneNumbers[index].getName() + ", телефон: " + phoneNumbers[index].getPhone();
            } else {
                return "Недійсний індекс";
            }
        }
    }

    public static class PhoneNumber {
        private String name;
        private String phone;

        public PhoneNumber(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }
    }
}

