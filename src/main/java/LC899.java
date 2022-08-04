import java.util.Arrays;

/**
 * Leetcode899题，有序队列
 * 关键字：数字、字符串、排序
 * 主要思路：
 * 1. 分为两种情况
 * 2. k==1时，把字符串看成是一个环，尝试以每个字符为头，获得最小字典顺序的字符串
 * 3. k > 1时，通过不断交换，可以把整个字符串排成字典顺序字符串
 */
public class LC899 {
    public String orderlyQueue(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        String str = s;
        if(k == 1) {
            for(int i = 0; i < s.length();i++) {
                char ch = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(ch);
                if(sb.toString().compareTo(str) < 0) {
                    str = sb.toString();
                }
            }
            return str;
        } else {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            return new String(chs);
        }
    }
}
