/**
 * Leetcode459题，重复的子字符串
 * 关键字：字符串、字符串匹配
 * 主要思路：
 * 1. 尝试将匹配字符串不同等分，然后用等分的部分去进行匹配
 */
public class LC459 {
    public boolean repeatedSubstringPattern(String s) {
        char[] chs = s.toCharArray();
        for(int i = 2; i <= s.length();i++) {
            if(s.length() % i == 0) {
                int length = s.length() / i;
                String str = s.substring(0,length);
                int j = 0;
                while(j < s.length()) {
                    int m = 0;
                    while(j < s.length() && m < str.length()) {
                        if(chs[j] != str.charAt(m)) {
                            break;
                        }
                        j++;
                        m++;
                    }
                    if(j == s.length()) return true;
                    if(m != str.length()) break;
                }
            }
        }
        return false;
    }
}
