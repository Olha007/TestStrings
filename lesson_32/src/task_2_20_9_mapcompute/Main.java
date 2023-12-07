package task_2_20_9_mapcompute;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Додайте пакет mapcompute.
 * 2. Додайте до пакету клас Main з методом main, у якому створіть програму для обробки колекції автомобілів:
 * Map<String, Car> cars = new HashMap<>();
 * cars.put("S123", new Car("Hyundai", "Excel"));
 * cars.put("S456", new Car("Buick", "Skylark"));
 * cars.put("S789", new Car("Toyota", "Prius"));
 * 3. За допомогою викликів методу merge інтерфейсу Map:
 * змініть виробника запису з ключем "S123" на "Chevy";
 * змініть модель запису з ключем "S123" на "Vega";
 * видаліть Toyota Prius з колекції.
 * 4. Після завершення операцій злиття роздрукуйте отриману колекцію.
 * <p>
 * * * @version 1.0
 * * * @author Olha Nozdriukhina
 */

public class Main {
    public static void main(String[] args) {
        Map<String, Car> cars = new HashMap<>();
        cars.put("S123", new Car("Hyundai", "Excel"));
        cars.put("S456", new Car("Buick", "Skylark"));
        cars.put("S789", new Car("Toyota", "Prius"));

        cars.merge("S123", new Car("Chevy", "Vega"), Car::mergeCars);

        // Видалення Toyota
        cars.remove("S789");

        System.out.println("Updated collection of cars:");
        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Producer: " + entry.getValue().manufacturer
                    + ", Model: " + entry.getValue().model);
        }
    }
}

class Car {
    String manufacturer;
    String model;

    public Car(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public static Car mergeCars(Car existingCar, Car newCar) {
        return new Car(newCar.manufacturer, existingCar.model);
    }
}
