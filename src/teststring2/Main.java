package teststring2;

/**
 * 1. До проекту TestStrings додайте пакет teststring2.
 * 2. Створіть клас Main з методом main, у методі main оголосіть дві локальні змінні myStr1 та myStr2 типу String та
 * призначте значення "Cartoon" для першого рядка та "Tomcat" для другого.
 * 3. Напишіть код, що виводить на консоль всі букви, які є у першому слові, але відсутні у другому.
 * 4. Зазначте у документованому коментарі класу та методу їх призначення, у документованому коментарі класу -
 * номер завдання, а також своє ім'я та прізвище.
 * <p>
 * * @version 1.0
 * * @autor Olha Nozdriukhina
 */

public class Main {
    public static void main(String[] args) {

        String mySrt1 = "Cartoon";
        String mySrt2 = "TomCat";

        //Для кожної букви ми використовуємо метод indexOf для перевірки, чи присутня ця буква у рядку myStr2
        // Якщо indexOf повертає -1, означає що буква відсутня у другому рядку і виводимо її на консоль
        for (char letters : mySrt1.toCharArray()) {
            if (mySrt2.indexOf(letters) == -1) {
                System.out.println("" + letters);
            }
        }
    }
}
