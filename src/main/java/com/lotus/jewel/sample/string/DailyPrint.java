package com.lotus.jewel.sample.string;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class DailyPrint {

    LocalDateTime t;

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();


        String div = "=".repeat(10);

        System.out.println("//" + div.repeat(10));
        System.out.println("//===== " + getDay(today, DayOfWeek.MONDAY) + " " + getDay(today, DayOfWeek.FRIDAY));
        System.out.println("//" + div.repeat(10));

        printWorkday(today, DayOfWeek.MONDAY);

        printWorkday(today, DayOfWeek.TUESDAY);

        printWorkday(today, DayOfWeek.WEDNESDAY);

        printWorkday(today, DayOfWeek.THURSDAY);

        printWorkday(today, DayOfWeek.FRIDAY);

    }

    public static void printWorkday(LocalDate date, DayOfWeek dayOfWeek){
        String tail = " " + "-".repeat(30);
        LocalDate getDay = getNextDay(date, dayOfWeek);
        System.out.println(getDay.toString() + tail);

        String korDayOfWeek = "";
        switch (dayOfWeek) {
            case MONDAY:
                korDayOfWeek = "월";
                break;
            case TUESDAY:
                korDayOfWeek = "화";
                break;
            case WEDNESDAY:
                korDayOfWeek = "수";
                break;
            case THURSDAY:
                korDayOfWeek = "목";
                break;
            case FRIDAY:
                korDayOfWeek = "금";
                break;
            default:
                break;
        }

        System.out.println("\uD83D\uDCBE " + korDayOfWeek+ "요일"+ "\r\n");
    }

    public static String getDay(LocalDate today, DayOfWeek dayOfWeek) {
        LocalDate localDate = getNextDay(today, dayOfWeek);
        Month month = localDate.getMonth();
        int dayOfMonthOfMonday = localDate.getDayOfMonth();
        return month.getValue() + ":" + dayOfMonthOfMonday;
    }

    public static LocalDate getNextDay(LocalDate date, DayOfWeek dayOfWeek) {
        return date.with(TemporalAdjusters.next(dayOfWeek));
    }

}
