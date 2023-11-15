package task_2_17_8_testcountdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 1. Додайте пакет testcountdownlatch, у якому будуть розташовані класи програми-симулятора організації відеоконференції
 * декількох учасників. Конференція повинна розпочатися після підключення усіх запланованих учасників.
 * 2. Створіть клас під назвою Videoconference, який реалізує інтерфейс Runnable, із полем controller типу CountDownLatch.
 * Реалізуйте конструктор, який ініціалізує поле CountDownLatch створенням засувки зі зворотнім відліком із заданням
 * кількості відліків, яка дорівнює кількості учасників конференції, що буде задана через параметр конструктора.
 * 3. Додайте до класу Videoconference метод arrive(String name), що отримує ім'я учасника конференції як параметр.
 * У цьому методі виведіть на консоль повідомлення про підключення учасника з вказаним ім'ям, потім виконайе зменшення
 * відліку засувки CountDownLatch і нарешті, він виведіть повідомлення з кількістю учасників, прибуття яких ще очікується.
 * 4. Напишіть у класі Videoconference реалізацію методу run(), у якому виведіть на консоль початкове значення засувки
 * і організуйе за її допомогою очікування під'ключння учасників. Після підключення усіх учасників виведіть повідомлення
 * про початок конференції.
 * 5. Створіть клас Participant, що представляє кожного учасника відеоконференції. Цей клас реалізує інтерфейс Runnable
 * та містить рядкове поле name та поле типу Videocoference. Реалізуйте конструктор класу, який ініціалізує обидва поля.
 * 6. Реалізуйте метод run() класу Participant. Спочатку переведіть потік у режим сну на випадковий проміжок часу (від
 * 2 до 10 секунд). Потім скористайтеся методом arrive() об’єкта Videoconference, щоб вказати прибуття цього учасника.
 * 7. Створіть клас Main з методом main(), у якому створіть об’єкт відеоконференції з 10 учасниками, поток для цього
 * об'єкту та запустіть цей поток.
 * 8. Даль у методі main() у циклі створіть 10 об’єктів-учасників конференції, відповідні потоки для них та запустіть усі потоки.
 * 9. Виконайте програму.
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

public class Videoconference implements Runnable {
    private final CountDownLatch controller;

    public Videoconference(int participants) {
        this.controller = new CountDownLatch(participants);
    }

    public void arrive(String name) {
        System.out.println(name + " has arrived.");
        controller.countDown();
        System.out.println("Remaining participants to arrive: " + controller.getCount());
    }

    public void run() {
        System.out.println("Video conference is starting. Number of participants: " + controller.getCount());
        try {
            controller.await();
            System.out.println("All participants have arrived. The conference can now begin.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Participant implements Runnable {
    private final String name;
    private final Videoconference conference;

    public Participant(String name, Videoconference conference) {
        this.name = name;
        this.conference = conference;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 8000 + 2000));
            conference.arrive(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Main {
    public static void main(String[] args) {
        Videoconference conference = new Videoconference(10);
        Thread conferenceThread = new Thread(conference);
        conferenceThread.start();

        for (int i = 0; i < 10; i++) {
            Participant participant = new Participant("Participant " + (i + 1), conference);
            Thread participantThread = new Thread(participant);
            participantThread.start();
        }
    }
}


