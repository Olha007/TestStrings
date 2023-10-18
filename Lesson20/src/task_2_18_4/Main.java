package task_2_18_4;

/**
 * 1. Розробіть програму, що виконує переклади довільного речення.
 * 2. Створіть клас Sentence з полем типу String для довільного речення англійською мовою.
 * 3. Додайте конструктор, який приймає відповідний параметр для встановлення значення поля класу Sentence.
 * 4. Додайте метод printSentence з параметром String language, який визначає мову, на якій речення повинно
 * виводитися до консолі. Використовуйте клас ResourceBundle з відповідними ресурсами для перекладу речення
 * на українську, німецьку, французьку та італійську мови.
 * 5. Додайте клас Main з методом main, у якому організуйте введення з консолі даних, що визначають мову
 * перекладу речення, та виведіть такий переклад на екран.
 * 6. Зазначте у документованому коментарі класів номер завдання, своє ім'я та прізвище.
 * <p>
 * * * @version 1.0
 * * * @author Olha Nozdriukhina
 */

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

class Sentence {
    private String sentence;

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public void printSentence(String language) {
        ResourceBundle bundle = ResourceBundle.getBundle("SentencesBundle", Locale.forLanguageTag(language));
        System.out.println(bundle.getString("sentence") + " " + sentence);
    }


    public static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть речення англійською:");
            String input = scanner.nextLine();
            System.out.println("Введіть мову для перекладу (українська, німецька, французька, італійська):");
            String language = scanner.nextLine();

            Sentence sentence = new Sentence(input);
            sentence.printSentence(language);
        }
    }
}

