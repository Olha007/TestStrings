package task_2_18_5;

/**
 * 1. Розробіть програму, що розраховує місцевий час вильоту та прибуття рейсу літака.
 * 2. Створіть клас Flight з полями для назви міста відправлення, дати та часу відправлення типу ZonedDateTime, назви міста прибуття та тривалості рейсу типу Duration.
 * 3. Додайте конструктор, який приймає відповідні параметри для встановлення значень полів класу Flight.
 * 4. Додайте метод calculateArrivalTime з параметром String arrivalZoneId, який обчислює час прибуття рейсу як змінну типу
 * ZonedDateTime.
 * 5. Додайте клас Main з методом main, у якому  розрахуйте місцевий час прибуття для рейсу з Києва до Нью-Йорка, який триває
 * 12 годин 10 хвилин і вилітає сьогодні о 6:35 за Київським часом. Виведіть результат на консоль.
 * *
 * * @version 1.0
 * * @author Olha Nozdriukhina
 */

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

class Flight {
    private String departureCity;
    private ZonedDateTime departureDateTime;
    private String arrivalCity;
    private Duration duration;

    public Flight(String departureCity, ZonedDateTime departureDateTime, String arrivalCity, Duration duration) {
        this.departureCity = departureCity;
        this.departureDateTime = departureDateTime;
        this.arrivalCity = arrivalCity;
        this.duration = duration;
    }

    public ZonedDateTime calculateArrivalTime(String arrivalZoneId) {
        ZoneId zoneId = ZoneId.of(arrivalZoneId);
        return this.departureDateTime.plus(this.duration).withZoneSameInstant(zoneId);
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating the ZonedDateTime for departure
        ZonedDateTime departureTime = ZonedDateTime.of(
                LocalDateTime.of(2023, 10, 17, 6, 35),
                ZoneId.of("Europe/Kiev")
        );

        // Creating the flight instance
        Flight flight = new Flight("Kyiv", departureTime, "New York",
                Duration.ofHours(12).plusMinutes(10));

        // Calculating the arrival time
        ZonedDateTime arrivalTime = flight.calculateArrivalTime("America/New_York");

        // Printing the result
        System.out.println("Departure time: " + flight.calculateArrivalTime("Europe/Kiev"));
        System.out.println("Arrival time: " + arrivalTime);
    }
}



