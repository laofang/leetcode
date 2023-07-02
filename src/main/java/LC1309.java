/**
 * Leetcode1309题，解码字母到整数映射
 * 关键字：字符串
 * 主要思路：
 * 1. 按规则模拟转化
 */
public class LC1309 {
    public String freqAlphabets(String s) {
        char[] chs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = chs.length - 1;
        while(i >= 0) {
            if(chs[i] == '#') {
                sb.insert(0,(char)('a' - 1 + Integer.valueOf(s.substring(i-2,i))));
                i -= 3;
            } else {
                sb.insert(0,(char)('a' - 1 + Integer.valueOf(s.substring(i,i+1))));
                i--;
            }
        }
        return sb.toString();
    }
}
