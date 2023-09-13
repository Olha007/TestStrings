package task_2_15_6;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 1. Створіть клас MyTranslator із приватним полем dictionary типу HashMap<String,String>.
 * 2. Додайте метод addNewWord(String en, String uk), який додає до "словника" нове слово двома мовами.
 * 3. Додайте метод translate(String en), який приймає деякий рядок англійською мовою та повертає цей текст,
 * перекладений на українську мову.
 * 4. Створіть клас Main з методом main(), у коді якого створіть екземпляр MyTranslator. Додайте код для заповнення
 * MyTranslator кількома парами слів en-uk, викликавши метод addNewWord.
 * Наприклад:
 * "cat", "кіт"
 * "mouse", "мишу"
 * …
 * 5. Додайте код для читання рядка з консолі, який передається до методу перекладу. Додайте код для виведення результату
 * методу перекладу на консоль.
 * 6. Виконайте програму. Введіть рядок, що містить введені до словника слова, англійською мовою.
 * Результат програми повинен бути таким, як у наступному прикладі:
 * cat caught mouse
 * кіт зловив мишу
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */
class MyTranslator {
    private HashMap<String, String> dictionary;

    public MyTranslator() {
        dictionary = new HashMap<>();
    }

    public void addNewWord(String en, String uk) {
        dictionary.put(en, uk);
    }

    public String translate(String en) {
        return dictionary.get(en);
    }
}

class Main {
    public static void main(String[] args) {
        MyTranslator translator = new MyTranslator();

        // Додавання слів до словника
        translator.addNewWord("cat", "кіт");
        translator.addNewWord("caught", "зловив");
        translator.addNewWord("mouse", "мишу");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть рядок англійською мовою:");

        String input = scanner.nextLine();
        String[] words = input.split(" ");

        for (String word : words) {
            String ukTranslation = translator.translate(word);
            if (ukTranslation != null) {
                System.out.print(ukTranslation + " ");
            } else {
                // Якщо переклад не знайдено, виводимо оригінальне слово
                System.out.print(word + " ");
            }
        }

        scanner.close();
    }
}
