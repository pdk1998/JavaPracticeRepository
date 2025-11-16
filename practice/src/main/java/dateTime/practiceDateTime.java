package dateTime;

import java.time.*;

public class practiceDateTime {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2018, 10, 10);
        System.out.println("Original date: " + date);

        // Add 2 days
        LocalDate newDate = date.plusDays(2);
        System.out.println("After plusDays(2): " + newDate);

    }
}
