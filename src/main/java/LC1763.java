/**
 * Leetcode1763题，最长的美好子字符串
 * 关键字：字符串、哈希、位运算、滑动窗口
 * 主要思路：
 * 1. 遍历每一个子串
 * 2. 每次遍历记录到两个int变量中，按位记录
 * 3. 如果两个变量相等，且当前长度大于记录长度，更新长度和起始坐标记录
 */
public class LC1763 {
    public String longestNiceSubstring(String s) {
        int maxLen = 0;
        int maxPos = 0;
        for(int i = 0; i < s.length() ; i++) {
            int lower = 0;
            int upper = 0;
            for(int j = i; j < s.length(); j++) {
                if(Character.isUpperCase(s.charAt(j))) {
                    upper |= 1 << (s.charAt(j) - 'A');
                } else {
                    lower |= 1 << (s.charAt(j) - 'a');
                }
                if(upper == lower && j - i + 1 > maxLen) {
                    maxLen = j-i+1;
                    maxPos = i;
                }
            }

        }
        return s.substring(maxPos,maxPos + maxLen);
    }
}
