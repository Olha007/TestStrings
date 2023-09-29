package task_2_16_4;

/**
 1. Створіть клас Animal, його нащадка - клас Dog і нащадка класу Dog - клас Puppy.
 2. Створіть клас Main з методами: void foo(Animal a), void foo(Dog d) та void foo(Puppy p).
 Вони повинні виводити до консолі «Animal», «Dog» або «Puppy», відповідно.
 3. Додайте до класу Main методом main(), у коді якого організуйте виклик метода foo з аргументом null.
 4. Запустіть програму.
 5. Поясніть коментарями, як був обраний перевантажений метод у кожному з випадків.
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

class Animal {
}

class Dog extends Animal {
}

class Puppy extends Dog {
}

class Main {
    void foo(Animal a) {
        System.out.println("Animal");
    }

    void foo(Dog d) {
        System.out.println("Dog");
    }

    void foo(Puppy p) {
        System.out.println("Puppy");
    }

    public static void main(String[] args) {
        Main main = new Main();

        // Виклик метода foo з аргументом null
        Animal animal = null;
        Dog dog = null;
        Puppy puppy = null;

        main.foo(animal);
        main.foo(dog);
        main.foo(puppy);
    }
}

