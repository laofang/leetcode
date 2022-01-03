/**
 * Leetcode1185题，一周中的第几天
 * 关键字: 数学、日期
 * 主要思路：
 * 1. 查了一下，已知1971年1月1日是周五
 * 2. 计算给定的日期距离1970年12月31日的天数
 * 3. 从1971加到year前的日期，闰年+366，非闰年+365
 * 4. 再处理year年份的月份日期，加到给定月之前，注意闰年
 * 5. 日期天数，直接加就可以
 * 6. 总天数 % 7 ，整除就是周四，余1是周五，例如1971.1.1就是周五，days=1
 */
public class LC1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        //根据1970.12.31周四开始的循环
        String[] week = new String[]{"Thursday","Friday","Saturday","Sunday","Monday","Tuesday","Wednesday"};
        int days = yearDays(year) + monthDays(month,year) + dayDays(day);
        return week[days % 7];
    }
    //求给定年份之前，一直到1971年的天数
    public int yearDays(int year) {
        int days = 0;
        for(int y = 1971; y < year; y++) {
            if( ( y % 400 == 0) || (y % 4 == 0 && y % 100 !=0)) {
                days += 366;
            } else {
                days += 365;
            }
        }
        return days;
    }
    //给定月份之前，一直到一月的天数，year当前年份
    public int monthDays(int month,int year) {
        boolean isRun = false;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            isRun = true;
        }
        int days = 0;
        switch (month) {
            case 12:
                days += 30;
            case 11:
                days += 31;
            case 10:
                days += 30;
            case 9:
                days += 31;
            case 8:
                days +=31;
            case 7:
                days += 30;
            case 6:
                days += 31;
            case 5:
                days += 30;
            case 4:
                days += 31;
            case 3:
                if(isRun) {
                    days += 29;
                } else{
                    days += 28;
                }
            case 2:
                days += 31;
            case 1:
                return days;
            default:
                return days;
        }
    }
    //当前月的天数，即使当前日期
    public int dayDays(int day) {
        return day;
    }
}
