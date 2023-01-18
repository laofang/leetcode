/**
 * Leetcode551题，学生出勤记录I
 * 关键字：字符串
 * 主要思路：
 * 1. 对缺勤进行统计，对迟到进行检查是否有连续三次
 */
public class LC551 {
    public boolean checkRecord(String s) {
        int cnt = 0;
        if(s.length() >= 2) {
            if(s.charAt(0) == 'A') ++cnt;
            if(s.charAt(1) == 'A') ++cnt;
        }
        for(int i = 2; i < s.length();i++) {
            if(s.charAt(i) == 'L') {
                if(s.charAt(i-1) == 'L' && s.charAt(i-2) == 'L') return false;
            }
            if(s.charAt(i) == 'A') ++cnt;
            if(cnt > 1) return false;
        }
        if(cnt > 1) return false;
        return true;
    }
}
