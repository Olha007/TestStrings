package lesson13_testexcp1;

public class Main {
    public static void main(String[] args) {

        try {
            Person person = new Person("Nik", "Nilons", 32);
            System.out.println("Name " + person.getFirstName());
            System.out.println("Last name " + person.getLastName());
            System.out.println("Age " + person.getAge());

            person.setAge(123);
        } catch (InvalidAgeException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
