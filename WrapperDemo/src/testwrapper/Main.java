package testwrapper;

/**
 * 1. Створіть новий проект під назвою WrapperDemo. Додайте до нього пакет testwrapper.
 * 2. Створіть клас Main з методом main, у якому оголосіть декілька локальних змінних xN класу Integer та ініціалізуйте
 * їх однаковим значенням (менше 128), але різними способами:
 * - заданням значення-літерала;
 * - заданням значення через параметр конструктора;
 * - заданням значення через параметр метода valueOf;
 * - заданням значення парсингом рядка з відповідними цифровими символами.
 * 3. Порівняйте ці змінні кожну з кожною за допомогою == та метода equals і виведіть результат на консоль.
 * 4. Оголосіть локальні змінні такими ж способами, але для значення більше 128 і порівняйте їх кожну з кожною за
 * допомогою == та метода equals і виведіть результат на консоль.
 * *
 * * @version 1.0
 * * @autor Olha Nozdriukhina
 */

public class Main {
    public static void main(String[] args) {

        Integer x1 = 99;
        //Integer x2 = new Integer(99);
        Integer x3 = Integer.valueOf(99);
        Integer x4 = Integer.parseInt("99");

        System.out.println("x1 == x3: " + (x1 == x3));
        System.out.println("x1 == x4: " + (x1 == x4));
        System.out.println("x3 == x4: " + (x3 == x4));

        // Порівняння через метод equals
        System.out.println("x1.equals(x3): " + x1.equals(x3));
        System.out.println("x1.equals(x4): " + x1.equals(x4));
        System.out.println("x3.equals(x4): " + x3.equals(x4));
        System.out.println();

        Integer y1 = 129;
        //Integer y2 = new Integer(129);
        Integer y3 = Integer.valueOf(129);
        Integer y4 = Integer.parseInt("129");

        // Порівняння через оператор ==
        System.out.println("y1 == y3: " + (y1 == y3));
        System.out.println("y1 == y4: " + (y1 == y4));
        System.out.println("y3 == y4: " + (y3 == y4));

        // Порівняння через метод equals
        System.out.println("y1.equals(y3): " + y1.equals(y3));
        System.out.println("y1.equals(y4): " + y1.equals(y4));
        System.out.println("y3.equals(y4): " + y3.equals(y4));
    }
}
