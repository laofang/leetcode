import java.util.Arrays;

/**
 * Leetcode937题，重新排列日志文件
 * 关键字：数组、字符串、比较器
 * 主要思路:
 * 1. 这道题主要思考的就是比较器如何实现
 * 2. 根据规则，都是数字，返回0，表示位置不变
 * 3. 如果是字符，相等对标识符用compareTo对比，不相等，标识符后面内容compareTo方法对比
 * 4. 如果是字符和数字，字符在前
 * 注意：
 * 比较器的返回值，0表示位置不变，正数表示位置交换，负数表示位置不交换
 */
public class LC937 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(s1, s2)->{

            int pos1 = s1.indexOf(" ");
            int pos2 = s2.indexOf(" ");

            boolean s1IsDigit = Character.isDigit(s1.charAt(pos1+1));
            boolean s2IsDigit = Character.isDigit(s2.charAt(pos2+1));

            if(s1IsDigit && s2IsDigit) {
                return 0;
            } else if(!s1IsDigit && !s2IsDigit) {
                String s12 = s1.substring(pos1+1);
                String s22 = s2.substring(pos2+1);
                if(s12.equals(s22)) {
                    String s11 = s1.substring(0,pos1);
                    String s21 = s2.substring(0,pos2);
                    return s11.compareTo(s21);
                } else {
                    return s12.compareTo(s22);
                }
            } else if(s1IsDigit) {
                return 1;
            } else {
                return -1;
            }
        });
        return logs;
    }
}
