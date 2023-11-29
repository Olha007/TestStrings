package task_2_20_8_suppliers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

/**
 * 1. Додайте пакет suppliers.
 * 2. Додайте до пакету клас Main з методом main, у якому створіть програму для опитування покупців щодо задоволення
 * придбаним товаром та якістю обслуговування. Питання опитування та місце для відповідей зберігайте у колекції:
 * Map<String, String> survey = new LinkedHashMap();
 * survey.put("Did you like our product?", "");
 * survey.put("Did you like our service?", "");
 * survey.put("Will you buy from us in the future?", "");
 * 3. Передбачте можливі відповіді опитуваного - односимвльні рядки (у будь-якому регістрі): "y" - у разі задовлення,
 * "n" - у разі незадоволення, організація введення яких з консолі забезпечується об'єктом Supplier<String>.
 * 5. Об'єкт Supplier<String> повинен перевіряти введені рядки, виводити повідомлення у разі введення непередбачуваних
 * символів та пропонувати введення ще раз.
 * 6. Також об'єкт Supplier<String> повинен дозволяти переривати опитування у будь-який момент введенням односимвольного
 * рядка "q" (у будь-якому регістрі).
 * 7. Функціонал отриманя та аналізу відповідей реалізуйте у методі getSurvey, який приймає колекцію з питаннями
 * опитування та сапплайер, а повертає колекцію з заповненими відповідями.
 * 8. Використовуйте посилання на методи замість лямбда виразів, якщо це доцільно.
 * 9. У методі main використайте метод getSurvey та виведіть на консоль колекцію з результатами опитування.
 * <p>
 * * * @version 1.0
 * * * @author Olha Nozdriukhina
 */

public class Main {
    public static void main(String[] args) {
        Map<String, String> survey = new LinkedHashMap();
        survey.put("Did you like our product?", "");
        survey.put("Did you like our service?", "");
        survey.put("Will you buy from us in the future?", "");


        Supplier<String> inputSupplier = Main::getUserInput;

        survey = getSurvey(survey, inputSupplier);

        survey.forEach((question, answer) -> System.out.println(question + " Your answer: " + answer));
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.matches("[ynq]")) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter 'y', 'n', or 'q' to quit.");
            }
        }
    }

    private static Map<String, String> getSurvey(Map<String, String> survey, Supplier<String> inputSupplier) {
        for (Map.Entry<String, String> entry : survey.entrySet()) {
            System.out.println(entry.getKey());
            String response = inputSupplier.get();
            if ("q".equals(response)) {
                break;
            }
            entry.setValue(response);
        }
        return survey;
    }
}
