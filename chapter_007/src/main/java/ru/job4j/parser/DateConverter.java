package ru.job4j.parser;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverter {
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
    public String dateConvert(String date) {
        String[] months = {"янв", "фев", "мар", "апр", "май", "июн", "июл", "авг", "сен", "окт", "ноя", "дек"};
        date = date.substring(0, date.indexOf(','));
        if (date.equals("вчера")) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            date = sdf.format(new Date(cal.getTimeInMillis()));
        } else if (date.equals("сегодня")) {
            Date currentDate = new Date();
            date = sdf.format(currentDate);
        } else {
            int dayIndex = date.indexOf(' ') + 1;
            int yearIndex = date.lastIndexOf(' ') + 1;
            String month = date.substring(dayIndex, yearIndex - 1);
            for (int i = 0; i < months.length; i++) {
                if (month.equals(months[i])) {
                    month = (i + 1 > 9) ? (i + 1 + "") : ("0" + (i + 1));
                    break;
                }
            }
            String day = date.substring(0, dayIndex - 1);
            day = day.length() < 2 ? "0" + day : day;
            date = day + "." + month + "." + date.substring(yearIndex, yearIndex + 2);
        }
        return date;
    }

    public boolean dateCheck(String date) {
        boolean result = true;
        SimpleDateFormat sdfYear = new SimpleDateFormat("yy");
        Date currentDate = new Date();
        String year = sdfYear.format(currentDate);
        String dateYear = date.substring(date.lastIndexOf('.') + 1, date.lastIndexOf('.') + 3);
        if (!year.equals(dateYear)) {
            result = false;
        }
        return result;
    }

}
