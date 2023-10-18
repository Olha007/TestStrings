package task_2_19_1;

/**
 * 1. Створіть пакет, у якому створіть клас ConfigSingleton з ранньою статичною ініціалізацією, який буде містити поле Properties props, у яке у конструкторі ConfigSingleton зчитуються з текстового файлу дані конфігурації: host=localhost та port=8080.
 * 2. Передбачте у класі ConfigSingleton метод String getProperty(String key), який буде повертати значення по ключу-параметру або генерувати RuntimeException із відповідним повідомленням у разі відсутності ключа-параметра у файлі з даними конфігурації.
 * 3. Додайте до пакету клас Main1 з методом main, у якому отримайте об'єкт-сінглетон, виведіть на екран його хєш-код та значення конфігураційних параметрів host та port.
 * 4. Виконайте копіювання за допомогою рефакторингу класу Main1 у клас з іменем Main2.
 * 5. Додайте до методу main класу Main1 код, який призупинить виконання методу на 30 секунд:
 * Thread.currentThread().sleep(30000);
 * 6. Запустіть на виконання метод main класу Main1.
 * 7. За час, що не пепебільшує 30 секунд, запустіть паралельно на виконання метод main класу Main2.
 * 8. Спостерігайте виведення даних у консоль методами обох класів. Зробіть висновок з результатів роботи програми.
 * 9. За допомогою Visual Paradigm згенеруйте діаграму класів для цієї програми.
 * <p>
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigSingleton {
    private static final ConfigSingleton instance = new ConfigSingleton();
    private Properties props = new Properties();

    private ConfigSingleton() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/olhanozdriukhina/IdeaProjects/TestStrings/Lesson22/src/task_2_19_1/config.txt"));
            props.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigSingleton getInstance() {
        return instance;
    }

    public String getProperty(String key) {
        String value = props.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property not found for key: " + key);
        }
        return value;
    }
}

