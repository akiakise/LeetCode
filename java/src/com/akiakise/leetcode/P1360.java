package com.akiakise.leetcode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * https://leetcode.com/problems/number-of-days-between-two-dates/
 */
public class P1360 {
    /*
    暴力求解，年月日转换为时间戳，然后时间戳之差除以一天的时间即可
     */
    public int daysBetweenDates(String date1, String date2) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = df.parse(date1);
            Date d2 = df.parse(date2);
            return (int) Math.abs((d2.getTime() - d1.getTime()) / 86400000);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /*
    计算求解，分别计算出 date1、date2 距离 1970-01-01 的天数，然后求两个天数的差值的绝对值即可。
    结果：耗时 1ms，比 93.73% 的 Java 解法快。

    date1 距离 1970-01-01 的天数计算逻辑：
    1. 年份，计算除了 date1 这一年之外，其他年份距离 1970-01-01 的天数，不是 365 就是 366，通过是否是闰年判断
    2. 月份，计算除了 date1 这一月份外，今年已经过去的天数，通过预定义的月份表，查表即可。
    如果月份大于2且今年是闰年，整体天数加1.
    3. 天数，计算 date1 这一月份已经过去的天数，直接加上即可。
     */
    public int daysBetweenDates_Calc(String date1, String date2) {
        return Math.abs(daysSinceEpoch(date1) - daysSinceEpoch(date2));
    }

    private static final int[] monthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private boolean leap(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    private int daysSinceEpoch(String date) {
        String[] split = date.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        int days = 0;
        // 今年之前的天数
        for (int i = 1970; i < year; i++) {
            days += leap(i) ? 366 : 365;
        }
        // 这个月之前的天数
        for (int i = 1; i < month; i++) {
            days += monthDays[i - 1];
        }
        /// 考虑闰年
        days += (month > 2 && leap(year)) ? 1 : 0;
        // 这个月的天数
        days += day;
        return days;
    }

    public static void main(String[] args) {
        P1360 p = new P1360();
        System.out.println(p.daysBetweenDates_Calc("2019-06-29", "2019-06-30"));
        System.out.println(p.daysBetweenDates_Calc("2020-01-15", "2019-12-31"));
        System.out.println(p.daysBetweenDates("2020-01-15", "2019-12-31"));
        System.out.println(p.daysBetweenDates("2020-01-15", "2019-12-31"));
    }
}
