/**
 * Leetcode2496题，数组中字符串的最大值
 * 关键字： 数组、字符串
 * 主要思路：
 * 1. 判断字符串是否全数字，选出最大的值
 */
public class LC2496 {
    public int maximumValue(String[] strs) {
        int ans = 0;
        for(String str : strs) {
            boolean isAllDigit = true;
            char[] chs = str.toCharArray();
            for(char ch : chs) {
                if(Character.isDigit(ch)) continue;
                isAllDigit = false;
            }
            ans = Math.max(ans,isAllDigit ? Integer.valueOf(str) : chs.length);
        }
        return ans;
    }
}
