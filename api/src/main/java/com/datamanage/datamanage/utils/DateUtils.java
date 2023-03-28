package com.datamanage.datamanage.utils;


import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 贾佳
 * @date 2023/3/28 21:25
 */
public class DateUtils {
    public static List<String> getYearMonths(String startDate, String endDate) throws IllegalArgumentException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        List<String> yearMonths = new ArrayList<>();

        try {
            YearMonth start = YearMonth.parse(startDate, formatter);
            YearMonth end = YearMonth.parse(endDate, formatter);
            if (start.isAfter(end)) {
                throw new IllegalArgumentException("开始日期不能晚于结束日期");
            }

            while (!start.isAfter(end)) {
                yearMonths.add(start.toString());
                start = start.plusMonths(1);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("日期格式不正确，正确格式为 yyyy-MM");
        }

        return yearMonths;
    }
}
