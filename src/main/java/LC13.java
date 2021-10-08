import java.util.HashMap;

/**
 * Leetcode第是三题，罗马数字转整数
 * 主要思路：
 * 1. 每个罗马数字字符对应一个值，从左向右扫描，如果小于右侧的值则减去当前的值，否则结果加上当前的值
 * 用时：6min52s
 */
public class LC13 {
    public int romanToInt(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);

        char[] chars = s.toCharArray();
        int r = 0;
        for (int i = 0; i < chars.length; i++) {
            //i + 1不要过界
            if(i + 1 < chars.length && hm.get(chars[i+1]) > hm.get(chars[i])) {
                r -= hm.get(chars[i]);
                continue;
            }
            r += hm.get(chars[i]);
        }
        return r;
    }
}
