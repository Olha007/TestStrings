package task_2_12_4;

/**
 * 1. Створіть клас Outer.
 * 2. Створіть інтерфейс Anonymous з одним абстрактним методом someMeth().
 * 3. Розмістіть у класі Outer статичний вкладений клас з ім'ям Nested, внутрішній клас-член з ім'ям Inner, метод myMeth1,
 * у якому оголосіть локальний внутрішній клас з ім'ям Local, та метод myMeth2, у якому створіть анонімний внутрішній клас,
 * що реалізує довільним чином інтерфейс Anonymous.
 * 4. Виконайте компіляцію Outer.
 * 5. Додайте коментарі до оголошення вкладених/внутрішніх класів та методу, у якому створений анонімний клас, з іменами
 * файлів скомпільованих вкладених/внутрішніх класів.
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

interface Anonymous {

    void someMeth();
}

public class Outer {

    static class Nested {
    }

    // Внутрішній клас-член
    class Inner {
    }

    // Метод, що містить локальний внутрішній клас
    void myMeth1() {
        class Local {
        }

        // Використання локального внутрішнього класу
        Local local = new Local();
    }

    void myMeth2() {
        Anonymous anonymous = new Anonymous() {
            @Override
            public void someMeth() {
                System.out.println("Anonymous inner class implementing someMeth()");
            }
        };

        anonymous.someMeth();
    }
}
