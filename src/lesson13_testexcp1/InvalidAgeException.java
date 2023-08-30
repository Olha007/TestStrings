package lesson13_testexcp1;

public class InvalidAgeException extends Throwable {

    public InvalidAgeException() {
        super("Неприпустиме значення віку");
    }
}
