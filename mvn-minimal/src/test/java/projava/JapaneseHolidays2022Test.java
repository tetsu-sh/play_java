package projava;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class JapaneseHolidays2022Test {
    @Test
    public void testIsSummerOlympicYear_近代オリンピック開始以前() {
        assertFalse(new JapaneseHolidays2022().isSummerOlympicYear(1888));
        assertFalse(new JapaneseHolidays2022().isSummerOlympicYear(1892));
        assertFalse(new JapaneseHolidays2022().isSummerOlympicYear(1895));
        assertTrue(new JapaneseHolidays2022().isSummerOlympicYear(1896));
    }

    @Test
    void testIsSummerOlympicYear_一般的な開催年() {
        int[] years = {1900, 1920, 1964, 1936, 2000};
        for (int year : years) {
            assertTrue(new JapaneseHolidays2022().isSummerOlympicYear(year));
        }
    }

    @Test
    void 四年周期から外れる非開催年() {
        int[] years = {1905, 1907, 1925, 1967, 2001};
        for (int year : years) {
            assertFalse(new JapaneseHolidays2022().isSummerOlympicYear(year));
        }
    }

    @Test
    void 戦争またはパンデミックで中止となった年() {
        int[] years = {1916, 1940, 1944, 2020};
        for (int year : years) {
            System.out.println(new JapaneseHolidays2022().isSummerOlympicYear(year));
            assertFalse(new JapaneseHolidays2022().isSummerOlympicYear(year));
        }
    }

    @Test
    void 四年間隔ではない例外的な開催年() {
        // 新型コロナウイルスにより延期開催
        assertTrue(new JapaneseHolidays2022().isSummerOlympicYear(2021));
    }

    @Test
    void 境界値上限() {
        assertDoesNotThrow(() -> new JapaneseHolidays2022().isSummerOlympicYear(2031));
        assertDoesNotThrow(() -> new JapaneseHolidays2022().isSummerOlympicYear(2032));
        // 開催が決定している2032年より後は例外発生
        assertThrows(IllegalArgumentException.class,
                () -> new JapaneseHolidays2022().isSummerOlympicYear(2033));
        assertThrows(IllegalArgumentException.class,
                () -> new JapaneseHolidays2022().isSummerOlympicYear(2054));
    }
}
