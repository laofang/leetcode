/**
 * Leetcode1154题，一年中的第几天
 * 关键字：数组、数学
 * 主要思路：
 * 1. 1、3、5、7、8、10、12月都有31天
 * 2. 4、6、9、11月都有30天
 * 3. 2月闰年29天，非闰年28天
 * 4、闰年：可被4整除且不能被100整除的年份，或可以被400整除的年份
 */
public class LC1154 {    public int dayOfYear(String date) {
    String[] dates = date.split("-");
    return monthDays(Integer.valueOf(dates[0]),Integer.valueOf(dates[1]) - 1) + Integer.valueOf(dates[2]);
}

    public int monthDays(int year,int month) {
        if (month == 0) {
            return 0;
        }
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 ) {
            return 31 + monthDays(year,month - 1);
        } else if(month == 4 || month == 6 || month == 9 || month == 11) {
            return 30 + monthDays(year,month - 1);
        } else {
            if( (year % 100 != 0 && year % 4 == 0) || year % 400 == 0) {
                return 29 + monthDays(year, month - 1);
            } else {
                return 28 + monthDays(year,month - 1);
            }
        }
    }
}
