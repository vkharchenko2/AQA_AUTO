package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtil {

    private static final String DATE_FORMAT_PATTERN_FOR_RESULTS_DATE = "M-dd-yyyy";
    private static final String DATE_FORMAT_PATTERN_FOR_DATE_PICKER = "dd MMMM yyyy";
    private static final String PM = "PM";
    private static final int HOURS_TO_ADD = 12;
    private static final int DAY_TO_ADD = 1;

    public static String timeFormat(String date, String hours, String minutes, String partOfTheDay) {
        if (partOfTheDay.equals(PM)) {
            hours = String.valueOf(Integer.parseInt(hours) + HOURS_TO_ADD);
        }
        return date + " " + hours + ":" + minutes;
    }

    public static String getTomorrowDateForResultsDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate tomorrowDate = currentDate.plusDays(DAY_TO_ADD);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN_FOR_RESULTS_DATE);
        return tomorrowDate.format(formatter);
    }

    public static String getTomorrowDateForDatePicker() {
        LocalDate currentDate = LocalDate.now();
        LocalDate tomorrowDate = currentDate.plusDays(DAY_TO_ADD);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN_FOR_DATE_PICKER).withLocale(Locale.ENGLISH);
        return tomorrowDate.format(formatter);
    }
}
