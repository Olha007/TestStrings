package task_2_18_7;

/**
 * 1. Створіть пакет, у якому створіть наступні класи/інтерфейси:
 * Інтерфейс Moveable з абстрактним методом void move();
 * Клас Car, який імплементує інтерфейс та має властивості String model, int speed та масив об'єктів Door у кількості 4 шт,
 * Клас Engine з полем double volume, який є нестатичним внутрішнім класом Car.
 * Клас SportCar, який успадковує клас Car, але має масив об'єктів Door у кількості 2 шт,
 * Клас Door з полем String name,
 * Клас ServiceCenter зі статичним методом boolean register(Car car) реєстрації автомобілів.
 * 2. Додайте клас Main з методом main, у якому створіть по одному об'єкту Car та SportCar та виконайте їх реєстрацію.
 * 3. За допомогою Visual Paradigm побудуйте діаграму класів для класів/інтерфейсів пакету та збережіть її до графічного файлу.
 * 4. Зазначте у документованому коментарі класів номер завдання, своє ім'я та прізвище.
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

// У файлі Moveable.java
interface Moveable {
    void move();
}

// У файлі Car.java
class Car implements Moveable {
    String model;
    int speed;
    Door[] doors = new Door[4];

    @Override
    public void move() {
        System.out.println("Car is moving.");
    }

    public class Engine {
        double volume;
    }
}

// У файлі SportCar.java
class SportCar extends Car {
    Door[] doors = new Door[2];
}

// У файлі Door.java
class Door {
    String name;
}

// У файлі ServiceCenter.java
class ServiceCenter {
    public static boolean register(Car car) {
        System.out.println("Car is registered.");
        return true;
    }
}

// У файлі Main.java
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        SportCar sportCar = new SportCar();
        ServiceCenter.register(car);
        ServiceCenter.register(sportCar);
    }
}
