package task_2_18_6;

/**
 * 1. Створіть програму, що розраховує різницю між двома датами у різних одиницях вимірювання.
 * 2. Додайте клас Main з методом main, у якому створіть два екземпляри LocalDateTime із різними значеннями дати та часу.
 * 3. Обчисліть період (Period) та тривалість (Duration) між цими екземплярами.
 * 4. Обчисліть кількість років, місяців, днів, годин, хвилин і секунд між цими екземплярами.
 * 5. ВИведіть результати розрахунків на екран.
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

public class DateDifferenceCalculator {
    public static void main(String[] args) {
        LocalDateTime dateTime1 = LocalDateTime.of(2023, 10, 15, 12, 30, 40);
        LocalDateTime dateTime2 = LocalDateTime.of(2022, 8, 20, 10, 15, 30);

        Period period = Period.between(dateTime2.toLocalDate(), dateTime1.toLocalDate());
        Duration duration = Duration.between(dateTime2, dateTime1);

        long years = period.getYears();
        long months = period.getMonths();
        long days = period.getDays();

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        System.out.println("Різниця в періоді: " + years + " років, " + months + " місяців, " + days + " днів");
        System.out.println("Різниця в тривалості: " + hours + " годин, " + minutes + " хвилин, " + seconds + " секунд");
    }
}

