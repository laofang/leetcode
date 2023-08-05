/**
 * Leetcode1844题，将所有数字用字符替换
 * 关键字：字符串
 * 主要思路：
 * 1. 分奇偶，在基础的字符上进行偏移
 */
public class LC1844 {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length; i++) {
            if(i % 2 == 0) {
                sb.append(chs[i]);
            } else {
                sb.append(shift(chs[i-1],chs[i] - '0'));
            }
        }
        return sb.toString();
    }
    public char shift(char ch, int num) {
        return (char) (ch + num);
    }
}
