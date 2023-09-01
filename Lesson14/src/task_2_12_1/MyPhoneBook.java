package task_2_12_1;

public class MyPhoneBook {
    private final PhoneNumber[] phoneNumbers = new PhoneNumber[10]; // Масив для збереження номерів телефонів
    private int currentNumber = 0; // Змінна для відстеження поточного індексу

    // Метод для додавання номеру телефону
    public void addPhoneNumber(String name, String phone) {
        if (currentNumber < phoneNumbers.length) {
            phoneNumbers[currentNumber] = new PhoneNumber(name, phone);
            currentNumber++;
        } else {
            System.out.println("Phone book is full");
        }
    }

    // Метод для виведення інформації про всі номери телефонів
    public void printPhoneBook() {
        for (PhoneNumber phoneNumber : phoneNumbers) {
            if (phoneNumber != null) {
                System.out.println("Name: " + phoneNumber.getName() + ", Phone: " + phoneNumber.getPhone());
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

        @Override
        public String toString() {
            return "PhoneNumber{" +
                    "name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }
}

