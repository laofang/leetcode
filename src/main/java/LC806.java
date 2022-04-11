/**
 * Leetcode806题，写字符串需要的行数
 * 关键字：数组、字符串
 * 主要思路：
 * 1. 循环统计计数，如果加到当前字符>100，那就从这个字符开始，从新计数，并记录行数
 */
public class LC806 {
    public int[] numberOfLines(int[] widths, String s) {
        int[] ans = new int[2];
        int i = 0;
        while(i < s.length()) {
            int count = 0;
            while(i < s.length() && count + widths[s.charAt(i)-'a'] <= 100) {
                count += widths[s.charAt(i)-'a'];
                i++;
            }
            ++ans[0];
            ans[1] = count;
        }
        return ans;
    }
}
