package task_2_14_1;

/**
 * 1. Створіть новий пакет testgenerics.
 * 2. Створіть узагальнений клас MyTuple<A,B,C> із трьома полями різних типів, надайте конструктор із трьома параметрами
 * та геттерами для кожного поля.
 * 3. Створіть клас Main з методом main, який створює два об’єкти MyTuple. Перший має бути параметризований такими
 * типами: String, Integer, Long. Другий має бути параметризований такими типами: Double, String, String.
 * 4. Виконайте програму.
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class MyTuple<A, B, C> {

    private A first;
    private B second;
    private C third;

    public MyTuple(A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public C getThird() {
        return third;
    }

//    @Override
//    public String toString() {
//        return "MyTuple {" +
//                "first = " + first +
//                ", second = " + second +
//                ", third = " + third +
//                '}';
//    }
}

class Main {
    public static void main(String[] args) {

        MyTuple<String, Integer, Long> myTuple = new MyTuple<>("Hello", 1, 2L);
        MyTuple<Double, String, String> myTuple1 = new MyTuple<>(2.3, "Bye", "See you");
//        System.out.println(myTuple.toString());
        System.out.println("First: " + myTuple.getFirst());
        System.out.println("First: " + myTuple1.getFirst());
        System.out.println("Second: " + myTuple.getSecond());
        System.out.println("Second: " + myTuple1.getSecond());
    }
}
