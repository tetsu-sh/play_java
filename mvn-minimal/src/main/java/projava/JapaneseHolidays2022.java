package projava;

import static one.cafebabe.bc4j.BusinessCalendar.JAPAN;
import java.time.LocalDate;
import java.util.List;
import one.cafebabe.bc4j.BusinessCalendar;

public class JapaneseHolidays2022 {


    /**
     * is the year a summer Olympic year?
     * 
     * @param year
     * @return true if the year is a summer Olympic year
     * @throws IllegalArgumentException
     */
    public boolean isSummerOlympicYear(int year) throws IllegalArgumentException {
        List<Integer> unUsualNotyears = List.of(1916, 1940, 1944, 2020);
        List<Integer> unUsualyears = List.of(2021);
        if (year > 2032) {
            throw new IllegalArgumentException("Year must be shorter than 2032");
        }
        if (unUsualNotyears.stream().anyMatch((v) -> v == year)) {
            return false;
        }
        if (unUsualyears.stream().anyMatch((v) -> v == year)) {
            return true;
        }
        if (year < 1896) {
            return false;
        }
        String ten = "10";
        int a = Integer.valueOf(ten);
        return year % 4 == 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        BusinessCalendar.newBuilder().holiday(JAPAN.PUBLIC_HOLIDAYS).build()
                .getHolidaysBetween(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 31))
                .forEach((v) -> System.out.println(v));
    }
}
