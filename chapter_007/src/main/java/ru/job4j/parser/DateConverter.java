package ru.job4j.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverter {
    public String dateConvert(String date) throws ParseException {
        String[] months = {"янв", "фев", "мар", "апр", "май", "июн", "июл", "авг", "сен", "окт", "ноя", "дек"};
        date = date.substring(0, date.indexOf(','));
        if (date.equals("вчера")) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
            calendar.setTime(sdf.parse(new Date().toString()));
            calendar.add(Calendar.DATE, -1);
            date = sdf.format(calendar.getTime());
        } else if (date.equals("сегодня")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
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
        SimpleDateFormat sdf = new SimpleDateFormat("yy");
        Date currentDate = new Date();
        String year = sdf.format(currentDate);
        String dateYear = date.substring(date.lastIndexOf('.') + 1, date.lastIndexOf('.') + 3);
        if (!year.equals(dateYear)) {
            result = false;
        }
        return result;
    }

}
