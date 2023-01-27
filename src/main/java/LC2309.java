/**
 * Leetcode2309题，兼具大小写的最好英文字母
 * 关键字：哈希表、字符串、枚举
 * 主要思路：
 * 1. 连个数组，分别记录出现的小写和大写字母
 * 2. 然后从后向前遍历，如果当前遍历的字母的大小写都存在，就输出这个字母的大写
 */
public class LC2309 {
    public String greatestLetter(String s) {
        int[] upper = new int[26];
        int[] lower = new int[26];
        for(int i = 0;i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'Z') {
                upper[ch - 'A'] = 1;
            }
            if(ch >= 'a' && ch <= 'z') {
                lower[ch - 'a'] = 1;
            }
        }
        for(int i = upper.length-1; i >= 0; i--) {
            if(upper[i] == 1 && lower[i] == 1) {
                return String.valueOf((char)('A' + i));
            }
        }
        return "";
    }
}
