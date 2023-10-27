package task_2_19_2;

/**
 * 1. Створіть пакет, у якому створіть клас Pizza з інкапсульованими полями типу boolean можливих інгредієнтів:
 * основа, сир, соус, пепероні, гриби, ананас та курка.
 * 2. Додайте до класу Pizza відповідні сеттери та метод toString().
 * 3. Розробіть клас PizzaBuilder, що створює у методі void createPizza() піццу з обов'язкових інгредієнтів: основа,
 * сир та соус і зберігає посилання на неї в своєму protected полі Pizza pizza.
 * 4. Розробіть класи-спадкоємці PizzaBuilder - HawaiiPizzaBuilder та MontanaraPizzaBuilder, які перевизначають метод
 * void createPizza(), додаючи до піцци ананас та курку і пепероні та гриби, відповідно.
 * 5. Розробіть клас PizzaBaker з інкапсульованим полем PizzaBuilder pizzaBuilder та методом Pizza makePizza(), що
 * повертає піццу, створену за допомогою pizzaBuilder.
 * 6. Додайте до пакету клас Main з методом main, у якому створіть та виведіть на екран інгредієнти двох піц, які
 * створені об'єктами HawaiiPizzaBuilder та MontanaraPizzaBuilder, відповідно.
 * 7. За допомогою Visual Paradigm згенеруйте діаграму класів для цієї програми.
 * <p>
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class Pizza {
    private boolean base;
    private boolean cheese;
    private boolean sauce;
    private boolean pepperoni;
    private boolean mushrooms;
    private boolean pineapple;
    private boolean chicken;

    public Pizza() {
    }

    public void setBase(boolean base) {
        this.base = base;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public void setSauce(boolean sauce) {
        this.sauce = sauce;
    }

    public void setPepperoni(boolean pepperoni) {
        this.pepperoni = pepperoni;
    }

    public void setMushrooms(boolean mushrooms) {
        this.mushrooms = mushrooms;
    }

    public void setPineapple(boolean pineapple) {
        this.pineapple = pineapple;
    }

    public void setChicken(boolean chicken) {
        this.chicken = chicken;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "base=" + base +
                ", cheese=" + cheese +
                ", sauce=" + sauce +
                ", pepperoni=" + pepperoni +
                ", mushrooms=" + mushrooms +
                ", pineapple=" + pineapple +
                ", chicken=" + chicken +
                '}';
    }
}

// Клас PizzaBuilder
class PizzaBuilder {
    protected Pizza pizza;

    public PizzaBuilder() {
        this.pizza = new Pizza();
        this.pizza.setBase(true);
        this.pizza.setCheese(true);
        this.pizza.setSauce(true);
    }

    public PizzaBuilder addPepperoni() {
        this.pizza.setPepperoni(true);
        return this;
    }

    public PizzaBuilder addMushrooms() {
        this.pizza.setMushrooms(true);
        return this;
    }

    public PizzaBuilder addPineapple() {
        this.pizza.setPineapple(true);
        return this;
    }

    public PizzaBuilder addChicken() {
        this.pizza.setChicken(true);
        return this;
    }

    public Pizza build() {
        return this.pizza;
    }
}

// HawaiiPizzaBuilder
class HawaiiPizzaBuilder extends PizzaBuilder {
    public HawaiiPizzaBuilder() {
        super();
    }

    @Override
    public HawaiiPizzaBuilder addPineapple() {
        this.pizza.setPineapple(true);
        return this;
    }

    @Override
    public HawaiiPizzaBuilder addChicken() {
        this.pizza.setChicken(true);
        return this;
    }

    @Override
    public Pizza build() {
        return this.pizza;
    }
}

// MontanaraPizzaBuilder
class MontanaraPizzaBuilder extends PizzaBuilder {
    public MontanaraPizzaBuilder() {
        super();
    }

    @Override
    public MontanaraPizzaBuilder addPepperoni() {
        this.pizza.setPepperoni(true);
        return this;
    }

    @Override
    public MontanaraPizzaBuilder addMushrooms() {
        this.pizza.setMushrooms(true);
        return this;
    }

    @Override
    public Pizza build() {
        return this.pizza;
    }
}

// Клас PizzaBaker
class PizzaBaker {
    private PizzaBuilder pizzaBuilder;

    public PizzaBaker(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public Pizza makePizza() {
        return this.pizzaBuilder.build();
    }
}

// Клас Main
class Main {
    public static void main(String[] args) {
        HawaiiPizzaBuilder hawaiiPizzaBuilder = new HawaiiPizzaBuilder();
        MontanaraPizzaBuilder montanaraPizzaBuilder = new MontanaraPizzaBuilder();

        PizzaBaker pizzaBaker1 = new PizzaBaker(hawaiiPizzaBuilder.addPineapple().addChicken());
        PizzaBaker pizzaBaker2 = new PizzaBaker(montanaraPizzaBuilder.addMushrooms());

        System.out.println("Ingredients for Hawaii Pizza: ");
        System.out.println(pizzaBaker1.makePizza());

        System.out.println("Ingredients for Montanara Pizza: ");
        System.out.println(pizzaBaker2.makePizza());
    }
}





