package task_2_19_3;

/**
 * 1. Створіть пакет, у якому створіть клас круглого отвору RoundHole із приватним полем double radius. Додайте до класу
 * параметризований конструктор і геттер.
 * 2. Додайте до класу RoundHole метод boolean fits(RoundPeg peg), який повертає значення true, якщо радіус екземпляра
 * RoundHole >= радіусу екземпляра RoundPeg.
 * 3. Створіть клас круглого кілочка RoundPeg із приватним полем double radius. Додайте до класу конструктор за замовчуванням,
 * параметризований конструктор і геттер.
 * 4. Створіть клас квадратного кілочка SquarePeg (несумісного з круглою діркою) із приватним полем double width. Додайте до
 * класу параметризований конструктор і геттер.
 * 5. Створіть клас SquarePegAdapter, який успадковує RoundPeg та перевизначає його геттер, повертаючи розмір діагоналі
 * перерізу квадратного кілочка.
 * 6. Додайте до пакету клас Main з методом main, у якому створіть екземпляр RoundHole з радіусом=5. Переконайтеся, що
 * круглі кілки такого ж і меншого радіусу входять у отвір.
 * 7. Створіть два квадратних кілочка, ширина яких менша та більша за радіус отвору. Спробуйте перевірити передаючи їх
 * методу boolean fits(RoundPeg peg), чи входять вони у круглий отвір, зробіть висновок.
 * 8. Огорніть квадратні кілочки адапетром та повторно перевірте, чи підходять вони до отвору.
 * 9. За допомогою Visual Paradigm згенеруйте діаграму класів для цієї програми.
 * 10. Зазначте у документованому коментарі класів номер завдання, своє ім'я та прізвище.
 * <p>
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class RoundHole {
    private double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(RoundPeg peg) {
        return this.radius >= peg.getRadius();
    }
}

class RoundPeg {
    private double radius;

    public RoundPeg() {
        this.radius = 0;
    }

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class SquarePeg {
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }
}

class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        return peg.getWidth() * Math.sqrt(2);
    }
}

class Main {
    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole(5);

        RoundPeg smallRoundPeg = new RoundPeg(3);
        RoundPeg largeRoundPeg = new RoundPeg(6);

        System.out.println("Small round peg fits: " + roundHole.fits(smallRoundPeg));
        System.out.println("Large round peg fits: " + roundHole.fits(largeRoundPeg));

        SquarePeg smallSquarePeg = new SquarePeg(4);
        SquarePeg largeSquarePeg = new SquarePeg(7);

        System.out.println("Small square peg fits: " + roundHole.fits(new SquarePegAdapter(smallSquarePeg)));
        System.out.println("Large square peg fits: " + roundHole.fits(new SquarePegAdapter(largeSquarePeg)));
    }
}

